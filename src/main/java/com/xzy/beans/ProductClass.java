package com.xzy.beans;

import org.springframework.stereotype.Repository;

@Repository
public class ProductClass {

    private Integer productClassId;


    private Product product;


    private ProductClass productclass;


    public void setProductclass(ProductClass productclass) {
        this.productclass = productclass;
    }


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_class.product_class_name
     *
     * @mbggenerated
     */
    private String productClassName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_class.product_class_image_path
     *
     * @mbggenerated
     */
    private String productClassImagePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_class.product_class_id
     *
     * @return the value of product_class.product_class_id
     * @mbggenerated
     */
    public Integer getProductClassId() {
        return productClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_class.product_class_id
     *
     * @param productClassId the value for product_class.product_class_id
     * @mbggenerated
     */
    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_class.product_class_name
     *
     * @return the value of product_class.product_class_name
     * @mbggenerated
     */
    public String getProductClassName() {
        return productClassName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_class.product_class_name
     *
     * @param productClassName the value for product_class.product_class_name
     * @mbggenerated
     */
    public void setProductClassName(String productClassName) {
        this.productClassName = productClassName == null ? null : productClassName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_class.product_class_image_path
     *
     * @return the value of product_class.product_class_image_path
     * @mbggenerated
     */
    public String getProductClassImagePath() {
        return productClassImagePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_class.product_class_image_path
     *
     * @param productClassImagePath the value for product_class.product_class_image_path
     * @mbggenerated
     */
    public void setProductClassImagePath(String productClassImagePath) {
        this.productClassImagePath = productClassImagePath == null ? null : productClassImagePath.trim();
    }
}