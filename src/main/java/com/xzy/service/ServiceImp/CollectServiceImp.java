package com.xzy.service.serviceImp;

import com.xzy.beans.Collect;
import com.xzy.mapper.CollectMapper;
import com.xzy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import java.util.List;

/**
 * Create by Shuai on 2019/8/10 14:01
 */
@Service
public class CollectServiceImp implements CollectService {
    //true是有，false是没有。
    boolean b;

    @Resource
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
        b = collectMapper.selectallbyuserid(collect.getUserId()).contains(collect.getProductId());
        return b;
    }

    @Override
    //商品是否收藏
    public Integer isCollect(Integer productId, Integer userId) {
        return collectMapper.isLike(productId, userId);
    }
}
