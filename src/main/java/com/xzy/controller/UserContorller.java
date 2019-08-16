package com.xzy.controller;

import com.xzy.beans.User;
import com.xzy.common.Cont;
import com.xzy.common.ResponseCode;
import com.xzy.common.ServerResponse;
import com.xzy.exception.InfintyException;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author shixiao
 * @date 2019/8/3 - 15:23
 */
@RestController
public class UserContorller {

    @Autowired
    private UserService userService;

    /**
     * 根据session用户的信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/getUser.do",method = RequestMethod.POST)
    public ServerResponse<User> getUser(HttpSession session){
        User user = (User) session.getAttribute(Cont.CURRENT_USER);
        if (user!= null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录无法获取用户的信息");
    }

    /**
     * 登录状态重置密码
     * @param session
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @RequestMapping(value = "/resetPassword.do",method = RequestMethod.POST)
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        User user = (User) session.getAttribute(Cont.CURRENT_USER);
        if (user == null){
            ServerResponse.createByErrorMessage("用户为登录");
        }
        ServerResponse<String> resetPassword = userService.resetPassword(passwordOld, passwordNew, user);
        return resetPassword;
    }

    /**
     * 修改个人信息
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserInfo.do",method = RequestMethod.POST)
    public ServerResponse<User> updateUserInfo(HttpSession session,User user){
        User currentUser = (User) session.getAttribute(Cont.CURRENT_USER);
        if (currentUser == null){
            ServerResponse.createByErrorMessage("用户为登录");
        }
        user.setUserId(currentUser.getUserId());
        user.setUserName(currentUser.getUserName());
        ServerResponse<User> userInfo = userService.updateUserInfo(user);
        if (userInfo.isSuccess()){
            userInfo.getData().setUserName(currentUser.getUserName());
            session.setAttribute(Cont.CURRENT_USER,userInfo.getData());
        }
        return userInfo;
    }

    @RequestMapping(value = "/getUserInfo.do",method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession session){
        User currentUser = (User) session.getAttribute(Cont.CURRENT_USER);
        if (currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录，需要强制登录status=10");
        }
        ServerResponse<User> information = userService.getInformation(currentUser.getUserId());
        return information;
    }

    /**
     * 修改头像
     * @param session
     * @param picFile
     * @return
     */
    @RequestMapping(value = "/updateUserPic.do",method = RequestMethod.POST)
    public Object updateUserPic(HttpSession session , MultipartFile picFile){
        ServerResponse<User> user = getUser(session);
        if (user==null){
            throw new InfintyException("当前用户不存在或未登录");
        }
        Map<String, Object> map = userService.userPicUpload(picFile, user.getData().getUserId());
        return map;
    }
}
