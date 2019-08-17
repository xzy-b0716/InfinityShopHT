package com.xzy.service.serviceImp;


import com.xzy.beans.Orders;
import com.xzy.beans.Product;
import com.xzy.beans.Seckill;
import com.xzy.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImp implements com.xzy.service.OrdersService {
    @Autowired
    private OrdersMapper om;

    //单点购买增加(生成)订单
    @Override
    public int addOrderBy01(int userId, int addressId, int productId, int num) {
        Orders order = new Orders();

        order.setOrdersPayStatus(0);
        order.setOrdersSendStatus(0);
        order.setOrdersGetStatus(0);
        order.setOrdersCreateTime(new Date());
        order.setUserId(userId);
        order.setAddressId(addressId);
        Product product = om.findProByOid(productId);
        order.setOrdersTotalPrice(product.getProductPrice()*num);

        int insert = om.insertSelective(order);
        //主键回填
        Integer ordersId = order.getOrdersId();

        return ordersId;
    }

    //通过购物车增加(生成)订单
    @Override
    public int addOrderBy02(int userId, int addressId, float ordersTotalPrice){
        Orders order = new Orders();

        order.setOrdersTotalPrice(ordersTotalPrice);
        order.setOrdersPayStatus(0);
        order.setOrdersSendStatus(0);
        order.setOrdersGetStatus(0);
        order.setOrdersCreateTime(new Date());
        order.setUserId(userId);
        order.setAddressId(addressId);

        int i = om.insertSelective(order);
        //主键回填
        Integer ordersId = order.getOrdersId();

        return ordersId;
    }

    //通过秒杀增加(生成)订单
    @Override
    public int addOrderBy03(int userId, int addressId, int productId){
        Orders order = new Orders();

        //
        Seckill seckill = om.findSecByPId(productId);
        order.setOrdersTotalPrice(seckill.getSeckillPrice());
        order.setOrdersPayStatus(0);
        order.setOrdersSendStatus(0);
        order.setOrdersGetStatus(0);
        order.setOrdersCreateTime(new Date());
        order.setUserId(userId);
        order.setAddressId(addressId);
        int insert = om.insertSelective(order);
        //主键回填
        Integer ordersId = order.getOrdersId();

        return ordersId;
    }

    //删除订单
    @Override
    public int deleteOrders(int OrdersId){
        int i = om.deleteByPrimaryKey(OrdersId);
        return i;
    }

    //修改支付状态
    @Override
    public int updatePayStatus(int ordersId){
        int payStatus = om.updatePayStatus(ordersId);
        return payStatus;
    }

    //修改发货状态、添加发货时间
    @Override
    public int updateSend(int ordersId){
        int payStutas = om.findPayStutas(ordersId);
        if(payStutas == 1){
            om.updateSendStatus(ordersId);
            om.updateSendTime(new Date(), ordersId);
            return 1;
        } else {
            return 0;
        }
    }

    //修改收货状态、添加收货时间
    @Override
    public int updateGet(int ordersId){
        int sendStutas = om.findSendStutas(ordersId);
        if(sendStutas == 1) {
            om.updateGetStatus(ordersId);
            om.updateGetTime(new Date(), ordersId);
            return 1;
        } else {
            return 0;
        }
    }

    //查询所有订单的ordersId
    @Override
    public List<Integer> findAllOrdId(){
        List<Integer> allOrdId = om.findAllOrdId();
        return allOrdId;
    }

    //查询待支付订单
    @Override
    public List<Integer> findPay(){
        List<Integer> ordPay = om.findPay();
        return ordPay;
    }

    //查询待发货订单
    @Override
    public List<Integer> findSend(){
        List<Integer> ordSend = om.findSend();
        return ordSend;
    }

    //查询待收货订单
    @Override
    public List<Integer> findGet(){
        List<Integer> ordGet = om.findGet();
        return ordGet;
    }


}
