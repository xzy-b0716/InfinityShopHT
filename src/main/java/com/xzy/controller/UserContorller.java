package com.xzy.controller;

import com.xzy.beans.User;
import com.xzy.common.Cont;
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
@RequestMapping(value = "/user/")
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
     * 修改用户昵称
     *
     * @param session
     * @param real
     * @return
     */
    @RequestMapping(value = "updateUserReal.do", method = RequestMethod.POST)
    public int updateUserReal(HttpSession session, String real) {
        User user1 = (User) session.getAttribute(Cont.CURRENT_USER);
        if (user1 == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        user1.setUserReal(real);

        Integer updateReal = userService.updateReal(user1);
        return updateReal;
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

    /**
     * 修改邮箱
     *
     * @param session
     * @param email
     * @return
     */
    @RequestMapping(value = "updateUserEmail.do", method = RequestMethod.POST)
    public int updateUserEmail(HttpSession session, String email) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        int updateEmail = userService.updateEmail(user.getUserId(), email);
        return updateEmail;
    }

    /**
     * 修改电话号码
     *
     * @param session
     * @param userTel
     * @return
     */
    @RequestMapping(value = "updateUserTel.do", method = RequestMethod.POST)
    public int updateUserTel(HttpSession session, String userTel) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        int updateTel = userService.updateTel(user.getUserId(), userTel);
        return updateTel;
    }

    /**
     * 修改生日
     *
     * @param session
     * @param userBirth
     * @return
     */
    @RequestMapping(value = "updateBirth.do", method = RequestMethod.POST)
    public int updateBirth(HttpSession session, Date userBirth) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        int updateBirth = userService.updateUserBirth(user.getUserId(), userBirth);
        return updateBirth;
    }

    /**
     * 修改性别
     *
     * @param session
     * @param userSex
     * @return
     */
    @RequestMapping(value = "updateSex.do", method = RequestMethod.POST)
    public int updateSex(HttpSession session, String userSex) {
        User user = getUser(session);
        if (user == null) {
            throw new InfintyException("当前用户不存在或未登录");
        }
        int updateSex = userService.updateUserSex(user.getUserId(), userSex);
        return updateSex;
    }

}
