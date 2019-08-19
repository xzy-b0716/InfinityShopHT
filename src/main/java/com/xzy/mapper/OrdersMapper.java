package com.xzy.mapper;

import com.xzy.beans.Orderitem;
import com.xzy.beans.Orders;
import com.xzy.beans.Product;
import com.xzy.beans.Seckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrdersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ordersId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    int insertSelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    Orders selectByPrimaryKey(Integer ordersId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Orders record);

    List<Orderitem> findOiByOid(int ordersId);

    Product findProByOid(int productId);

    List<Integer> findAllOrdId();

    int updatePayStatus(int ordersId);

    int updateSendStatus(int ordersId);

    int updateGetStatus(int ordersId);

    int updateSendTime(@Param("ordersSendTime") Date ordersSendTime, @Param("ordersId") int ordersId);

    int updateGetTime(@Param("ordersGetTime") Date ordersGetTime, @Param("ordersId") int ordersId);

    List<Integer> findPay();

    List<Integer> findSend();

    List<Integer> findGet();

    int findPayStutas(int ordersId);

    int findSendStutas(int ordersId);

    Seckill findSecByPId(int productId);


}