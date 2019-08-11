package com.xzy.service;

import com.xzy.beans.Product;

import java.util.List;

public interface ProductService {
    List<Product> orderbyproduct_com_num(Integer  id);

    List<Product> orderbyproduct_price(Integer  id);

    List<Product> orderbyproduct_createtime(Integer  id);

    List<Product> selectClassProductByProductId(Integer  id);

    List<Product> recommendNewest();

    List<Product>  getClasss(Integer sex);

    List<Product> selectProductByProductClassId(String  id);
}