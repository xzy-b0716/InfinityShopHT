package com.xzy.exception;

/**
 * 数据篡改异常（运行时异常）
 *
 * @author cairunduo
 * @date 2019/8/5 - 21:49
 */
public class DateRewriteException extends SeckillException {

    public DateRewriteException(String message) {
        super(message);
    }

    public DateRewriteException(String message, Throwable cause) {
        super(message, cause);
    }
}

