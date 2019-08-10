package com.xzy.mapper;

import com.xzy.beans.Seckill;

public interface SecProductMapper {
    /**
     * 通过商品Id查询秒杀商品的全部信息（秒杀商品详情页）
     */
    Seckill queryByProductId(Integer productId);
}
