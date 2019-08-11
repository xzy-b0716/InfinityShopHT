package com.xzy.controller;

import com.xzy.beans.Product;
import com.xzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService ps;
    @RequestMapping("/findbypid")
    public Product findbypid(int pId){
        Product product = ps.findProductById(pId);
        return product;
    }
    @RequestMapping("/addPro")
    public int addPro(Product product){
        int id = ps.addProduct(product);
        return id;
    }
}
