package com.xzy.mapper;

import com.xzy.beans.Browse;
import com.xzy.beans.ProductShow;

import java.util.List;

public interface ProductShowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
//    删除一条浏览记录
    public void deleteHistory(Integer productId, Integer userId);

    //    根据用户id查询商品浏览记录表
    public List<Browse> selectHistoryByUserId(Integer userId);

    //    根据用户id和商品id查询浏览记录
    public Browse selectHistoryByUserIdAndProductId(Browse userHistory);

    //    更新浏览历史表
    public void updateHistory(Browse userHistory);

    /*插入商品到浏览历史表*/
    public void insertHistory(Browse userHistory);

    //    获取商品的详细信息
    ProductShow selectAllByProductId(Integer productId);

    int deleteByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    int insert(ProductShow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    int insertSelective(ProductShow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    ProductShow selectByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductShow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductShow record);
}