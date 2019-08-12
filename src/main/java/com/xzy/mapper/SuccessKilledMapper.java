package com.xzy.mapper;

import com.xzy.beans.Seckill;
import com.xzy.beans.SuccessKillPro;
import com.xzy.beans.SuccessKilled;
import com.xzy.beans.User;

import java.util.Date;
import java.util.List;

public interface SuccessKilledMapper {

    //通过user_id、product_id判断是否重复秒杀
    List<Integer> getSecProUser(Integer productId, Integer userId);

    //插入购买明细
    int insertSuccessKilled(Integer productId, Integer userId, Date createTime);

    //根据id查询SuccessKilled并携带秒杀产品对象实体
    SuccessKillPro queryByWithSeckill(Integer productId, Integer userId);


}
