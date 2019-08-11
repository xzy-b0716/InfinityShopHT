package com.xzy.controller;

import com.xzy.beans.Cart;
import com.xzy.beans.CartItem;
import com.xzy.beans.User;
import com.xzy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartservice;
/*展示购物车里面的所有商品*/
    @RequestMapping(value = "/selectAllCartItem")
    @ResponseBody
    public List<CartItem> selectAllCartItem (Integer userId)
    {

        List<CartItem> cartItems = cartservice.selectAllCartItemByOneUser(1);
        for (CartItem cartItem:cartItems) {
            if (cartItem.getChecked()==1){
                cartItem.setIschecked(true);
            }else {
                cartItem.setIschecked(false);
            }
        }
        if(null!=cartItems) {
            return cartItems;
        }else{
            return null;
        }

    }

/*左滑删除一件商品*/
    @RequestMapping(value = "/deleteCartItem")
    @ResponseBody
    public void deleteCartItem()
    {

        HashMap <String,Integer> hashmap=new HashMap<String,Integer>();
        hashmap.put("userId",1);
        hashmap.put("productId",1);
        cartservice.deleteCartItem(hashmap);
    }
/*加入购物车*/
    @RequestMapping(value = "/insertCartItem")
    @ResponseBody
    public void  insertCartItem(){
        int a=0;
        List<Cart> carts = cartservice.selectCart(1);
        for (Cart all: carts) {
           if(all.getProductId()==3){
               all.setQuantity(all.getQuantity()+1);
               cartservice.updateQuantity(all);

           }else{
               a++;
           }

        }if(a==carts.size()){
            Cart cart=new Cart();
            cart.setProductId(3);
            cart.setUserId(1);
            cart.setQuantity(1);
            cart.setIsAlive(1);
            cart.setChecked(1);
            cart.setCpProductColor("粉色");
            cart.setCpProductSize("X");
            System.out.println(cart);
            cartservice.insertCartItem(cart);

        }

    }




}
