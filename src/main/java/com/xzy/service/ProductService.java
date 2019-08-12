package com.xzy.service;

import com.xzy.beans.Product;

import java.util.List;

public interface ProductService {

    List<Product> getHotSearchProduct();

    List<Product> getClasss(String sex);

    List<Product> selectHistoryByUserId(Integer id);

    List<Product> selectCollectByUserId(Integer id);

    List<Product> orderbyproduct_com_num(Integer id);

    List<Product> orderbyproduct_price(Integer id);

    List<Product> orderbyproduct_createtime(Integer id);

    List<Product> selectClassProductByProductId(Integer id);

    List<Product> recommendNewest();

    List<Product> selectProductByProductClassId(String id);
}