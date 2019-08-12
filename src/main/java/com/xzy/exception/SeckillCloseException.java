package com.xzy.exception;

/**
 * 秒杀关闭异常
 *
 * @author cairunduo
 * @date 2019/8/5 - 21:51
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
