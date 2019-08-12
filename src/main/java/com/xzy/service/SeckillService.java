package com.xzy.service;

import com.xzy.beans.Seckill;
import com.xzy.dto.Exposer;
import com.xzy.dto.SeckillExecution;
import com.xzy.exception.RepeatKillException;
import com.xzy.exception.SeckillCloseException;
import com.xzy.exception.SeckillException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface SeckillService {

    /**
     * 减少库存
     *
     * @param productId
     * @param killTime
     * @return
     * @throws ParseException
     */
    public int reduceNumber(Integer productId, Date killTime) throws ParseException;

    /**
     * 展示商品列表
     *
     * @return
     */
    public List<Seckill> querySecProList();

    /**
     * 秒杀开启输出秒杀接口地址,
     * 否则输出系统时间和秒杀时间
     *
     * @param productId
     */
    Exposer exportSeckillUrl(Integer productId);

    /**
     * 执行秒杀操作
     *
     * @param productId
     * @param userId
     */
    SeckillExecution executeSeckill(Integer productId, Integer userId, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

}
