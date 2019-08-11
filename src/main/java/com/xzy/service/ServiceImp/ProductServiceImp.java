package com.xzy.service.ServiceImp;

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
    public List<Product> getClasss(Integer sex) {
        List<Product> products = productMapper.getClasss(sex);
        return products;

    }
    @Override
    public  List<Product> selectProductByProductClassId(String  id){
        List<Product> products = productMapper.selectProductByProductClassId(id);
        return products;

    }
    @Override
    public  List<Product> selectClassProductByProductId(Integer  id){
        List<Product> products = productMapper.selectClassProductByProductId( id);
        return products;
    }

    @Override
    public List<Product> selectHistoryByUserId(Integer  id){
        List<Product> products = productMapper.selectHistoryByUserId(id);
        return products;
    }

    @Override
    public List<Product>  selectCollectByUserId(Integer  id){
        List<Product> products = productMapper. selectCollectByUserId(id);
        return  products;
    }


//    /*根据用户id查询商品浏览记录表*/
//    @Override
//    public List<Browse> selectHistorysByUserId(Integer id){
//        List<Browse> userHistories=productMapper.selectHistorysByUserId(id);
//        return userHistories;
//    }
//    /*根据用户id和商品id查询浏览记录*/
//    @Override
//    public Browse getHistoryByUserIdAndProductId(com.xzy.beans.Browse browse){
//        return productMapper.selectHistoryByUserIdAndProductId(browse);
//    }
//    /*更新商品浏览历史表*/
//    @Override
//    public void updateHistory(UserHistory userHistory){
//        productmapper.updateHistory(userHistory);
//    }
//    /*插入商品到浏览历史表*/
//    @Override
//    public void insertProductHistory(UserHistory userHistory){
//        productmapper.insertHistory(userHistory);
//    }
//
//    @Override
//    public void delete(Integer productId) {
//        productmapper.deleteHistory(productId);
//    }
}
