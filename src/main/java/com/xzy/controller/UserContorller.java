package com.xzy.controller;

import com.xzy.beans.User;
import com.xzy.common.Cont;
import com.xzy.common.ServerResponse;
import com.xzy.exception.InfintyException;
import com.xzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @author shixiao
 * @date 2019/8/3 - 15:23
 */
@RestController
@RequestMapping("/user/")
public class UserContorller {

    @Autowired
    private UserService userService;

    /**
     * 获取当前用户的信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "getUser.do", method = RequestMethod.POST)
    public User getUser(HttpSession session) {

        User user = (User) session.getAttribute(Cont.CURRENT_USER);
        if (user != null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        return user;
    }

    //用户登录
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = userService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Cont.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 修改头像
     *
     * @param session
     * @param picFile
     * @return
     */
    @RequestMapping(value = "updateUserPic.do", method = RequestMethod.POST)
    public Object updateUserPic(HttpSession session, MultipartFile picFile) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }

        Map<String, Object> map = userService.userPicUpload(picFile, user.getUserId());
        return map;
    }



    /**
     * 修改密码
     *
     * @param session
     * @param password
     * @return
     */
    @RequestMapping(value = "updateUserPwd.do", method = RequestMethod.POST)
    public int updateUserPwd(HttpSession session, String password) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        Integer updatePassword = userService.updatePassword(password, user.getUserId());
        return updatePassword;
    }


    //用户通过邮箱登录
    @RequestMapping(value = "loginbyemail.do",method = RequestMethod.POST)
    public ServerResponse<User> loginByEmail(String email, String password, HttpSession session){
        ServerResponse<User> response = userService.loginByEmail(email,password);
        if(response.isSuccess()){
            session.setAttribute(Cont.CURRENT_USER,response.getData());
        }
        return response;
    }

    //用户通过电话登录
    @RequestMapping(value = "loginbytel.do",method = RequestMethod.POST)
    public ServerResponse<User> loginByTel(String userTel, String userPassword, HttpSession session){
        ServerResponse<User> response = userService.loginByTel(userTel,userPassword);
        if(response.isSuccess()){
            session.setAttribute(Cont.CURRENT_USER,response.getData());
        }
        return response;
    }


    //退出功能
    @RequestMapping(value = "logout.do",method = RequestMethod.GET)
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Cont.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    //注册接口
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public ServerResponse<String> register(User user){
        return userService.register(user);
    }

}
