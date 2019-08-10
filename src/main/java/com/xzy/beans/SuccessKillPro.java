package com.xzy.beans;

import java.util.Date;

/**
 * @author cairunduo
 * @date 2019/8/6 - 23:26
 */
public class SuccessKillPro {
    private Integer userId;
    private Integer seckillState;
    private Integer productId;
    private Date createTime;
    private float seckillPrice;
    private String productPicture;
    private String productName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeckillState() {
        return seckillState;
    }

    public void setSeckillState(Integer seckillState) {
        this.seckillState = seckillState;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(float seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
