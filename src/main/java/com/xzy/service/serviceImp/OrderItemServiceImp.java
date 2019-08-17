package com.xzy.service.serviceImp;


import com.xzy.beans.*;
import com.xzy.mapper.OrderitemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderItemServiceImp implements com.xzy.service.OrderItemService {
    @Autowired
    private OrderitemMapper oim;

   //单点购买增加(生成)订单项
   @Override
   public int addOrderItemBy01(int productId, int num, int ordersId, String oiProductSize, String oiProductColor){
       //得到商品
       Product product = oim.findProByOiId(productId);
       if(product.getProductStock()>num){
           //生成订单项
           Orderitem orderitem = new Orderitem();
           orderitem.setOiProductNum(num);
           orderitem.setOiTotalPrice(product.getProductPrice()*num);
           orderitem.setOrdersId(ordersId);
           orderitem.setProductId(productId);
           orderitem.setOiProductSize(oiProductSize);
           orderitem.setOiProductColor(oiProductColor);

           int oiId = oim.insertSelective(orderitem);
           //主键回填
           Integer orderitemId = orderitem.getOrderitemId();

           //删除商品库存
           oim.updateProStock(product.getProductStock()-num, productId);
           return 1;
       }
       return 0;
   }

   //通过购物车增加(生成)订单项
   @Override
   public int addOrderItemBy02(int userId, int ordersId){
        //拿到购物车里所有的商品
        List<Cart> carts = oim.findCartByUserid(userId);
        Iterator<Cart> iterator = carts.iterator();
        while (iterator.hasNext()){
            Cart cart = iterator.next();
            if(cart.getChecked() == 1){
                Orderitem orderitem = new Orderitem();
                //拿到商品
                Integer productId = cart.getProductId();
                Product product = oim.findProByOiId(productId);

                orderitem.setOiProductNum(cart.getQuantity());
                orderitem.setOiTotalPrice(product.getProductPrice()* cart.getQuantity());
                orderitem.setProductId(productId);
                orderitem.setOrdersId(ordersId);
                orderitem.setOiProductSize(cart.getCpProductSize());
                orderitem.setOiProductColor(cart.getCpProductColor());

                int oiId = oim.insertSelective(orderitem);
                //主键回填
                Integer orderitemId = orderitem.getOrderitemId();

                //删除商品库存
                oim.updateProStock(product.getProductStock()- cart.getQuantity(), productId);

                //删除购物车
                oim.updateCartProIsAlive(cart.getCartId());
            }
        }
        return 1;
   }

   //通过秒杀增加(生成)订单项
   @Override
   public int addOrderItemBy03(int ordersId, int productId, String oiProductSize, String oiProductColor){
       Seckill seckill = oim.findSecByPId(productId);
       if(seckill.getSeckillStock()>0){
           //生成订单项
           Orderitem orderitem = new Orderitem();
           orderitem.setOiProductNum(1);
           orderitem.setOiTotalPrice(seckill.getSeckillPrice());
           orderitem.setOrdersId(ordersId);
           orderitem.setProductId(productId);
           orderitem.setOiProductSize(oiProductSize);
           orderitem.setOiProductColor(oiProductColor);

           int oiId = oim.insertSelective(orderitem);
           //主键回填
           Integer orderitemId = orderitem.getOrderitemId();

           //删除秒杀商品库存
           oim.updateSecStock(seckill.getSeckillStock()-1, productId);

           return 1;
       }
       return 0;
   }

    //删除订单项
    @Override
    public int deleteOrderitem(int OrdersId){
        int i = oim.deleteOrderitemByOrdersId(OrdersId);
        return i;
    }

    //查询所有订单项
    @Override
    public List<OrderitemProduct> findAllOPByOrdId(int ordersId){
        List<OrderitemProduct> orderitems = oim.findOPByordId(ordersId);
        return orderitems;
    }
}
