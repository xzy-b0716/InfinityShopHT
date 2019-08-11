package com.xzy.service.serviceImp;

import com.xzy.beans.Product;
import com.xzy.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp {
    @Autowired
    private ProductMapper pm;
    public Product findProductById(int pId){
        Product product = pm.selectByPrimaryKey(pId);
        return product;
    }
    public int addProduct(Product product){
        int id = pm.insert(product);
        return id;
    }

}
