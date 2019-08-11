package com.xzy.controller;

import com.xzy.beans.Address;
import com.xzy.beans.User;
import com.xzy.common.Cont;
import com.xzy.exception.InfintyException;
import com.xzy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "addressList",method = RequestMethod.POST)
    public List<Address> addressList(Integer userId){
        List<Address> list = addressService.getUserAllAddress(userId);
        return list;
    }

    /**
     * 通过id获取收货地址
     * @param addressId
     * @return
     */
    @RequestMapping(value = "address",method = RequestMethod.POST)
    public Address address(Integer addressId){
        Address address=addressService.getAddress(addressId);
        return address;
    }

    /**
     * 添加收货地址
     * @param tbAddress
     * @return
     */
    @RequestMapping(value = "addAddress",method = RequestMethod.POST)
    public int addAddress(HttpSession session, Address tbAddress){
        //通过session获取user
        User user = (User) session.getAttribute(Cont.CURRENT_USER);
        if (user == null){
            throw new InfintyException("用户未登录");
        }
        return addressService.addAddress(user.getUserId(),tbAddress);
    }

    /**
     * 编辑收货地址
     * @param tbAddress
     * @return
     */
    @RequestMapping(value = "updateAddress",method = RequestMethod.POST)
    public Integer updateAddress(@RequestBody Address tbAddress){
        int result = addressService.updateAddress(tbAddress);
        return result;
    }

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    @RequestMapping(value = "delAddress",method = RequestMethod.POST)
    public Integer delAddress(@RequestBody Integer addressId){
        int result = addressService.delAddress(addressId);
        return result;
    }
}
