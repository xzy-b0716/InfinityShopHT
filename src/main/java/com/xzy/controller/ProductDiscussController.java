package com.xzy.controller;

import com.xzy.beans.ProductDiscuss;
import com.xzy.beans.User;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Create by Shuai on 2019/8/3 16:38
 */
@RestController
public class ProductDiscussController {
    @Autowired
    private ProductDiscussService productDiscussService;
    //查询评论条数
    @RequestMapping("/countController/{ProductId}")
    public Integer countController(@PathVariable("ProductId") Integer ProductId)
    {
        Integer count= productDiscussService.countDiscuss(ProductId);
        return count;
    }
    @RequestMapping("/insertDiscuss")
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
