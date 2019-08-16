package com.xzy.service.serviceImp;

import com.xzy.beans.User;
import com.xzy.common.ServerResponse;
import com.xzy.config.PreReadUploadConfig;
import com.xzy.exception.InfintyException;
import com.xzy.mapper.UserMapper;
import com.xzy.service.UserService;
import com.xzy.util.MD5Util;
import com.xzy.utils.FileTool;
import org.apache.commons.lang3.StringUtils;
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
        user.setUserPassword(StringUtils.EMPTY);
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
        user.setUserPassword(StringUtils.EMPTY);
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
        user.setUserPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);
    }

    //注册
    @Override
    public ServerResponse<String> register(User user){
        int resultCount = userMapper.checkUserTel(user.getUserName());
        if(resultCount > 0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        resultCount = userMapper.checkUserEmail(user.getUserEmail());
        if(resultCount > 0){
            return ServerResponse.createByErrorMessage("邮箱已存在");
        }
        //MD5加密
        user.setUserPassword(MD5Util.MD5EncodeUtf8(user.getUserPassword()));
        resultCount = userMapper.insert(user);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

}
