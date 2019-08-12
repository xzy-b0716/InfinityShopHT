package com.xzy.service.serviceImp;

import com.xzy.beans.Browse;
import com.xzy.beans.ProductShow;
import com.xzy.mapper.ProductShowMapper;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Shuai on 2019/8/4 1:20
 */
@Service
public class ProductShowServiceImp implements ProductShowService {
    @Autowired
    private ProductShowMapper productShowMapper;
    //   查询商品详情
    @Override
    public ProductShow selectProductAll(Integer productId) {
        return  productShowMapper.selectAllByProductId(productId);
    }
    //   根据用户id查询商品浏览记录表
    @Override
    public List<Browse> getHistoryByUserId(Integer userId) {
        List<Browse> userHistories=productShowMapper.selectHistoryByUserId(userId);
        return userHistories;
    }
    //   根据用户id和商品id查询浏览记录
    @Override
    public Browse getHistoryByUserIdAndProductId(Browse userHistory) {
        return productShowMapper.selectHistoryByUserIdAndProductId(userHistory);
    }
    //   更新商品浏览历史
    @Override
    public void updateHistory(Browse userHistory) {
        productShowMapper.updateHistory(userHistory);
    }
    //   插入商品到浏览历史表
    @Override
    public void insertProductHistory(Browse userHistory) {
        productShowMapper.insertHistory(userHistory);
    }
    //  删除一条浏览记录
    @Override
    public void delete(Integer productId, Integer userId) {
        productShowMapper.deleteHistory(productId,userId);
    }
}
