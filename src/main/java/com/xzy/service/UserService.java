package com.xzy.service;

import com.xzy.beans.User;
import com.xzy.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 用户管理Service
 * @author shixiao
 * @date 2019/8/3 - 15:24
 */
public interface UserService {

    /**
     * 根据userName获取会员
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据id获取User
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);


    /**
     * 用户头像上传
     * @param file
     * @param userId
     * @return
     */
    Map<String,Object> userPicUpload(MultipartFile file,Integer userId);

    /**
     * 根据userId修改图片地址
     * @param UserPic
     * @param userId
     * @return
     */
    int updatePic(String UserPic,Integer userId);

    /**
     * 登录用户重置密码
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新个人信息
     * @param user
     * @return
     */
    ServerResponse<User> updateUserInfo(User user);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);

}
