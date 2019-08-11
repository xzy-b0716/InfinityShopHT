package com.xzy.mapper;


import com.xzy.beans.Browse;
import com.xzy.beans.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {

    int deleteByPrimaryKey(Integer productId);


    int insert(Product record);


    int insertSelective(Product record);


    Product selectByPrimaryKey(Integer productId);


    int updateByPrimaryKeySelective(Product record);


    //通过商品点赞数查询商品列表(通过商品点赞数降序排序)
    List<Product> getHotSearchProduct();

    List<Product> recommendNewest();

    List<Product>  getClasss(Integer sex);

    List<Product> selectProductByProductClassId(String id);

    List<Product> selectClassProductByProductId(Integer  id);

    List<Product> selectHistoryByUserId(Integer  id);

    List<Product>  selectCollectByUserId(Integer  id);





    int updateByPrimaryKey(Product record);
}