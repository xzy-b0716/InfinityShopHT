package com.xzy.exception;

/**
 * @author shixiao
 * @date 2019/8/1 - 17:57
 */
public class InfintyException extends RuntimeException {

    private String msg;

    public InfintyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
