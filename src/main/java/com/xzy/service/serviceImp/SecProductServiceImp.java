package com.xzy.service.serviceImp;

import com.xzy.beans.Seckill;
import com.xzy.mapper.SecProductMapper;
import com.xzy.service.SecProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecProductServiceImp implements SecProductService {
    @Resource
    private SecProductMapper secProductMapper;

    @Override
    public Seckill queryByProductId(Integer productId) {
        return secProductMapper.queryByProductId(productId);
    }
}
