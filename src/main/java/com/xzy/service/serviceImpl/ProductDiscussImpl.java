package com.xzy.service.serviceImpl;

import com.xzy.beans.ProductDiscuss;
import com.xzy.mapper.ProductDiscussMapper;
import com.xzy.service.ProductDiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create by Shuai on 2019/8/3 16:31
 */
@Service
public class ProductDiscussImpl implements ProductDiscussService {
    @Autowired
    private ProductDiscussMapper productDiscussMapper;
    @Override
//    商品评论的总数
    public Integer countDiscuss(Integer ProductId) {
        return productDiscussMapper.countDiscuss(ProductId);
    }

    @Override
//    添加评论
    public void insertDiscuss(ProductDiscuss productDiscuss) {

        productDiscussMapper.insertSelective(productDiscuss);
    }

}
