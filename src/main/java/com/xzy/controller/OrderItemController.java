package com.xzy.controller;

import com.xzy.service.ServiceImp.OrderItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemServiceImp ois;
    @RequestMapping("/addOrderItemBy01")
    public int addOrderItemBy01(int productId, int num, int ordersId,
                                String oiProductSize, String oiProductColor){
        int i = ois.addOrderItemBy01(productId, num, ordersId, oiProductSize, oiProductColor);
        return i;
    }


    /*@RequestMapping("/addOI")
    //@ResponseBody
    public String addOrders(Orderitem orderItem){
        int id = ois.addOrderItem(orderItem);
        return id+"";
    }
    @RequestMapping("/selectOI")
    public Orderitem selectOrder(int oiId){
        Orderitem orderItem = ois.selctOrderItemByPrimaryKey(oiId);
        return orderItem;
    }
    @RequestMapping("/deleteOI")
    public int deleteOrder(int oiId){
        int id = ois.deleteOrderItem(oiId);
        return id;
    }*/
    /*@RequestMapping("/selectOIByOid")
    public List<Orderitem> selectOrderItemByOid(int oiId){
        List<Orderitem> orderItems = ois.selctOrderItemByOid(oiId);
        return orderItems;
    }*/
}
