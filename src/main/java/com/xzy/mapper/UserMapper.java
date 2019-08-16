package com.xzy.mapper;

import com.xzy.beans.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String userName);

    /**
     * 根据userId更新头像
     * @param user
     * @returne
     */
    int updatePicByUserId(User user);

    int checkPassword(@Param("userPassword") String userPassword,@Param("userId") Integer userId);

    int checkEmailByUserId(@Param("userEmail")String userEmail,@Param("userId")Integer userId);
}