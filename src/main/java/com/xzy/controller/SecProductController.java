package com.xzy.controller;

import com.xzy.beans.Information;
import com.xzy.beans.Seckill;
import com.xzy.service.InformationService;
import com.xzy.service.ProductDiscussService;
import com.xzy.service.ProductService;
import com.xzy.service.SecProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class SecProductController {
    @Resource
    private ProductService productService;
    @Resource
    private InformationService informationService;
    @Resource
    private SecProductService secProductService;
    @Resource
    private ProductDiscussService productDiscussService;

    @RequestMapping("queryAll/{productId}")
    public Seckill queryByProductId(@PathVariable("productId") Integer productId) {
        Seckill seckill = secProductService.queryByProductId(productId);
        seckill.setNowTime(new Date().getTime());
        seckill.setLike(productService.selectClassProductByProductId(productId));
        seckill.setInformation(informationService.selectInformation(productId));
        seckill.setCountDiscuss(productDiscussService.countDiscuss(productId));
        return seckill;
    }
}
