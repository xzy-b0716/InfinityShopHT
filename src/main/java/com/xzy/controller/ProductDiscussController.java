package com.xzy.controller;

import com.xzy.beans.ProductDiscuss;
import com.xzy.beans.User;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Create by Shuai on 2019/8/3 16:38
 */
@RestController
public class ProductDiscussController {
    @Autowired
    private ProductDiscussService productDiscussService;

    //查询评论条数
    @RequestMapping("/countController/{productId}")
    public Integer countController(@PathVariable("productId") Integer productId) {
        Integer count = productDiscussService.countDiscuss(productId);
        return count;
    }

}
