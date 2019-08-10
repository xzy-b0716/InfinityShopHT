package com.xzy.controller;

import com.xzy.beans.Seckill;
import com.xzy.service.ProductDiscussService;
import com.xzy.service.SecProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SecProductController {
    @Resource
    private SecProductService secProductService;
    @Resource
    private ProductDiscussService productDiscussService;
    @RequestMapping("queryAll/{productId}")
    public Seckill queryByProductId(@PathVariable("productId") Integer productId){
        Seckill seckill = secProductService.queryByProductId(productId);
        seckill.setCountDiscuss(productDiscussService.countDiscuss(productId));
        return seckill;
    }
}
