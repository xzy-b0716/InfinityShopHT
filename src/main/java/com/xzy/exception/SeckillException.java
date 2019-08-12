package com.xzy.exception;

/**
 * 秒杀相关业务异常
 *
 * @author cairunduo
 * @date 2019/8/5 - 21:55
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
