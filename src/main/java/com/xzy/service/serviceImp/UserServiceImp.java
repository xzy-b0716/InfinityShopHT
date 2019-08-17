package com.xzy.service.serviceImp;

import com.xzy.beans.User;
import com.xzy.common.ServerResponse;
import com.xzy.config.PreReadUploadConfig;
import com.xzy.exception.InfintyException;
import com.xzy.mapper.UserMapper;
import com.xzy.service.UserService;
import com.xzy.utils.MD5Util;
import com.xzy.utils.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shixiao
 * @date 2019/8/3 - 15:24
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PreReadUploadConfig uploadConfig;

    //用户登录
    @Override
    public ServerResponse<User> login(String userName, String userPassword){
        int resultCount = userMapper.checkUserName(userName);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        //todo 密码登录MD5
        String md5Password = MD5Util.MD5EncodeUtf8(userPassword);
        User user = userMapper.selectLogin(userName,md5Password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setUserPassword("");
        return ServerResponse.createBySuccess("登录成功",user);
    }

    //用户通过邮箱登录
    @Override
    public ServerResponse<User> loginByEmail(String userEmail, String userPassword){
        int resultCount = userMapper.checkUserEmail(userEmail);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        //todo 密码登录MD5
        String md5Password = MD5Util.MD5EncodeUtf8(userPassword);
        User user = userMapper.selectLoginByEmail(userEmail,md5Password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setUserPassword("");
        return ServerResponse.createBySuccess("登录成功",user);
    }

    //用户通过电话登录
    @Override
    public ServerResponse<User> loginByTel(String userTel, String userPassword){
        int resultCount = userMapper.checkUserTel(userTel);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        //todo 密码登录MD5
        String md5Password = MD5Util.MD5EncodeUtf8(userPassword);
        User user = userMapper.selectLoginByTel(userTel,md5Password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setUserPassword("");
        return ServerResponse.createBySuccess("登录成功",user);
    }

    @Override
    public int updatePic(String UserPic, Integer userId) {
        return 0;
    }

    //注册
    @Override
    public ServerResponse<String> register(User user) {
        int resultCount = userMapper.checkUserTel(user.getUserName());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        resultCount = userMapper.checkUserEmail(user.getUserEmail());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("邮箱已存在");
        }
        //MD5加密
        user.setUserPassword(MD5Util.MD5EncodeUtf8(user.getUserPassword()));
        resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    /**
     * 根据用户名获取会员     √
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user;
    }

    /**
     * 上传图片  √
     *
     * @param file
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> userPicUpload(MultipartFile file, Integer userId) {
        Map<String, Object> map = new HashMap<>();
        if (file == null) {
            throw new InfintyException("上传的图片为空");
        }

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new InfintyException("当前用户未登录或者不存在");
        }
        String fileName = file.getOriginalFilename();
        fileName = FileTool.renameToUUID(fileName);

        try {
            FileTool.uploadFiles(file.getBytes(), uploadConfig.getUploadPath(), fileName);
        } catch (IOException e) {
            if (fileName == null) {
                throw new InfintyException("头像名字为空");
            }
        }

        Map<String, Object> returnMap = new HashMap<>();
        String url = "/static/" + fileName;
        updatePic(url, userId);
        returnMap.put("imageUrl", url);
        return map;
    }

    /**
     * 登录用户更新密码
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    public ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user){
        //防止横向越权,要校验一下这个用户的旧密码,
        // 一定要指定是这个用户.因为我们会查询一个count(1),如果不指定id,
        // 那么结果就是true啦count>0;
        int resultCount = userMapper.checkPassword(passwordOld, user.getUserId());
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        user.setUserPassword(passwordNew);
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount>0){
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    /**
     * 更新个人信息
     * @param user
     * @return
     */
    public ServerResponse<User> updateUserInfo(User user){
        //username是不能被更新的
        /*
          email也要进行一个校验,校验新的email是不是已经存在,
          并且存在的email如果相同的话,不能是我们当前的这个用户的.
         */
        int resultCount = userMapper.checkEmailByUserId(user.getUserEmail(), user.getUserId());
        if (resultCount > 0 ){
            return ServerResponse.createByErrorMessage("email已存在,请更换email再尝试更新");
        }

        User updateUser = new User();
        updateUser.setUserId(user.getUserId());
        updateUser.setUserName(user.getUserName());
        updateUser.setUserEmail(user.getUserEmail());
        updateUser.setUserTel(user.getUserTel());
        updateUser.setUserBirth(user.getUserBirth());
        updateUser.setUserPic(user.getUserPic());
        updateUser.setUserReal(user.getUserReal());
        updateUser.setUserSex(user.getUserSex());
        updateUser.setUserBackground(user.getUserBackground());

        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0){
            return ServerResponse.createBySuccess("更新个人信息成功",updateUser);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    /**
     * 根据userId查询user信息
     * @param userId
     * @return
     */
    public ServerResponse<User> getInformation(Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        user.setUserPassword("");
        return ServerResponse.createBySuccess(user);
    }
}
