package com.xzy.service.impls;

import com.xzy.beans.Cart;
import com.xzy.beans.CartItem;
import com.xzy.mapper.CartMapper;
import com.xzy.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceimpl implements CartService {
    @Resource
    private CartMapper cartmapper;
    @Override
    public List<CartItem> selectAllCartItemByOneUser(Integer userId) {
        return cartmapper.selectAllCartItemByOneUser(userId);
    }

    @Override
    public void deleteCartItem(Map map) {
        cartmapper.deleteCartItem(map);
    }

    @Override
    public void insertCartItem(Cart cart) {
        cartmapper.insertCartItem(cart);
    }

    @Override
    public void updateQuantity(Cart cart) {
     cartmapper.updateQuantity(cart);
    }

    @Override
    public List<Cart> selectCart(Integer userId) {
        return cartmapper.selectCart(userId);
    }


}
