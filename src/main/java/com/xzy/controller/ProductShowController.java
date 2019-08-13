package com.xzy.controller;

import com.xzy.beans.*;
import com.xzy.common.ServerResponse;
import com.xzy.service.*;
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
    private BrowerService browerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDiscussService productDiscussService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private ProductShowService productShowService;
    @Autowired
    private InformationService informationService;
    public boolean collect(int flag){
        boolean like = false;
        if (flag == 1) {
            like = true;
        }
        return  like;
    }
    @RequestMapping("/productAll")
    public ServerResponse productAll(Integer productId, Integer userId) {
        if (productId == null || productId.equals("")) {
            String msg = "productId为空或者为null";
            return ServerResponse.createByErrorMessage(msg);
        }
        ProductShow p = productShowService.selectProductAll(productId);
        p.setInformation(informationService.selectInformation(productId));
        p.setLike(productService.selectClassProductByProductId(productId));
        p.setCollect(collect(collectService.isCollect(productId, userId)));
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
            Browse userHistory1=browerService.getHistoryByUserIdAndProductId(userHistory);
            if(userHistory1 ==null){
                Browse userHistory2=new Browse();
                userHistory2.setBrowseTime(new Date());
                userHistory2.setUserId(userHistory.getUserId());
                userHistory2.setProductId(userHistory.getProductId());
                browerService.insertProductHistory(userHistory2);
            }else{
                userHistory1.setBrowseTime(new Date());
                browerService.updateHistory(userHistory1);
            }
        }

    }

    /*查询用户浏览历史记录*/
    @RequestMapping("/selectHistory")
    @ResponseBody
    public List<Browse> selectHistory(HttpSession session,Integer userId){
//        User user=(User)session.getAttribute("user");
        List<Browse> userHistories=browerService.getHistoryByUserId(userId);
        for( Browse browse :userHistories){
            int productId =browse.getProductId();
            browse.setCollect(collect(collectService.isCollect(productId, userId)));
        }
        return userHistories;
}


    @RequestMapping("/deleteHistory")
    public String deleteHistory(Integer productId, Integer userId) {
        browerService.delete(productId,userId);
        return "yes";
    }

}
