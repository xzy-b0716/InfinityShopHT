package com.xzy.service;

import com.xzy.beans.Address;

import java.util.List;

/**
 * 地址的业务逻辑层接口
 *
 * @author shixiao
 * @date 2019/8/1 - 15:41
 */
public interface AddressService {

    /**
     * 获取一伙人用户地址信息列表的接口
     * @return
     */
    List<Address> getUserAllAddress(Integer userId);

    /**
     * 获取单个地址信息的接口
     * @param addressId
     * @return
     */
    Address getAddress(Integer addressId);

    /**
     * 添加新地址
     * @param address
     * @return
     */
    int addAddress(Integer userId,Address address);

    /**
     * 更新地址信息
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 根据addressId删除地址
     * @param addressId
     * @return
     */
    int delAddress(Integer addressId);

}
