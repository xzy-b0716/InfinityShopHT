package com.xzy.controller;

import com.xzy.beans.ProductDiscuss;
import com.xzy.beans.User;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Create by Shuai on 2019/8/3 16:38
 */
@Controller
public class ProductDiscussController {
    @Autowired
    private ProductDiscussService productDiscussService;
    //查询评论条数
    @RequestMapping("/countController/{productId}")
    @ResponseBody
    public Integer countController(@PathVariable("productId") Integer productId)
    {
        Integer count= productDiscussService.countDiscuss(productId);
        return count;
    }
    @RequestMapping("/insertDiscuss")
    @ResponseBody
    public ProductDiscuss insertDiscuss()
    {

        ProductDiscuss productDiscuss = new ProductDiscuss();
        productDiscuss.setProductId(1);
        productDiscuss.setUserId(1);
        productDiscuss.setPdCreatetime("2019-03-13");
        productDiscuss.setProducDiscussComment("fdsfdsf");
        productDiscussService.insertDiscuss(productDiscuss);
        return productDiscuss;
    }
}
