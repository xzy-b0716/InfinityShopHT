package com.xzy.controller;

import com.xzy.beans.Product;
import com.xzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @
 */
@Controller
public class ProductController {
    //获得热门商品
    @Autowired
    private ProductService productService;

    @RequestMapping("/getHotSearchProduct")
    @ResponseBody
    public List<Product> getHotSearchProduct() {

        List<Product> productList = productService.getHotSearchProduct();
        return productList;
    }

    @RequestMapping("/recommendNewest")
    @ResponseBody
    public List<Product> recommendNewest() {

        List<Product> productList = productService.recommendNewest();
        return productList;
    }

    @RequestMapping("/getClasss/{sex}")
    @ResponseBody
    public List<Product> getClasss(@PathVariable("sex") String sex) {
        List<Product> productsList = productService.getClasss(sex);

        return productsList;
    }

    @RequestMapping("/selectProductByProductClassId/{id}")
    @ResponseBody
    public List<Product> selectProductByProductClassId(@PathVariable("id") String id) {
        List<Product> productsList = productService.selectProductByProductClassId(id);

        return productsList;
    }

    @RequestMapping("/selectClassProductByProductId/{id}")
    @ResponseBody
    public List<Product> selectClassProductByProductId(@PathVariable("id") Integer id) {
        List<Product> productsList = productService.selectClassProductByProductId(id);

        return productsList;
    }

    @RequestMapping("/selectHistoryByUserId/{id}")
    @ResponseBody
    public List<Product> selectHistoryByUserId(@PathVariable("id") Integer id) {
        List<Product> productsList = productService.selectHistoryByUserId(id);

        return productsList;
    }

    @RequestMapping("/selectCollectByUserId/{id}")
    @ResponseBody
    public List<Product> selectCollectByUserId(@PathVariable("id") Integer id) {
        List<Product> productsList = productService.selectCollectByUserId(id);

        return productsList;
    }
}


