package com.xzy.service.serviceImp;

import com.xzy.mapper.CollectMapper;
import com.xzy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Shuai on 2019/8/10 14:01
 */
@Service
public class CollectServiceImp implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
//    商品是否收藏
    public Integer isCollect(Integer productId, Integer userId) {
        return collectMapper.isLike(productId,userId);
    }
}
