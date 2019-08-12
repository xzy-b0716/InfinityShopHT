package com.xzy.service;

import com.xzy.beans.Browse;
import com.xzy.beans.ProductShow;

import java.util.List;

/**
 * Create by Shuai on 2019/8/4 1:18
 */
public interface ProductShowService {
    //   查询商品详情
    public ProductShow selectProductAll(Integer productId);

    //   根据用户id查询商品浏览记录表
    public List<Browse> getHistoryByUserId(Integer userId);

    //   根据用户id和商品id查询浏览记录
    public Browse getHistoryByUserIdAndProductId(Browse userHistory);

    //   更新商品浏览历史
    public void updateHistory(Browse userHistory);

    //   插入商品到浏览历史表
    public void insertProductHistory(Browse userHistory);

    //  删除一条浏览记录
    public void delete(Integer productId, Integer userId);
}
