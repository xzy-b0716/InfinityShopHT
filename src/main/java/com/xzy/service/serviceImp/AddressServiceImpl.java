package com.xzy.service.serviceImp;

import com.xzy.beans.Address;
import com.xzy.common.ResponseCode;
import com.xzy.common.ServerResponse;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper tbAddressMapper;
    /**
     * 获取一个用户所有地址列表的实现方法
     *
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<List<Address>> getUserAllAddress(Integer userId) {
        List<Address> list = tbAddressMapper.selectUserAllAddress(userId);
        if (list.isEmpty()) {
            return ServerResponse.createByErrorMessage("没有该用户的地址");
        }
        return ServerResponse.createBySuccess("返回地址列成功",list);
    }

    /**
     * 获取单个址信息的实现方法
     *
     * @param addressId
     * @return
     */
    @Override
    public ServerResponse<Address> getAddress(Integer addressId) {
        Address address = tbAddressMapper.selectByPrimaryKey(addressId);
        if (address==null){
            return ServerResponse.createByErrorMessage("此用户没有该地址");
        }
        return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getDesc(),address);
    }

    /**
     * 插入地址
     *
     * @param address
     * @return
     */
    @Override
    public ServerResponse addAddress(Integer userId, Address address) {
        address.setUserId(userId);
        //设置唯一默认
        setOneDefault(address);
        int rowCount = tbAddressMapper.insert(address);
        if (rowCount<1){
            return ServerResponse.createByErrorMessage("添加地址失败");
        }
        return ServerResponse.createBySuccess("添加地址成功");
    }

    /**
     * 修改地址信息
     *
     * @param address
     * @return
     */
    @Override
    public ServerResponse updateAddress(Integer userId,Address address) {
        //设置唯一默认
        setOneDefault(address);
        int update = tbAddressMapper.updateByPrimaryKeySelective(address);
        if (update < 1) {
            return ServerResponse.createByErrorMessage("修改地址失败");
        }
        return ServerResponse.createBySuccess("修改地址成功");
    }

    /**
     * 设置唯一默认
     *
     * @param address
     */
    private void setOneDefault(Address address) {
        if (address.getAddressDefalut()) {
            ServerResponse<List<Address>> serverResponse = getUserAllAddress(address.getUserId());
            List<Address> list = serverResponse.getData();
            for (Address address1:list){
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
    public ServerResponse delAddress(Integer addressId) {
        int delete = tbAddressMapper.deleteByPrimaryKey(addressId);
        if (delete < 1){
            return ServerResponse.createByErrorMessage("删除地址失败");
        }
        return ServerResponse.createBySuccess("删除地址成功");
    }
}
