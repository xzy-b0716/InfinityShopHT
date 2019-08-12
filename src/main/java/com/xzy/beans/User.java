package com.xzy.beans;

import java.util.Date;

public class User {

    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userTel;

    private Date userBirth;

    private Date userCreat;

    private String userReal;

    private String userSex;

    private String userPic;

    private String userBackground;

    public String getUserBackground() {
        return userBackground;
    }

    public void setUserBackground(String userBackground) {
        this.userBackground = userBackground;
    }

    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public String getUserPassword() {
        return userPassword;
    }


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }


    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }


    public String getUserTel() {
        return userTel;
    }


    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }


    public Date getUserBirth() {
        return userBirth;
    }


    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }


    public Date getUserCreat() {
        return userCreat;
    }



    public String getUserReal() {
        return userReal;
    }


    public void setUserReal(String userReal) {
        this.userReal = userReal == null ? null : userReal.trim();
    }


    public String getUserSex() {
        return userSex;
    }


    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }


    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
}