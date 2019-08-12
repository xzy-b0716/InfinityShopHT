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
    public List<Product> getHotSearchProduct() {
        List<Product> products = productMapper.getHotSearchProduct();
        return products;
    }

    @Override
    public List<Product> recommendNewest() {
        List<Product> products = productMapper.recommendNewest();
        return products;
    }

    @Override
    public List<Product> getClasss(String sex) {
        List<Product> products = productMapper.getClasss(sex);

        return products;
    }

    @Override
    public List<Product> selectProductByProductClassId(String id) {
        List<Product> products = productMapper.selectProductByProductClassId(id);
        return products;

    }

    @Override
    public List<Product> selectClassProductByProductId(Integer id) {
        List<Product> products = productMapper.selectClassProductByProductId(id);
        return products;
    }

    @Override
    public List<Product> selectHistoryByUserId(Integer id) {
        List<Product> products = productMapper.selectHistoryByUserId(id);
        return products;
    }

    @Override
    public List<Product> selectCollectByUserId(Integer id) {
        List<Product> products = productMapper.selectCollectByUserId(id);
        return products;
    }

}
