package com.xzy.service;

import com.xzy.beans.Cart;
import com.xzy.beans.CartItem;

import java.util.List;
import java.util.Map;

public interface CartService {
    public List<CartItem> selectAllCartItemByOneUser(Integer userId);
    public void deleteCartItem (Map map);
    public void insertCartItem(Cart cart) ;
    public void updateQuantity(Cart cart);
    public List<Cart> selectCart(Integer userId);
}
