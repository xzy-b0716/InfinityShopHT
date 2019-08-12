package com.xzy.controller;

import com.xzy.beans.*;
import com.xzy.common.ServerResponse;
import com.xzy.common.ResponseCode;
import com.xzy.service.CollectService;
import com.xzy.service.InformationService;
import com.xzy.service.ProductDiscussService;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    @Autowired
    private ProductShowService productShowService;
    @Autowired
    private InformationService informationService;
    @RequestMapping("/productAll")
    public ServerResponse productAll(Integer productId, Integer userId) {
        if (productId == null || productId.equals("")) {
            String msg = "productId为空或者为null";
            return ServerResponse.createByErrorMessage(msg);
        }
        ProductShow p = productService.selectProductAll(productId);
        p.setInformation(informationService.selectInformation(productId));
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
    @RequestMapping("/insertHistory")
    @ResponseBody
    public void insertHistory(Integer productId,Integer userId, HttpSession session){
//        User user = (User) session.getAttribute("user");

        if(userId!=null){
            Browse userHistory=new Browse();
            userHistory.setProductId(productId);
            userHistory.setUserId(userId);
            Browse userHistory1=productShowService.getHistoryByUserIdAndProductId(userHistory);
            if(userHistory1 ==null){
                Browse userHistory2=new Browse();
                userHistory2.setBrowseTime(new Date());
                userHistory2.setUserId(userHistory.getUserId());
                userHistory2.setProductId(userHistory.getProductId());
                productShowService.insertProductHistory(userHistory2);
            }else{
                userHistory1.setBrowseTime(new Date());
                productShowService.updateHistory(userHistory1);
            }
        }

    }

    /*查询用户浏览历史记录*/
    @RequestMapping("/selectHistory")
    @ResponseBody
    public List<Browse> selectHistory(HttpSession session,Integer userId){
//        User user=(User)session.getAttribute("user");
        List<Browse> userHistories=productShowService.getHistoryByUserId(userId);

        return userHistories;
}


    @RequestMapping("/deleteHistory")
    @ResponseBody
    public String deleteHistory(Integer productId,Integer userId)
    {
        productShowService.delete(productId,userId);
        return "yes";
    }

}
