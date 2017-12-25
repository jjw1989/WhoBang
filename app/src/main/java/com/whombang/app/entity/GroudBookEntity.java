package com.whombang.app.entity;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/25.
 */

public class GroudBookEntity {

    private List<GoodsInfoListBean> goodsInfoList;

    public List<GoodsInfoListBean> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfoListBean> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public static class GoodsInfoListBean {
        /**
         * imgUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
         * amount : 2
         * sumPrice : 161.00
         * orderTime : 2017-12-25 10:33:15
         * sellUnit : 整箱（x20)
         * orderId : G20171225103315260
         * price : 80.5
         * orderStatus : 待取货
         * stationName : 测试站点（张）
         * goodsName : 康帅傅羊肉泡馍
         * goodsSellId : 1
         * goodsSellOrderId : 25861739465d4355b36d21e5a92db553
         */

        private String imgUrl;
        private int amount;
        private String sumPrice;
        private String orderTime;
        private String sellUnit;
        private String orderId;
        private double price;
        private String orderStatus;
        private String stationName;
        private String goodsName;
        private int goodsSellId;
        private String goodsSellOrderId;
        private String groupingDes;
        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getSumPrice() {
            return sumPrice;
        }

        public void setSumPrice(String sumPrice) {
            this.sumPrice = sumPrice;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getSellUnit() {
            return sellUnit;
        }

        public void setSellUnit(String sellUnit) {
            this.sellUnit = sellUnit;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getGoodsSellId() {
            return goodsSellId;
        }

        public void setGoodsSellId(int goodsSellId) {
            this.goodsSellId = goodsSellId;
        }

        public String getGoodsSellOrderId() {
            return goodsSellOrderId;
        }

        public void setGoodsSellOrderId(String goodsSellOrderId) {
            this.goodsSellOrderId = goodsSellOrderId;
        }

        public String getGroupingDes() {
            return groupingDes;
        }

        public void setGroupingDes(String groupingDes) {
            this.groupingDes = groupingDes;
        }
    }
}
