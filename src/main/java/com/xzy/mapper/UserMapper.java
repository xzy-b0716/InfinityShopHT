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

    //查用户
    int checkUserName(String userName);

    //查邮箱
    int checkUserEmail(String email);

    //用户查询
    User selectLogin(@Param("userName") String userName, @Param("userPassword")String userPassword);

    //用户邮箱查询
    User selectLoginByEmail(@Param("userEmail") String userEmail, @Param("userPassword")String userPassword);

    //查电话
    int checkUserTel(String userTel);

    //用户电话查询
    User selectLoginByTel(@Param("userTel") String userTel, @Param("userPassword")String userPassword);
}