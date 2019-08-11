package com.xzy.controller;

import com.xzy.service.ServiceImp.OrdersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersServiceImp os;

    @RequestMapping("/addOrderBy01")
    public int addOrderBy01(int userId, int addressId, int productId, int num){
        int i = os.addOrderBy01(userId, addressId, productId, num);
        return i;
    }

    /*@RequestMapping("/addO")
    //@ResponseBody
    public String addOrders(Orders orders){
        int id = os.addOrder(orders);
        return id+"";
    }
    @RequestMapping("/selectO")
    public Orders selectOrder(int oId){
        Orders orders = os.selctOrder(oId);
        return orders;
    }
    @RequestMapping("/deleteO")
    public int deleteOrder(int oId){
        int id = os.deleteOrder(oId);
        return id;
    }*/
}
