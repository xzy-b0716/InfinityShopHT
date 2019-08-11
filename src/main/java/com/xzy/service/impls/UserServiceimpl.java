package com.xzy.service.impls;

import com.xzy.beans.User;
import com.xzy.mapper.UserMapper;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService
{
    @Resource
    private UserMapper usermapper;

    @Override
    public User getuserbyid(Integer userId) {
        return usermapper.getUserById(userId);
    }
}
