package com.xzy.beans;

import java.util.List;

public class ProductShow {

    private Integer productId;

    private String productName;

    private String productPicture;

    private Integer productStock;

    private Integer productComNum;

    private Float productPrice;

    private String productDescribe;

    private String productSuperclass;

    private String productClassId;

    private String productCreatetime;

    private String productBrand;

    private String productMaterial;

    private String productVersion;

    private String productStyle;

    private String productThickness;

    private Integer discussCount;

    private Boolean collect;

    private List<User> user;

    private List<Carousel> carousel;

    private List<ProductSize> productSizes;

    private List<ProductColor> productColors;

    private List<ProductDiscuss> productDiscuss;

    private List<Product> like;

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }

    public Boolean getCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    public List<Product> getLike() {
        return like;
    }

    public void setLike(List<Product> like) {
        this.like = like;
    }

    public Integer getDiscussCount() {
        return discussCount;
    }

    public void setDiscussCount(Integer discussCount) {
        this.discussCount = discussCount;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Carousel> getCarousel() {
        return carousel;
    }

    public void setCarousel(List<Carousel> carousel) {
        this.carousel = carousel;
    }

    public List<ProductDiscuss> getProductDiscuss() {
        return productDiscuss;
    }

    public void setProductDiscuss(List<ProductDiscuss> productDiscuss) {
        this.productDiscuss = productDiscuss;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_name
     *
     * @return the value of product.product_name
     * @mbggenerated
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_name
     *
     * @param productName the value for product.product_name
     * @mbggenerated
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_picture
     *
     * @return the value of product.product_picture
     * @mbggenerated
     */
    public String getProductPicture() {
        return productPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_picture
     *
     * @param productPicture the value for product.product_picture
     * @mbggenerated
     */
    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture == null ? null : productPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_stock
     *
     * @return the value of product.product_stock
     * @mbggenerated
     */
    public Integer getProductStock() {
        return productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_stock
     *
     * @param productStock the value for product.product_stock
     * @mbggenerated
     */
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_com_num
     *
     * @return the value of product.product_com_num
     * @mbggenerated
     */
    public Integer getProductComNum() {
        return productComNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_com_num
     *
     * @param productComNum the value for product.product_com_num
     * @mbggenerated
     */
    public void setProductComNum(Integer productComNum) {
        this.productComNum = productComNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_price
     *
     * @return the value of product.product_price
     * @mbggenerated
     */
    public Float getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_price
     *
     * @param productPrice the value for product.product_price
     * @mbggenerated
     */
    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_describe
     *
     * @return the value of product.product_describe
     * @mbggenerated
     */
    public String getProductDescribe() {
        return productDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_describe
     *
     * @param productDescribe the value for product.product_describe
     * @mbggenerated
     */
    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe == null ? null : productDescribe.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_superclass
     *
     * @return the value of product.product_superclass
     * @mbggenerated
     */
    public String getProductSuperclass() {
        return productSuperclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_superclass
     *
     * @param productSuperclass the value for product.product_superclass
     * @mbggenerated
     */
    public void setProductSuperclass(String productSuperclass) {
        this.productSuperclass = productSuperclass == null ? null : productSuperclass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_class_id
     *
     * @return the value of product.product_class_id
     * @mbggenerated
     */
    public String getProductClassId() {
        return productClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_class_id
     *
     * @param productClassId the value for product.product_class_id
     * @mbggenerated
     */
    public void setProductClassId(String productClassId) {
        this.productClassId = productClassId == null ? null : productClassId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_createtime
     *
     * @return the value of product.product_createtime
     * @mbggenerated
     */
    public String getProductCreatetime() {
        return productCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_createtime
     *
     * @param productCreatetime the value for product.product_createtime
     * @mbggenerated
     */
    public void setProductCreatetime(String productCreatetime) {
        this.productCreatetime = productCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_brand
     *
     * @return the value of product.product_brand
     * @mbggenerated
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_brand
     *
     * @param productBrand the value for product.product_brand
     * @mbggenerated
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_material
     *
     * @return the value of product.product_material
     * @mbggenerated
     */
    public String getProductMaterial() {
        return productMaterial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_material
     *
     * @param productMaterial the value for product.product_material
     * @mbggenerated
     */
    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial == null ? null : productMaterial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_version
     *
     * @return the value of product.product_version
     * @mbggenerated
     */
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_version
     *
     * @param productVersion the value for product.product_version
     * @mbggenerated
     */
    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion == null ? null : productVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_style
     *
     * @return the value of product.product_style
     * @mbggenerated
     */
    public String getProductStyle() {
        return productStyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_style
     *
     * @param productStyle the value for product.product_style
     * @mbggenerated
     */
    public void setProductStyle(String productStyle) {
        this.productStyle = productStyle == null ? null : productStyle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_thickness
     *
     * @return the value of product.product_thickness
     * @mbggenerated
     */
    public String getProductThickness() {
        return productThickness;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_thickness
     *
     * @param productThickness the value for product.product_thickness
     * @mbggenerated
     */
    public void setProductThickness(String productThickness) {
        this.productThickness = productThickness == null ? null : productThickness.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_size
     *
     * @return the value of product.product_size
     *
     * @mbggenerated
     */

}