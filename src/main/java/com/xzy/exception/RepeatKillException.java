package com.xzy.exception;

/**
 * 重复秒杀异常（运行时异常）
 *
 * @author cairunduo
 * @date 2019/8/5 - 21:49
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
