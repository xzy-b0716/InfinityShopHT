package com.xzy.beans;

import java.util.List;

public class OrderEst {
    private List<OrderitemProduct> op;
    private int OrdersNumber;
    private int OrderitemNumber;

    public List<OrderitemProduct> getOp() {
        return op;
    }

    public void setOp(List<OrderitemProduct> op) {
        this.op = op;
    }

    public int getOrdersNumber() {
        return OrdersNumber;
    }

    public void setOrdersNumber(int ordersNumber) {
        OrdersNumber = ordersNumber;
    }

    public int getOrderitemNumber() {
        return OrderitemNumber;
    }

    public void setOrderitemNumber(int orderitemNumber) {
        OrderitemNumber = orderitemNumber;
    }
}
