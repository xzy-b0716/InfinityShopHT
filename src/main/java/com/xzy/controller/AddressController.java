package com.xzy.controller;

import com.xzy.beans.Address;
import com.xzy.common.ResponseCode;
import com.xzy.common.ServerResponse;
import com.xzy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shixiao
 * @date 2019/8/1 - 21:30
 */
@RestController
@RequestMapping(value = "/address/")
public class AddressController {

    @Autowired
    private AddressService addressService;

   /**
     * 获取用户收货地址列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "addressList.do",method = RequestMethod.POST)
    public ServerResponse<List<Address>> addressList(Integer userId){
        if (userId==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        ServerResponse<List<Address>> list = addressService.getUserAllAddress(userId);
        return list;
    }

    /**
     * 通过id获取收货地址
     * @param addressId
     * @return
     */
    @RequestMapping(value = "getaddressById.do",method = RequestMethod.POST)
    public ServerResponse<Address> getaddressById(Integer addressId){
        if (addressId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        ServerResponse<Address> address = addressService.getAddress(addressId);
        return address;
    }

    /**
     * 添加收货地址
     * @param tbAddress
     * @return
     */
    @RequestMapping(value = "addAddress.do",method = RequestMethod.POST)
    public ServerResponse addAddress(Integer userId,Address tbAddress){
        //todo 通过session获取user
        //HttpSession session,
        //User user = (User) session.getAttribute(Cont.CURRENT_USER);
        if (userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse addAddress = addressService.addAddress(userId, tbAddress);
        return addAddress;
    }

    /**
     * 编辑收货地址
     * @param tbAddress
     * @return
     */
    @RequestMapping(value = "updateAddress.do",method = RequestMethod.POST)
    public ServerResponse updateAddress(Integer userId,Address tbAddress){
        if (userId==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse updateAddress = addressService.updateAddress(userId, tbAddress);
        return updateAddress;
    }

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    @RequestMapping(value = "delAddress.do",method = RequestMethod.POST)
    public ServerResponse delAddress(Integer addressId){
        if (addressId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        ServerResponse delAddress = addressService.delAddress(addressId);
        return delAddress;
    }
}
