package com.xzy.dto;

import java.io.Serializable;

/**
 * 暴露秒杀地址DTO
 */
public class Exposer implements Serializable {

    private static final long serialVersionUID = 3945522124434282652L;
    //是否开启秒杀
    private boolean exposed;

    //一种加密措施
    private String md5;

    //id

    private Integer productId;
    //系统当前时间(毫秒)

    private long now;
    //开启时间

    private long start;
    //结束时间

    private long end;

    public Exposer(boolean exposed, Integer productId) {
        this.exposed = exposed;
        this.productId = productId;
    }

    public Exposer(boolean exposed, String md5, Integer productId, long now, long start, long end) {
        this.exposed = exposed;
        this.md5 = md5;
        this.productId = productId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String md5, Integer productId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.productId = productId;
    }

    public Exposer(boolean exposed, Integer productId, long now, long start, long end) {
        this.exposed = exposed;
        this.productId = productId;
        this.now = now;
        this.start = start;
        this.end = end;
    }


    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", productId=" + productId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
