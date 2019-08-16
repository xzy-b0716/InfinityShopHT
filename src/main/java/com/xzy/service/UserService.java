package com.xzy.service;

import com.xzy.beans.User;
import com.xzy.common.ServerResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * 用户管理Service
 *
 * @author shixiao
 * @date 2019/8/3 - 15:24
 */
public interface UserService {

    /**
     * 根据userName获取会员
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据id获取User
     *
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);

    //用户登录
    ServerResponse<User> login(String userName, String userPassword);

    //用户通过邮箱登录
    ServerResponse<User> loginByEmail(String userEmail, String userPassword);

    //用户通过电话登录
    ServerResponse<User> loginByTel(String userTel, String userPassword);

    /**
     * 根据userId修改密码
     *
     * @param userId
     * @param userPassword
     * @return
     */
    @Transactional
    Integer updatePassword(String userPassword, Integer userId);

    /**
     * 用户头像上传
     *
     * @param file
     * @param userId
     * @return
     */
    Map<String, Object> userPicUpload(MultipartFile file, Integer userId);

    /**
     * 根据userId修改图片地址
     *
     * @param UserPic
     * @param userId
     * @return
     */
    int updatePic(String UserPic, Integer userId);

    //注册
    ServerResponse<String> register(User user);

}
