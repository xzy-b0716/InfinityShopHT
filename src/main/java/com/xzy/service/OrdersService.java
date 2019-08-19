package com.xzy.service;

import com.xzy.beans.Orders;

import java.util.List;

public interface OrdersService {
    //单点购买增加(生成)订单
    int addOrderBy01(int userId, int addressId, int productId, int num);

    //通过购物车增加(生成)订单
    int addOrderBy02(int userId, int addressId, float ordersTotalPrice);

    //通过秒杀增加(生成)订单
    int addOrderBy03(int userId, int addressId, int productId);

    //删除订单
    int deleteOrders(int OrdersId);

    //修改支付状态
    int updatePayStatus(int ordersId);

    //修改发货状态、添加发货时间
    int updateSend(int ordersId);

    //修改收货状态、添加收货时间
    int updateGet(int ordersId);

    //查询所有订单的ordersId
    List<Integer> findAllOrdId();

    //查询待支付订单
    List<Integer> findPay();

    //查询待发货订单
    List<Integer> findSend();

    //查询待收货订单
    List<Integer> findGet();

    //根据ordersId查询订单
    Orders findOneOrder(int ordersId);
}
