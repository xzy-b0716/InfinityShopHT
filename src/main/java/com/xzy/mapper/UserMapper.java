package com.xzy.mapper;

import com.xzy.beans.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    User getUserById(Integer userId);



    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String userName);

    User selectLogin(@Param("userName") String userName, @Param("userPassword")String userPassword);

    /**
     * 根据userId更新头像
     * @param user
     * @returne
     */
    int updatePicByUserId(User user);

    /**
     * 根据userId修改昵称
     * @param user
     * @return
     */
    int updateRealByUserId(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int updatePasswordByUsrId(User user);

}