package com.xzy.controller;

import com.xzy.beans.Seckill;
import com.xzy.dto.Exposer;
import com.xzy.dto.SeckillExecution;
import com.xzy.dto.SeckillResult;
import com.xzy.enums.SeckillStateEnum;
import com.xzy.exception.RepeatKillException;
import com.xzy.exception.SeckillCloseException;
import com.xzy.exception.SeckillException;
import com.xzy.service.SeckillService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.List;

@RestController
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2019-8-6 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping("queryList")
    public List<Seckill> querySecProList() {
        return seckillService.querySecProList();
    }

    @RequestMapping("/exposer/{productId}")
    public SeckillResult<Exposer> exportSeckillUrl(@PathVariable("productId") Integer productId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(productId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            result = new SeckillResult<Exposer>(false, "秒杀未开始");

        }
        return result;
    }


    @RequestMapping("executeSeckill/{productId}/{userId}")
    public SeckillResult<SeckillExecution> testSeckillLogic(@PathVariable("productId") Integer productId, @PathVariable("userId") Integer userId) {
        Exposer exposer = seckillService.exportSeckillUrl(productId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(productId, userId, md5);
                return new SeckillResult<SeckillExecution>(true, execution);
            } catch (RepeatKillException e) {
                SeckillExecution execution = new SeckillExecution(productId, SeckillStateEnum.REPEAT_KILL);
                return new SeckillResult<SeckillExecution>(false, execution);
            } catch (SeckillCloseException e) {
                SeckillExecution execution = new SeckillExecution(productId, SeckillStateEnum.END);
                return new SeckillResult<SeckillExecution>(false, execution);
            } catch (Exception e) {
                SeckillExecution execution = new SeckillExecution(productId, SeckillStateEnum.INNER_ERROR);
                return new SeckillResult<SeckillExecution>(false, execution);
            }
        } else {
            SeckillExecution execution = new SeckillExecution(productId, SeckillStateEnum.STOP_SECKILL);
            return new SeckillResult<SeckillExecution>(false, execution);
        }
    }

}
