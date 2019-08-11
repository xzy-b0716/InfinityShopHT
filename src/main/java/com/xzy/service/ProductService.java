package com.xzy.service;

import com.xzy.beans.Product;

import java.util.List;

public interface ProductService {
    List<Product> getHotSearchProduct();

    List<Product> recommendNewest();

    List<Product>  getClasss(Integer sex);

    List<Product> selectProductByProductClassId(String  id);

    List<Product> selectClassProductByProductId(Integer  id);

    List<Product> selectHistoryByUserId(Integer  id);

    List<Product>  selectCollectByUserId(Integer  id);
//
//    /*根据用户id查询商品浏览记录表*/
//     List<Browse> selectHistorysByUserId(Integer id);
//    /*根据用户id和商品id查询浏览记录*/
//     List<Browse> selectHistoryByUserIdAndProductId(com.xzy.beans.Browse Browse);
//    /*更新商品浏览历史表*/
//    List<Browse> updateHistory(com.xzy.beans.Browse Browse);
//    /*插入商品到浏览历史表*/
//    List<Browse> insertHistory(com.xzy.beans.Browse Browse);
//
//    List<Browse> deleteHistory(Integer productId);
}