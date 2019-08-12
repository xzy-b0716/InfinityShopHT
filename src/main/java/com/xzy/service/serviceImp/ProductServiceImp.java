package com.xzy.service.serviceImp;

import com.xzy.beans.Product;
import com.xzy.mapper.ProductMapper;
import com.xzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> orderbyproduct_com_num(Integer  id) {
        List<Product> products = productMapper.orderbyproduct_com_num(id);
        return products;
    }
    @Override
    public List<Product> orderbyproduct_price(Integer  id) {
        List<Product> products = productMapper.orderbyproduct_price(id);
        return products;
    }
    @Override
    public List<Product> orderbyproduct_createtime(Integer  id) {
        List<Product> products = productMapper.orderbyproduct_createtime(id);
        return products;
    }

    @Override
    public List<Product> selectClassProductByProductId(Integer  id) {
        List<Product> products = productMapper.selectClassProductByProductId(id);
        return products;
    }

    @Override
    public List<Product> recommendNewest() {
        List<Product> products = productMapper.recommendNewest();
        return products;
    }

    @Override
    public List<Product> getClasss(Integer sex) {
        List<Product> products = productMapper.getClasss(sex);
        return products;

    }
    @Override
    public  List<Product> selectProductByProductClassId(String  id){
        List<Product> products = productMapper.selectProductByProductClassId(id);
        return products;

    }

}
