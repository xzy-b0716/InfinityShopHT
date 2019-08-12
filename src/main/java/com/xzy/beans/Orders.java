package com.xzy.beans;

import java.util.Date;

public class Orders {

    private Integer ordersId;
    private Float ordersTotalPrice;
    private Integer ordersPayStatus;
    private Integer ordersSendStatus;
    private Integer ordersGetStatus;
    private Date ordersCreateTime;
    private Date ordersSendTime;
    private Date ordersGetTime;
    private Integer userId;
    private Integer addressId;

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Float getOrdersTotalPrice() {
        return ordersTotalPrice;
    }

    public void setOrdersTotalPrice(Float ordersTotalPrice) {
        this.ordersTotalPrice = ordersTotalPrice;
    }

    public Integer getOrdersPayStatus() {
        return ordersPayStatus;
    }

    public void setOrdersPayStatus(Integer ordersPayStatus) {
        this.ordersPayStatus = ordersPayStatus;
    }

    public Integer getOrdersSendStatus() {
        return ordersSendStatus;
    }

    public void setOrdersSendStatus(Integer ordersSendStatus) {
        this.ordersSendStatus = ordersSendStatus;
    }

    public Integer getOrdersGetStatus() {
        return ordersGetStatus;
    }

    public void setOrdersGetStatus(Integer ordersGetStatus) {
        this.ordersGetStatus = ordersGetStatus;
    }

    public Date getOrdersCreateTime() {
        return ordersCreateTime;
    }

    public void setOrdersCreateTime(Date ordersCreateTime) {
        this.ordersCreateTime = ordersCreateTime;
    }

    public Date getOrdersSendTime() {
        return ordersSendTime;
    }

    public void setOrdersSendTime(Date ordersSendTime) {
        this.ordersSendTime = ordersSendTime;
    }

    public Date getOrdersGetTime() {
        return ordersGetTime;
    }

    public void setOrdersGetTime(Date ordersGetTime) {
        this.ordersGetTime = ordersGetTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", ordersTotalPrice=" + ordersTotalPrice +
                ", ordersPayStatus=" + ordersPayStatus +
                ", ordersSendStatus=" + ordersSendStatus +
                ", ordersGetStatus=" + ordersGetStatus +
                ", ordersCreateTime=" + ordersCreateTime +
                ", ordersSendTime=" + ordersSendTime +
                ", ordersGetTime=" + ordersGetTime +
                ", userId=" + userId +
                ", addressId=" + addressId +
                '}';
    }
}