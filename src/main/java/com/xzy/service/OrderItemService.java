package com.xzy.service;

import com.xzy.beans.Orderitem;

import java.util.List;

/**
 * @author cairunduo
 * @date 2019/8/12 - 0:22
 */
public interface OrderItemService {
    //单点购买增加(生成)订单项
    int addOrderItemBy01(int productId, int num, int ordersId, String oiProductSize, String oiProductColor);

    //通过购物车增加(生成)订单项
    int addOrderItemBy02(int userId, int ordersId);

    //通过秒杀增加(生成)订单项
    int addOrderItemBy03(int ordersId, int productId, String oiProductSize, String oiProductColor);

    //删除订单项
    int deleteOrderitem(int OrdersId);

    //查询所有订单项
    List<Orderitem> findAllOIByOrdId(int ordersId);
}
