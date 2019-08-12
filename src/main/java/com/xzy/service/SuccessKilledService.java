package com.xzy.service;

import com.xzy.beans.SuccessKillPro;
import com.xzy.beans.SuccessKilled;

import java.util.Date;
import java.util.List;

public interface SuccessKilledService {
    public List<Integer> getSecProUser(Integer productId, Integer userId);

    public int insertSuccessKilled(Integer productId, Integer userId, Date createTime);

    public SuccessKillPro queryByWithSeckill(Integer productId, Integer userId);

}
