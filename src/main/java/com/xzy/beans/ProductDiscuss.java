package com.xzy.beans;

import java.util.Date;

public class ProductDiscuss {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_discuss.product_discuss_id
     *
     * @mbggenerated
     */
    private Integer productDiscussId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_discuss.produc_discuss_comment
     *
     * @mbggenerated
     */
    private String producDiscussComment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_discuss.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_discuss.product_id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_discuss.pd_createtime
     *
     * @mbggenerated
     */
    private Date pdCreatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_discuss.product_discuss_id
     *
     * @return the value of product_discuss.product_discuss_id
     *
     * @mbggenerated
     */
    public Integer getProductDiscussId() {
        return productDiscussId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_discuss.product_discuss_id
     *
     * @param productDiscussId the value for product_discuss.product_discuss_id
     *
     * @mbggenerated
     */
    public void setProductDiscussId(Integer productDiscussId) {
        this.productDiscussId = productDiscussId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_discuss.produc_discuss_comment
     *
     * @return the value of product_discuss.produc_discuss_comment
     *
     * @mbggenerated
     */
    public String getProducDiscussComment() {
        return producDiscussComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_discuss.produc_discuss_comment
     *
     * @param producDiscussComment the value for product_discuss.produc_discuss_comment
     *
     * @mbggenerated
     */
    public void setProducDiscussComment(String producDiscussComment) {
        this.producDiscussComment = producDiscussComment == null ? null : producDiscussComment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_discuss.user_id
     *
     * @return the value of product_discuss.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_discuss.user_id
     *
     * @param userId the value for product_discuss.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_discuss.product_id
     *
     * @return the value of product_discuss.product_id
     *
     * @mbggenerated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_discuss.product_id
     *
     * @param productId the value for product_discuss.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_discuss.pd_createtime
     *
     * @return the value of product_discuss.pd_createtime
     *
     * @mbggenerated
     */
    public Date getPdCreatetime() {
        return pdCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_discuss.pd_createtime
     *
     * @param pdCreatetime the value for product_discuss.pd_createtime
     *
     * @mbggenerated
     */
    public void setPdCreatetime(Date pdCreatetime) {
        this.pdCreatetime = pdCreatetime;
    }
}