package com.xzy.service.serviceImp;

import com.xzy.beans.Browse;
import com.xzy.beans.ProductShow;
import com.xzy.mapper.BrowseMapper;
import com.xzy.mapper.ProductShowMapper;
import com.xzy.service.CollectService;
import com.xzy.service.ProductShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by Shuai on 2019/8/4 1:20
 */
@Service
public class ProductShowServiceImp implements ProductShowService {
    @Resource
    private ProductShowMapper productShowMapper;

    //   查询商品详情
    @Override
    public ProductShow selectProductAll(Integer productId) {
        return  productShowMapper.selectAllByProductId(productId);
    }

}
