package com.xzy.service.serviceImp;

import com.xzy.beans.Seckill;
import com.xzy.beans.SuccessKillPro;
import com.xzy.beans.cache.RedisBean;
import com.xzy.controller.SuccessKilledController;
import com.xzy.dto.Exposer;
import com.xzy.dto.SeckillExecution;
import com.xzy.enums.SeckillStateEnum;
import com.xzy.exception.RepeatKillException;
import com.xzy.exception.SeckillCloseException;
import com.xzy.exception.SeckillException;
import com.xzy.mapper.SecProductMapper;
import com.xzy.mapper.SeckillMapper;
import com.xzy.mapper.SuccessKilledMapper;
import com.xzy.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SeckillServiceImp implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedisBean redisBean;

    //MD5盐值字符串，用于混淆MD5
    private final String salt = "C!R@D#1￥3%5^7&9*0$8+6-4?2<c>r.d";

    @Resource
    private SeckillMapper seckillMapper;

    @Resource
    private SecProductMapper secProductMapper;

    @Resource
    private SuccessKilledMapper successKilledMapper;

    @Resource
    private SuccessKilledController successKilledController;

    @Override
    public int reduceNumber(Integer productId, Date killTime) {
        //Date killtime = new Date();
        return seckillMapper.reduceNumber(productId, killTime);
    }

    @Override
    public List<Seckill> querySecProList() {
        return seckillMapper.querySecProList();
    }

    @Override
    public Exposer exportSeckillUrl(Integer productId) {
        //优化点：缓存优化：超时的基础上维护一致性
        //1.访问Redis
        Seckill seckill = redisBean.getSeckill(productId);
        if (seckill == null) {
            //2.访问数据库
            seckill = secProductMapper.queryByProductId(productId);
            if (seckill == null) {
                return new Exposer(false, productId);
            } else {
                Date startTime = seckill.getSeckillStartTime();
                Date endTime = seckill.getSeckillEndTime();
                //当前时间
                Date nowTime = new Date();
                if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
                    return new Exposer(false, productId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
                }
                //3.放入redis
                redisBean.putSeckill(seckill, productId);
            }
        }
        //转化特定字符串过程，不可逆
        //System.out.println(seckill.getSeckillStartTime());
        //System.out.println(seckill.getSeckillEndTime());
        String md5 = getMD5(productId);
        return new Exposer(true, md5, productId, new Date().getTime(), seckill.getSeckillStartTime().getTime(), seckill.getSeckillEndTime().getTime());
    }

    private String getMD5(Integer productId) {
        String base = productId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(Integer productId, Integer userId, String md5) throws
            SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(productId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑
        Date nowTime = new Date();

        //记录购买行为
        boolean jduge = successKilledController.insertSuccessKilled(productId, userId, nowTime);
        if (jduge) {
            //重复秒杀
            throw new RepeatKillException("seckill repeated");
        } else {
            //减库存，拿到行级锁 (放在记录购买行为之后，减少获得行级锁的时间（只经过一次网络延迟和可能出现的GC）)
            int updateCount = seckillMapper.reduceNumber(productId, nowTime);
            try {
                if (updateCount <= 0) {
                    //没有更新到记录，秒杀结束  rollback
                    throw new SeckillCloseException("seckill is closed");
                } else {
                    //秒杀成功  commit
                    SuccessKillPro successKillPro = successKilledMapper.queryByWithSeckill(productId, userId);
                    return new SeckillExecution(productId, SeckillStateEnum.SUCCESS, successKillPro);
                }

            } catch (SeckillCloseException e1) {
                throw e1;
            } catch (RepeatKillException e2) {
                throw e2;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                //所有编译期异常转化为运行期异常(sping的声明式事务可以做回滚)
                throw new SeckillException("seckill inner error" + e.getMessage());
            }
        }
    }
}

