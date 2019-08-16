package com.xzy.service;

import com.xzy.beans.User;
import com.xzy.common.ServerResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * 用户管理Service
 * @author shixiao
 * @date 2019/8/3 - 15:24
 */
public interface UserService {

    //用户登录
    ServerResponse<User> login(String userName, String userPassword);

    //用户通过邮箱登录
    ServerResponse<User> loginByEmail(String userEmail, String userPassword);

    //用户通过电话登录
    ServerResponse<User> loginByTel(String userTel, String userPassword);

    //注册
    ServerResponse<String> register(User user);
}
