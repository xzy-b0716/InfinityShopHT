package com.xzy.service.serviceImp;

import com.xzy.mapper.ProductDiscussMapper;
import com.xzy.service.ProductDiscussService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cairunduo
 * @date 2019/8/6 - 17:49
 */
@Service
public class ProductDiscussServiceImp implements ProductDiscussService {
    @Resource
    private ProductDiscussMapper productDiscussMapper;
    @Override
    public int countDiscuss(Integer productId) {
        return productDiscussMapper.countDiscuss(productId);
    }
}
