package com.xzy.service.serviceImp;

import com.xzy.beans.Address;
import com.xzy.exception.InfintyException;
import com.xzy.mapper.AddressMapper;
import com.xzy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址业务逻辑实现类
 *
 * @author shixiao
 * @date 2019/8/1 - 16:19
 */
@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressMapper tbAddressMapper;

    /**
     * 获取一个用户所有地址列表的实现方法
     *
     * @param userId
     * @return
     */
    @Override
    public List<Address> getUserAllAddress(Integer userId) {
        List<Address> list = tbAddressMapper.selectUserAllAddress(userId);
        if (list == null) {
            throw new InfintyException("获取地址列表信息失败");
        }
        return list;
    }

    /**
     * 获取单个地址信息的实现方法
     *
     * @param addressId
     * @return
     */
    @Override
    public Address getAddress(Integer addressId) {
        Address address = tbAddressMapper.selectByPrimaryKey(addressId);
        if (address == null) {
            throw new InfintyException("通过id获取地址失败");
        }
        return address;
    }

    /**
     * 插入地址
     *
     * @param address
     * @return
     */
    @Override
    public int addAddress(Integer userId, Address address) {
        address.setUserId(userId);
        //设置唯一默认
        setOneDefault(address);
        int rowCount = tbAddressMapper.insert(address);
        if (rowCount == 0) {
            throw new InfintyException("添加地址失败");
        }
        return 1;
    }

    /**
     * 修改地址信息
     *
     * @param address
     * @return
     */
    @Override
    public int updateAddress(Address address) {
        //设置唯一默认
        setOneDefault(address);

        int update = tbAddressMapper.updateByPrimaryKey(address);
        if (update != 1) {
            throw new InfintyException("修改地址信息失败");
        }
        return 1;
    }

    /**
     * 设置唯一默认
     *
     * @param address
     */
    private void setOneDefault(Address address) {
        if (address.getAddressDefalut()) {
            List<Address> list = getUserAllAddress(address.getUserId());
            for (Address address1 : list) {
                address1.setAddressDefalut(false);
                tbAddressMapper.updateByPrimaryKey(address1);
            }
        }
    }

    /**
     * 删除地址信息
     *
     * @param addressId
     * @return
     */
    @Override
    public int delAddress(Integer addressId) {
        int delete = tbAddressMapper.deleteByPrimaryKey(addressId);
        if (delete != 1) {
            throw new InfintyException("删除地址失败");
        }
        return 1;
    }
}
