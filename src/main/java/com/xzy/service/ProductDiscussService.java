package com.xzy.service;

import com.xzy.beans.ProductDiscuss;

import java.util.List;
import java.util.Map;

/**
 * Create by Shuai on 2019/8/3 16:19
 */
public interface ProductDiscussService {

    //查询评论条数
    Integer countDiscuss(Integer ProductId);
    //添加评论
    void insertDiscuss(ProductDiscuss productDiscuss);

}
