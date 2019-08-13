/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: CollectCotroller
 * Author:   李佳佳同学
 * Date:     2019/8/8 12:14
 * Description: haode
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xzy.controller;

import com.xzy.beans.Collect;
import com.xzy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈haode 〉
 *
 * @author 李佳佳同学
 * @create 2019/8/8
 * @since 1.0.0
 */
@RestController
public class CollectCotroller {
    @Autowired
    private CollectService collectservice;



    @GetMapping("/delete")
    public void deleteproduct(Collect collect)
    {
        collectservice.delete(collect);

    }
    //根据userid和productid插入数据
    @GetMapping("/insertproduct")
    public void inserproduct(Collect collect)
    {
        collectservice.insert(collect);
    }




    @RequestMapping("/selectbyuserid/{userId}")
    public List<Integer> selectallpid(@PathVariable("userId") Integer userId)
    {
        return  collectservice.selectallpid(userId);

    }



    @GetMapping("/collect")
    public  boolean panbduan(Collect collect)
    {
        return collectservice.panduan(collect);
    }

    @GetMapping("/Collect1")
    public void finall(Collect collect)
    {
        //从前端传入用户ID和商品ID，判断数据库里有没有这个数据，如果没有就加入，如果有就删除。
        boolean b=collectservice.panduan(collect);
        if(b)
        {
            collectservice.delete(collect);
        }
        else
        {
            collectservice.insert(collect);
        }
    }
}
