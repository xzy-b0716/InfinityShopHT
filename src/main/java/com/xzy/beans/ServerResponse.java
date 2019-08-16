package com.xzy.beans;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cairunduo
 * @date 2019/8/16 - 13:25
 */
@Repository
public class ServerResponse {
    private boolean total;
    private List<CartItem> cartItems;

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "total=" + total +
                ", cartItems=" + cartItems +
                '}';
    }
}
