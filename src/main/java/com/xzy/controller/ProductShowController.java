package com.xzy.controller;

import com.xzy.beans.ProductShow;
import com.xzy.common.ServerResponse;
import com.xzy.common.ResponseCode;
import com.xzy.service.CollectService;
import com.xzy.service.ProductDiscussService;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Shuai on 2019/8/4 10:54
 */
@RestController
public class ProductShowController {
    @Autowired
    private ProductShowService productService;
    @Autowired
    private ProductDiscussService productDiscussService;
    @Autowired
    private CollectService collectService;

    @RequestMapping("/productAll")
    public ServerResponse productAll(Integer productId, Integer userId) {
        if (productId == null || productId.equals("")) {
            String msg = "productId为空或者为null";
            return ServerResponse.createByErrorMessage(msg);
        }
        ProductShow p = productService.selectProductAll(productId);
        int num = collectService.isCollect(productId, userId);
        boolean like = false;
        if (num == 1) {
            like = true;
        }
        p.setCollect(like);
        int count = productDiscussService.countDiscuss(productId);
        p.setDiscussCount(productDiscussService.countDiscuss(productId));
        if (count == 0) {
            p.setProductDiscuss(null);
        }
        return ServerResponse.createBySuccess(p);

    }

}
