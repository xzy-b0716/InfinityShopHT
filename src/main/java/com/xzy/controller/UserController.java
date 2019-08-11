package com.xzy.controller;

import com.xzy.beans.User;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService userservice;
    @RequestMapping("user/{userId}")
    public User get(@PathVariable("userId") Integer userId)
    {
       return  userservice.getuserbyid(userId);
    }

}
