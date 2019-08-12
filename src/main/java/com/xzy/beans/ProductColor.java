package com.xzy.beans;

/**
 * Create by Shuai on 2019/8/4 17:14
 */
public class ProductColor {
    private Integer product_color_id;

    private Integer product_id;

    private String color;

    private boolean show = false;

    public Integer getProduct_color_id() {
        return product_color_id;
    }

    public void setProduct_color_id(Integer product_color_id) {
        this.product_color_id = product_color_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
