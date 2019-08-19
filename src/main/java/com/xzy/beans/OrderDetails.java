package com.xzy.beans;

import java.util.List;

public class OrderDetails {
    private List<OrderitemProduct> orderitemProductList;
    private int address;
    private float totalPri;

    public List<OrderitemProduct> getOrderitemProductList() {
        return orderitemProductList;
    }

    public void setOrderitemProductList(List<OrderitemProduct> orderitemProductList) {
        this.orderitemProductList = orderitemProductList;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public float getTotalPri() {
        return totalPri;
    }

    public void setTotalPri(float totalPri) {
        this.totalPri = totalPri;
    }
}
