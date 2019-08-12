package com.xzy.mapper;

import com.xzy.beans.Cart;
import com.xzy.beans.Orderitem;
import com.xzy.beans.OrderitemProduct;
import com.xzy.beans.Product;
import com.xzy.beans.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderitemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer orderitemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    int insert(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    int insertSelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    Orderitem selectByPrimaryKey(Integer orderitemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Orderitem record);

    Product findProByOiId(int productId);

    int updateProStock(@Param("productStock") int productStock, @Param("productId") int productId);

    List<Cart> findCartByUserid(int userId);

    int updateCartProIsAlive(int cartId);

    int deleteOrderitemByOrdersId(int ordersId);

    List<Orderitem> findOIByordId(int ordersId);

    Seckill findSecByPId(int productId);

    int updateSecStock(@Param("seckillStock") int seckillStock, @Param("productId") int productId);

    List<OrderitemProduct> findOPByordId(int ordersId);
}