package com.xzy.service.serviceImp;

import com.xzy.beans.SuccessKillPro;
import com.xzy.mapper.SuccessKilledMapper;
import com.xzy.service.SuccessKilledService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SuccessKilledServiceImp implements SuccessKilledService {
    @Resource
    private SuccessKilledMapper successKilledMapper;
    @Override
    public List<Integer> getSecProUser(Integer productId,Integer userId) {
        return successKilledMapper.getSecProUser(productId,userId);
    }

    @Override
    public int insertSuccessKilled(Integer productId, Integer userId, Date createTime) {
        return successKilledMapper.insertSuccessKilled(productId,userId,createTime);
    }

    @Override
    public SuccessKillPro queryByWithSeckill(Integer productId, Integer userId) {
        return successKilledMapper.queryByWithSeckill(productId,userId);
    }
}
