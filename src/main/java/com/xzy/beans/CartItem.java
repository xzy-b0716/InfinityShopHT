package com.xzy.beans;

/*
 * 那么整个购物车就是由一条条的CartItem对象组成的集合*/
public class CartItem {
    private Integer cartId;

    private Integer userId;

    private Integer productId;

    private Integer quantity;//购物车中此商品的数量

    private Integer checked;//是否被选中

    private Integer isAlive;//软删除

    private String cpProductSize;//商品大小

    private String cpProductColor;//商品颜色

    private String productName;//商品的名字

    private Float productPrice;//这件产品的价格

    private String productPicture;//这件商品的图片

    private boolean ischecked;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    public String getCpProductSize() {
        return cpProductSize;
    }

    public void setCpProductSize(String cpProductSize) {
        this.cpProductSize = cpProductSize;
    }

    public String getCpProductColor() {
        return cpProductColor;
    }

    public void setCpProductColor(String cpProductColor) {
        this.cpProductColor = cpProductColor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", checked=" + checked +
                ", isAlive=" + isAlive +
                ", cpProductSize='" + cpProductSize + '\'' +
                ", cpProductColor='" + cpProductColor + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productPicture='" + productPicture + '\'' +
                ", ischecked=" + ischecked +
                '}';
    }
}

