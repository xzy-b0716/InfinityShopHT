package com.xzy.controller;

import com.xzy.beans.ProductDiscuss;
import com.xzy.beans.User;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Create by Shuai on 2019/8/3 16:38
 */
@RestController
public class ProductDiscussController {
    @Autowired
    private ProductDiscussService productDiscussService;
    //查询评论条数
    @RequestMapping("/countController/{productId}")
    public Integer countController(@PathVariable("productId") Integer productId)
    {
        Integer count= productDiscussService.countDiscuss(productId);
        return count;
    }
    @RequestMapping("/insertDiscuss")
    public Object insertDiscuss(HttpSession session,ProductDiscuss productDiscuss1)
    {
        User user=(User) session.getAttribute("user");
        if (user==null)
        {
            return "请您登陆";
        }
        ProductDiscuss productDiscuss=new ProductDiscuss();
        productDiscuss.setProducDiscussComment(productDiscuss1.getProducDiscussComment());
        productDiscuss.setProductId(productDiscuss1.getProductId());
        productDiscuss.setUser(productDiscuss1.getUser());

        //上传评论到数据库
        return null;

    }
}
