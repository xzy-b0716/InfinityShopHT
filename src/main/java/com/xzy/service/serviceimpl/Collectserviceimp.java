/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Collectserviceimp
 * Author:   李佳佳同学
 * Date:     2019/8/8 12:06
 * Description: 实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xzy.service.serviceimpl;

import com.xzy.beans.Collect;
import com.xzy.mapper.CollectMapper;
import com.xzy.service.Collectservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实现类〉
 *
 * @author 李佳佳同学
 * @create 2019/8/8
 * @since 1.0.0
 */
@Service
public class Collectserviceimp implements Collectservice {
    //true是有，false是没有。
    boolean b;
    @Autowired
    private CollectMapper collectMapper;


    @Override
    public void delete(Collect collect) {
        collectMapper.deletebyproductid(collect);
    }

    @Override
    //插入用户ID和商品ID。
    public void insert(Collect colloect) {
        collectMapper.insertproduct(colloect);
    }

    @Override
    /*
    根据用户id查出所有的商品。
     */
    public List<Integer> selectallpid(Integer userid) {
        List<Integer> list = collectMapper.selectallbyuserid(userid);
        return list;
    }

    @Override
    //根据用户ID查出是否数据库里面包含了某个商品ID。
    public boolean panduan(Collect collect ) {
        b=collectMapper.selectallbyuserid(collect.getUserId()).contains(collect.getProductId());
        return  b;
    }

}
