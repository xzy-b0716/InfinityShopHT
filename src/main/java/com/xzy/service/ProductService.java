package com.xzy.service;


import com.xzy.beans.Product;

import java.util.List;

public interface ProductService {

    List<Product> getHotSearchProduct();

    List<Product> recommendNewest();

    List<Product> getClasss(String sex);

    List<Product> selectProductByProductClassId(String id);

    List<Product> selectClassProductByProductId(Integer id);

    List<Product> selectHistoryByUserId(Integer id);

    List<Product> selectCollectByUserId(Integer id);

}