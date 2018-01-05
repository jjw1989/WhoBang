package com.whombang.app.entity;

import java.util.List;

/**
 * 提供商品列表实体
 * Created by sundy.jiang on 2018/1/5.
 */
public class OfferGoodsEntity {

    private List<GoodsInfoListBean> goodsInfoList;

    public List<GoodsInfoListBean> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfoListBean> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public static class GoodsInfoListBean {
        /**
         * receiverTel : 18611766105
         * amount : 5
         * sumPrice : 402.50
         * orderId : G20180104225608249
         * receiverName : 张三
         * orderStatus : 已成团，等待发货
         * goodsSellId : 1
         * imgUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
         * receiverAddress : 18611766105
         * orderTime : 2018-01-04 22:56:08
         * sellUnit : 整箱（x20)
         * price : 80.5
         * stationName : 测试站点（张）
         * goodsName : 康帅傅羊肉泡馍
         * goodsSellOrderId : 435a89655a0145fbafcf4a17991fadac
         */

        private String receiverTel;
        private int amount;
        private String sumPrice;
        private String orderId;
        private String receiverName;
        private String orderStatus;
        private int goodsSellId;
        private String imgUrl;
        private String receiverAddress;
        private String orderTime;
        private String sellUnit;
        private double price;
        private String stationName;
        private String goodsName;
        private String goodsSellOrderId;

        public String getReceiverTel() {
            return receiverTel;
        }

        public void setReceiverTel(String receiverTel) {
            this.receiverTel = receiverTel;
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

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getGoodsSellId() {
            return goodsSellId;
        }

        public void setGoodsSellId(int goodsSellId) {
            this.goodsSellId = goodsSellId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getReceiverAddress() {
            return receiverAddress;
        }

        public void setReceiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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

        public String getGoodsSellOrderId() {
            return goodsSellOrderId;
        }

        public void setGoodsSellOrderId(String goodsSellOrderId) {
            this.goodsSellOrderId = goodsSellOrderId;
        }
    }
}
