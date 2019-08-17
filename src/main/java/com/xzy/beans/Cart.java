package com.xzy.beans;

public class Cart {
    private Integer cartId;

    private Integer quantity;

    private Integer checked;

    private Integer productId;

    private Integer userId;

    private Integer isAlive;

    private String cpProductSize;

    private String cpProductColor;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}