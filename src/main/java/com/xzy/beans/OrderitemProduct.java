package com.xzy.beans;

public class OrderitemProduct {
    private Integer orderitemId;
    private Integer oiProductNum;
    private Float oiTotalPrice;
    private Integer productId;
    private Integer ordersId;
    private String oiProductSize;
    private String oiProductColor;
    private String productName;
    private String productPicture;

    public Integer getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(Integer orderitemId) {
        this.orderitemId = orderitemId;
    }

    public Integer getOiProductNum() {
        return oiProductNum;
    }

    public void setOiProductNum(Integer oiProductNum) {
        this.oiProductNum = oiProductNum;
    }

    public Float getOiTotalPrice() {
        return oiTotalPrice;
    }

    public void setOiTotalPrice(Float oiTotalPrice) {
        this.oiTotalPrice = oiTotalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getOiProductSize() {
        return oiProductSize;
    }

    public void setOiProductSize(String oiProductSize) {
        this.oiProductSize = oiProductSize;
    }

    public String getOiProductColor() {
        return oiProductColor;
    }

    public void setOiProductColor(String oiProductColor) {
        this.oiProductColor = oiProductColor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }
}
