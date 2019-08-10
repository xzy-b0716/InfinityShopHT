package com.xzy.controller;

import com.xzy.beans.SuccessKillPro;
import com.xzy.beans.SuccessKilled;
import com.xzy.service.SuccessKilledService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class SuccessKilledController {
    @Resource
    private SuccessKilledService successKilledService;

    @RequestMapping("getuser")
    public boolean getSecProUser(Integer productId, Integer userId) {
        boolean jduge = false;  //true:购买过该商品  false:未购买过
        List<Integer> alluserids = successKilledService.getSecProUser(productId, userId);
        Iterator<Integer> iterator = alluserids.iterator();
        while (iterator.hasNext()) {
            Integer userids = iterator.next();
            if (userids.equals(userId)) {
                jduge = true;
                break;
            }
        }
        return jduge;
    }
    @RequestMapping("insert")
    public boolean insertSuccessKilled(Integer productId, Integer userId, Date createTime){
        boolean judgebuy = getSecProUser(productId, userId);
        //System.out.println(judgebuy);
        if(judgebuy==false){
            successKilledService.insertSuccessKilled(productId,userId,createTime);
        }
        return judgebuy;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2019-8-3 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping("querySeckill")
    public SuccessKillPro queryByWithSeckill(Integer productId,Integer userId){
        return successKilledService.queryByWithSeckill(productId,userId);
    }
}

