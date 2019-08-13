package com.xzy.service;

import com.xzy.beans.Browse;

import java.util.List;

/**
 * Create by Shuai on 2019/8/13 11:31
 */
public interface BrowerService {
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
