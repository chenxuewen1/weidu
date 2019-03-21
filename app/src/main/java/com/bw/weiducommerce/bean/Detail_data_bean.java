package com.bw.weiducommerce.bean;

/*Time:2019/3/21
 *Author:chenxuewen
 *Description:详情数据里的result集合
 */
public class Detail_data_bean {
    private String categoryId;
    private String categoryName;
    private int commentNum;
    private int commodityId;
    private String commodityName;
    private String describe;
    private String details;
    private String picture;
    private int price;
    private int saleNum;
    private int stock;
    private int weight;

    public Detail_data_bean() {
        super();
    }

    @Override
    public String toString() {
        return "Detail_data_bean{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", commentNum=" + commentNum +
                ", commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", describe='" + describe + '\'' +
                ", details='" + details + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", saleNum=" + saleNum +
                ", stock=" + stock +
                ", weight=" + weight +
                '}';
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Detail_data_bean(String categoryId, String categoryName, int commentNum, int commodityId, String commodityName, String describe, String details, String picture, int price, int saleNum, int stock, int weight) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.commentNum = commentNum;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.describe = describe;
        this.details = details;
        this.picture = picture;
        this.price = price;
        this.saleNum = saleNum;
        this.stock = stock;
        this.weight = weight;
    }
}
