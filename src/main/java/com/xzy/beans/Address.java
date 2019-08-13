package com.xzy.beans;

public class Address {

    private Integer addressId;

    private String addressUserName;

    private String addressUserTel;

    private String addressA;

    private String addressPcode;

    private Boolean addressDefalut;

    private Integer userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressUserName() {
        return addressUserName;
    }

    public void setAddressUserName(String addressUserName) {
        this.addressUserName = addressUserName == null ? null : addressUserName.trim();
    }

    public String getAddressUserTel() {
        return addressUserTel;
    }

    public void setAddressUserTel(String addressUserTel) {
        this.addressUserTel = addressUserTel == null ? null : addressUserTel.trim();
    }

    public String getAddressA() {
        return addressA;
    }

    public void setAddressA(String addressA) {
        this.addressA = addressA == null ? null : addressA.trim();
    }

    public String getAddressPcode() {
        return addressPcode;
    }

    public void setAddressPcode(String addressPcode) {
        this.addressPcode = addressPcode == null ? null : addressPcode.trim();
    }

    public Boolean getAddressDefalut() {
        return addressDefalut;
    }

    public void setAddressDefalut(Boolean addressDefalut) {
        this.addressDefalut = addressDefalut;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}