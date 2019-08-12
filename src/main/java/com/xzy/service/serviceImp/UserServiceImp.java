package com.xzy.service.serviceImp;

import com.xzy.beans.User;
import com.xzy.config.PreReadUploadConfig;
import com.xzy.exception.InfintyException;
import com.xzy.mapper.UserMapper;
import com.xzy.service.UserService;
import com.xzy.utils.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
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
     * 根据userId获取会员      √
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserByUserId(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }


    /**
     * 修改密码   √
     *
     * @param userId
     * @param userPassword
     * @return
     */
    @Override
    public Integer updatePassword(String userPassword, Integer userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPassword(userPassword);
        int update = userMapper.updatePasswordByUsrId(user);
        return update;
    }

    /**
     * 修改昵称  √
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateReal(User user) {
        int update = userMapper.updateRealByUserId(user);
        return update;
    }

    /**
     * 修改邮箱
     *
     * @param userId
     * @param userEmail
     * @return
     */
    @Override
    public int updateEmail(Integer userId, String userEmail) {
        User user = new User();
        user.setUserId(userId);
        user.setUserEmail(userEmail);
        int update = userMapper.updateByPrimaryKeySelective(user);
        return update;
    }

    /**
     * 修改电话号码
     *
     * @param userId
     * @param userTel
     * @return
     */
    @Override
    public int updateTel(Integer userId, String userTel) {
        User user = new User();
        user.setUserId(userId);
        user.setUserTel(userTel);
        int update = userMapper.updateByPrimaryKeySelective(user);
        return update;
    }

    /**
     * 修改生日
     *
     * @param userId
     * @param userBirth
     * @return
     */
    @Override
    public int updateUserBirth(Integer userId, Date userBirth) {
        User user = new User();
        user.setUserId(userId);
        user.setUserBirth(userBirth);
        int update = userMapper.updateByPrimaryKeySelective(user);
        return update;
    }

    /**
     * 修改性别
     *
     * @param userId
     * @param sex
     * @return
     */
    @Override
    public int updateUserSex(Integer userId, String sex) {
        User user = new User();
        user.setUserId(userId);
        user.setUserSex(sex);
        int update = userMapper.updateByPrimaryKeySelective(user);
        return update;
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
     * 根据userId上传图片地址 √
     *
     * @param userPic
     * @param userId
     * @return
     */
    @Override
    public int updatePic(String userPic, Integer userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPic(userPic);
        int update = userMapper.updatePicByUserId(user);
        return update;
    }


}
