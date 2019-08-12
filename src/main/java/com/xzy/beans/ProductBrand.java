package com.xzy.beans;

/**
 * Create by Shuai on 2019/8/12 21:12
 */
public class ProductBrand {
    private String name="品牌";
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "ProductBrand{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
