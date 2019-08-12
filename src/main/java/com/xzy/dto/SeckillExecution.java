package com.xzy.dto;

import com.xzy.beans.SuccessKillPro;
import com.xzy.beans.SuccessKilled;
import com.xzy.enums.SeckillStateEnum;

/**
 * @author cairunduo
 * @date 2019/8/5 - 21:43
 */
public class SeckillExecution {

    private Integer productId;

    //秒杀执行结果状态
    private int state;

    //状态表示
    private String stateInfo;

    //秒杀成功对象

    private SuccessKillPro successKillPro;

    public SuccessKillPro getSuccessKillPro() {
        return successKillPro;
    }

    public void setSuccessKillPro(SuccessKillPro successKillPro) {
        this.successKillPro = successKillPro;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }


    //秒杀成功
    public SeckillExecution(Integer productId, SeckillStateEnum stateEnum, SuccessKillPro successKillPro) {
        this.productId = productId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKillPro = successKillPro;
    }

    //秒杀失败
    public SeckillExecution(Integer productId, SeckillStateEnum stateEnum) {
        this.productId = productId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
}
