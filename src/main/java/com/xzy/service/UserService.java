package com.xzy.service;

import com.xzy.beans.User;
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
     * 根据userId修改密码
     * @param userId
     * @param userPassword
     * @return
     */
    @Transactional
    Integer updatePassword(String userPassword,Integer userId);

    /**
     * 修改昵称
     * @param user
     * @return
     */
    Integer updateReal(User user);

    /**
     * 修改邮箱
     * @param userId
     * @param userEmail
     * @return
     */
    int updateEmail(Integer userId,String userEmail);

    /**
     * 修改电话号码
     * @param userId
     * @param userTel
     * @return
     */
    int updateTel(Integer userId,String userTel);

    /**
     * 修改生日
     * @param userId
     * @param userBirth
     * @return
     */
    int updateUserBirth(Integer userId, Date userBirth);

    /**
     * 修改性别
     * @param userId
     * @param sex
     * @return
     */
    int updateUserSex(Integer userId,String sex);

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
}
