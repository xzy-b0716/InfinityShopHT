package com.xzy.enums;

/**
 * 使用枚举表述常量数据字段
 * @author cairunduo
 * @date 2019/8/7 - 0:00
 */
public enum  SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");
    //PRE_BEGIN(-4,"秒杀未开启");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static  SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum state : values()){
            return state;
        }
        return null;
    }
}
