package com.xzy.beans;

import java.util.Date;

public class Seckill {
    private Integer seckillId;
    private String seckillTitle;
    private Float seckillPrice;
    private Date seckillStartTime;
    private Date seckillEndTime;
    private Date seckillCreateTime;
    private Integer seckillStock;
    private Integer productId;

    public Integer getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Integer seckillId) {
        this.seckillId = seckillId;
    }

    public String getSeckillTitle() {
        return seckillTitle;
    }

    public void setSeckillTitle(String seckillTitle) {
        this.seckillTitle = seckillTitle;
    }

    public Float getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Float seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Date getSeckillStartTime() {
        return seckillStartTime;
    }

    public void setSeckillStartTime(Date seckillStartTime) {
        this.seckillStartTime = seckillStartTime;
    }

    public Date getSeckillEndTime() {
        return seckillEndTime;
    }

    public void setSeckillEndTime(Date seckillEndTime) {
        this.seckillEndTime = seckillEndTime;
    }

    public Date getSeckillCreateTime() {
        return seckillCreateTime;
    }

    public void setSeckillCreateTime(Date seckillCreateTime) {
        this.seckillCreateTime = seckillCreateTime;
    }

    public Integer getSeckillStock() {
        return seckillStock;
    }

    public void setSeckillStock(Integer seckillStock) {
        this.seckillStock = seckillStock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}