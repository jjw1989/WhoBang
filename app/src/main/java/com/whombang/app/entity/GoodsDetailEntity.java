package com.whombang.app.entity;

import java.util.List;

/**
 * Created by sundy.jiang on 2018/1/4.
 */

public class GoodsDetailEntity {

    /**
     * goodsDetailImgInfos : [{"goodsDetailImgId":1,"goodsId":10,"goodsDetailImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsDetailImgAddTime":"2017-01-01","goodsDetailImgStatus":0},{"goodsDetailImgId":2,"goodsId":10,"goodsDetailImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsDetailImgAddTime":"2017-01-01","goodsDetailImgStatus":0},{"goodsDetailImgId":3,"goodsId":10,"goodsDetailImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsDetailImgAddTime":"2017-01-01","goodsDetailImgStatus":0}]
     * goodsImgInfos : [{"goodsImgId":10,"goodsId":10,"goodsImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsImgAddTime":"2017-01-01 00:00:00","goodsImgStatus":0},{"goodsImgId":11,"goodsId":10,"goodsImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsImgAddTime":"2017-01-01 00:00:00","goodsImgStatus":0},{"goodsImgId":12,"goodsId":10,"goodsImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","goodsImgAddTime":"2017-01-01 00:00:00","goodsImgStatus":0}]
     * goodsGroupSellInfo : {"goodsGroupSellId":1,"goodsId":10,"goodsGroupSellPrice":80.5,"goodsGroupOriginalCount":8,"goodsGroupCurrentSoldCount":0,"goodsGroupLastPurchaserId":"","goodsGroupSellBeginTime":"2017-12-24","goodsGroupSellDeadlineTime":"2017-12-26","goodsGroupSellStatus":0,"goodsGroupSellOrigPrice":0,"goodsGroupSellUnit":"整箱（x20)","goodsGroupSellName":"康帅傅羊肉泡馍","goodsGroupSellTitleImgUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","checkOutFinalTime":0}
     * goodsInfo : {"goodsId":10,"goodsName":"康帅傅方便面","goodsFullName":"康帅傅方便面","goodsOriginalPrice":0,"goodsSuggestPrice":0,"goodsAgentPrice":0,"goodsSellPrice":0,"goodsDiscountPrice":0,"goodsPlatformRevenueRate":0,"goodsCommonwealRate":0,"goodsBrief":"","goodsDetails":"","goodsSellUnitId":0,"goodsProviderId":1,"goodsRecordCode":"","goodsDefaultImgUrl":"","goodsStatus":0,"goodsStock":0,"goodsShelvingTime":"","goodsPublishTime":"","goodsLevel":0,"goodsScore":0,"goodsStyleId":0,"goodsTypeId":0,"goodsSelf":1}
     */

    private GoodsGroupSellInfoBean goodsGroupSellInfo;
    private GoodsInfoBean goodsInfo;
    private List<GoodsDetailImgInfosBean> goodsDetailImgInfos;
    private List<GoodsImgInfosBean> goodsImgInfos;

    public GoodsGroupSellInfoBean getGoodsGroupSellInfo() {
        return goodsGroupSellInfo;
    }

    public void setGoodsGroupSellInfo(GoodsGroupSellInfoBean goodsGroupSellInfo) {
        this.goodsGroupSellInfo = goodsGroupSellInfo;
    }

    public GoodsInfoBean getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfoBean goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public List<GoodsDetailImgInfosBean> getGoodsDetailImgInfos() {
        return goodsDetailImgInfos;
    }

    public void setGoodsDetailImgInfos(List<GoodsDetailImgInfosBean> goodsDetailImgInfos) {
        this.goodsDetailImgInfos = goodsDetailImgInfos;
    }

    public List<GoodsImgInfosBean> getGoodsImgInfos() {
        return goodsImgInfos;
    }

    public void setGoodsImgInfos(List<GoodsImgInfosBean> goodsImgInfos) {
        this.goodsImgInfos = goodsImgInfos;
    }

    public static class GoodsGroupSellInfoBean {
        /**
         * goodsGroupSellId : 1
         * goodsId : 10
         * goodsGroupSellPrice : 80.5
         * goodsGroupOriginalCount : 8
         * goodsGroupCurrentSoldCount : 0
         * goodsGroupLastPurchaserId :
         * goodsGroupSellBeginTime : 2017-12-24
         * goodsGroupSellDeadlineTime : 2017-12-26
         * goodsGroupSellStatus : 0
         * goodsGroupSellOrigPrice : 0
         * goodsGroupSellUnit : 整箱（x20)
         * goodsGroupSellName : 康帅傅羊肉泡馍
         * goodsGroupSellTitleImgUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
         * checkOutFinalTime : 0
         */

        private int goodsGroupSellId;
        private int goodsId;
        private double goodsGroupSellPrice;
        private int goodsGroupOriginalCount;
        private int goodsGroupCurrentSoldCount;
        private String goodsGroupLastPurchaserId;
        private String goodsGroupSellBeginTime;
        private String goodsGroupSellDeadlineTime;
        private int goodsGroupSellStatus;
        private int goodsGroupSellOrigPrice;
        private String goodsGroupSellUnit;
        private String goodsGroupSellName;
        private String goodsGroupSellTitleImgUrl;
        private int checkOutFinalTime;

        public int getGoodsGroupSellId() {
            return goodsGroupSellId;
        }

        public void setGoodsGroupSellId(int goodsGroupSellId) {
            this.goodsGroupSellId = goodsGroupSellId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public double getGoodsGroupSellPrice() {
            return goodsGroupSellPrice;
        }

        public void setGoodsGroupSellPrice(double goodsGroupSellPrice) {
            this.goodsGroupSellPrice = goodsGroupSellPrice;
        }

        public int getGoodsGroupOriginalCount() {
            return goodsGroupOriginalCount;
        }

        public void setGoodsGroupOriginalCount(int goodsGroupOriginalCount) {
            this.goodsGroupOriginalCount = goodsGroupOriginalCount;
        }

        public int getGoodsGroupCurrentSoldCount() {
            return goodsGroupCurrentSoldCount;
        }

        public void setGoodsGroupCurrentSoldCount(int goodsGroupCurrentSoldCount) {
            this.goodsGroupCurrentSoldCount = goodsGroupCurrentSoldCount;
        }

        public String getGoodsGroupLastPurchaserId() {
            return goodsGroupLastPurchaserId;
        }

        public void setGoodsGroupLastPurchaserId(String goodsGroupLastPurchaserId) {
            this.goodsGroupLastPurchaserId = goodsGroupLastPurchaserId;
        }

        public String getGoodsGroupSellBeginTime() {
            return goodsGroupSellBeginTime;
        }

        public void setGoodsGroupSellBeginTime(String goodsGroupSellBeginTime) {
            this.goodsGroupSellBeginTime = goodsGroupSellBeginTime;
        }

        public String getGoodsGroupSellDeadlineTime() {
            return goodsGroupSellDeadlineTime;
        }

        public void setGoodsGroupSellDeadlineTime(String goodsGroupSellDeadlineTime) {
            this.goodsGroupSellDeadlineTime = goodsGroupSellDeadlineTime;
        }

        public int getGoodsGroupSellStatus() {
            return goodsGroupSellStatus;
        }

        public void setGoodsGroupSellStatus(int goodsGroupSellStatus) {
            this.goodsGroupSellStatus = goodsGroupSellStatus;
        }

        public int getGoodsGroupSellOrigPrice() {
            return goodsGroupSellOrigPrice;
        }

        public void setGoodsGroupSellOrigPrice(int goodsGroupSellOrigPrice) {
            this.goodsGroupSellOrigPrice = goodsGroupSellOrigPrice;
        }

        public String getGoodsGroupSellUnit() {
            return goodsGroupSellUnit;
        }

        public void setGoodsGroupSellUnit(String goodsGroupSellUnit) {
            this.goodsGroupSellUnit = goodsGroupSellUnit;
        }

        public String getGoodsGroupSellName() {
            return goodsGroupSellName;
        }

        public void setGoodsGroupSellName(String goodsGroupSellName) {
            this.goodsGroupSellName = goodsGroupSellName;
        }

        public String getGoodsGroupSellTitleImgUrl() {
            return goodsGroupSellTitleImgUrl;
        }

        public void setGoodsGroupSellTitleImgUrl(String goodsGroupSellTitleImgUrl) {
            this.goodsGroupSellTitleImgUrl = goodsGroupSellTitleImgUrl;
        }

        public int getCheckOutFinalTime() {
            return checkOutFinalTime;
        }

        public void setCheckOutFinalTime(int checkOutFinalTime) {
            this.checkOutFinalTime = checkOutFinalTime;
        }
    }

    public static class GoodsInfoBean {
        /**
         * goodsId : 10
         * goodsName : 康帅傅方便面
         * goodsFullName : 康帅傅方便面
         * goodsOriginalPrice : 0
         * goodsSuggestPrice : 0
         * goodsAgentPrice : 0
         * goodsSellPrice : 0
         * goodsDiscountPrice : 0
         * goodsPlatformRevenueRate : 0
         * goodsCommonwealRate : 0
         * goodsBrief :
         * goodsDetails :
         * goodsSellUnitId : 0
         * goodsProviderId : 1
         * goodsRecordCode :
         * goodsDefaultImgUrl :
         * goodsStatus : 0
         * goodsStock : 0
         * goodsShelvingTime :
         * goodsPublishTime :
         * goodsLevel : 0
         * goodsScore : 0
         * goodsStyleId : 0
         * goodsTypeId : 0
         * goodsSelf : 1
         */

        private int goodsId;
        private String goodsName;
        private String goodsFullName;
        private int goodsOriginalPrice;
        private int goodsSuggestPrice;
        private int goodsAgentPrice;
        private int goodsSellPrice;
        private int goodsDiscountPrice;
        private int goodsPlatformRevenueRate;
        private int goodsCommonwealRate;
        private String goodsBrief;
        private String goodsDetails;
        private int goodsSellUnitId;
        private int goodsProviderId;
        private String goodsRecordCode;
        private String goodsDefaultImgUrl;
        private int goodsStatus;
        private int goodsStock;
        private String goodsShelvingTime;
        private String goodsPublishTime;
        private int goodsLevel;
        private int goodsScore;
        private int goodsStyleId;
        private int goodsTypeId;
        private int goodsSelf;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsFullName() {
            return goodsFullName;
        }

        public void setGoodsFullName(String goodsFullName) {
            this.goodsFullName = goodsFullName;
        }

        public int getGoodsOriginalPrice() {
            return goodsOriginalPrice;
        }

        public void setGoodsOriginalPrice(int goodsOriginalPrice) {
            this.goodsOriginalPrice = goodsOriginalPrice;
        }

        public int getGoodsSuggestPrice() {
            return goodsSuggestPrice;
        }

        public void setGoodsSuggestPrice(int goodsSuggestPrice) {
            this.goodsSuggestPrice = goodsSuggestPrice;
        }

        public int getGoodsAgentPrice() {
            return goodsAgentPrice;
        }

        public void setGoodsAgentPrice(int goodsAgentPrice) {
            this.goodsAgentPrice = goodsAgentPrice;
        }

        public int getGoodsSellPrice() {
            return goodsSellPrice;
        }

        public void setGoodsSellPrice(int goodsSellPrice) {
            this.goodsSellPrice = goodsSellPrice;
        }

        public int getGoodsDiscountPrice() {
            return goodsDiscountPrice;
        }

        public void setGoodsDiscountPrice(int goodsDiscountPrice) {
            this.goodsDiscountPrice = goodsDiscountPrice;
        }

        public int getGoodsPlatformRevenueRate() {
            return goodsPlatformRevenueRate;
        }

        public void setGoodsPlatformRevenueRate(int goodsPlatformRevenueRate) {
            this.goodsPlatformRevenueRate = goodsPlatformRevenueRate;
        }

        public int getGoodsCommonwealRate() {
            return goodsCommonwealRate;
        }

        public void setGoodsCommonwealRate(int goodsCommonwealRate) {
            this.goodsCommonwealRate = goodsCommonwealRate;
        }

        public String getGoodsBrief() {
            return goodsBrief;
        }

        public void setGoodsBrief(String goodsBrief) {
            this.goodsBrief = goodsBrief;
        }

        public String getGoodsDetails() {
            return goodsDetails;
        }

        public void setGoodsDetails(String goodsDetails) {
            this.goodsDetails = goodsDetails;
        }

        public int getGoodsSellUnitId() {
            return goodsSellUnitId;
        }

        public void setGoodsSellUnitId(int goodsSellUnitId) {
            this.goodsSellUnitId = goodsSellUnitId;
        }

        public int getGoodsProviderId() {
            return goodsProviderId;
        }

        public void setGoodsProviderId(int goodsProviderId) {
            this.goodsProviderId = goodsProviderId;
        }

        public String getGoodsRecordCode() {
            return goodsRecordCode;
        }

        public void setGoodsRecordCode(String goodsRecordCode) {
            this.goodsRecordCode = goodsRecordCode;
        }

        public String getGoodsDefaultImgUrl() {
            return goodsDefaultImgUrl;
        }

        public void setGoodsDefaultImgUrl(String goodsDefaultImgUrl) {
            this.goodsDefaultImgUrl = goodsDefaultImgUrl;
        }

        public int getGoodsStatus() {
            return goodsStatus;
        }

        public void setGoodsStatus(int goodsStatus) {
            this.goodsStatus = goodsStatus;
        }

        public int getGoodsStock() {
            return goodsStock;
        }

        public void setGoodsStock(int goodsStock) {
            this.goodsStock = goodsStock;
        }

        public String getGoodsShelvingTime() {
            return goodsShelvingTime;
        }

        public void setGoodsShelvingTime(String goodsShelvingTime) {
            this.goodsShelvingTime = goodsShelvingTime;
        }

        public String getGoodsPublishTime() {
            return goodsPublishTime;
        }

        public void setGoodsPublishTime(String goodsPublishTime) {
            this.goodsPublishTime = goodsPublishTime;
        }

        public int getGoodsLevel() {
            return goodsLevel;
        }

        public void setGoodsLevel(int goodsLevel) {
            this.goodsLevel = goodsLevel;
        }

        public int getGoodsScore() {
            return goodsScore;
        }

        public void setGoodsScore(int goodsScore) {
            this.goodsScore = goodsScore;
        }

        public int getGoodsStyleId() {
            return goodsStyleId;
        }

        public void setGoodsStyleId(int goodsStyleId) {
            this.goodsStyleId = goodsStyleId;
        }

        public int getGoodsTypeId() {
            return goodsTypeId;
        }

        public void setGoodsTypeId(int goodsTypeId) {
            this.goodsTypeId = goodsTypeId;
        }

        public int getGoodsSelf() {
            return goodsSelf;
        }

        public void setGoodsSelf(int goodsSelf) {
            this.goodsSelf = goodsSelf;
        }
    }

    public static class GoodsDetailImgInfosBean {
        /**
         * goodsDetailImgId : 1
         * goodsId : 10
         * goodsDetailImgUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
         * goodsDetailImgAddTime : 2017-01-01
         * goodsDetailImgStatus : 0
         */

        private int goodsDetailImgId;
        private int goodsId;
        private String goodsDetailImgUrl;
        private String goodsDetailImgAddTime;
        private int goodsDetailImgStatus;

        public int getGoodsDetailImgId() {
            return goodsDetailImgId;
        }

        public void setGoodsDetailImgId(int goodsDetailImgId) {
            this.goodsDetailImgId = goodsDetailImgId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsDetailImgUrl() {
            return goodsDetailImgUrl;
        }

        public void setGoodsDetailImgUrl(String goodsDetailImgUrl) {
            this.goodsDetailImgUrl = goodsDetailImgUrl;
        }

        public String getGoodsDetailImgAddTime() {
            return goodsDetailImgAddTime;
        }

        public void setGoodsDetailImgAddTime(String goodsDetailImgAddTime) {
            this.goodsDetailImgAddTime = goodsDetailImgAddTime;
        }

        public int getGoodsDetailImgStatus() {
            return goodsDetailImgStatus;
        }

        public void setGoodsDetailImgStatus(int goodsDetailImgStatus) {
            this.goodsDetailImgStatus = goodsDetailImgStatus;
        }
    }

    public static class GoodsImgInfosBean {
        /**
         * goodsImgId : 10
         * goodsId : 10
         * goodsImgUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
         * goodsImgAddTime : 2017-01-01 00:00:00
         * goodsImgStatus : 0
         */

        private int goodsImgId;
        private int goodsId;
        private String goodsImgUrl;
        private String goodsImgAddTime;
        private int goodsImgStatus;

        public int getGoodsImgId() {
            return goodsImgId;
        }

        public void setGoodsImgId(int goodsImgId) {
            this.goodsImgId = goodsImgId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsImgUrl() {
            return goodsImgUrl;
        }

        public void setGoodsImgUrl(String goodsImgUrl) {
            this.goodsImgUrl = goodsImgUrl;
        }

        public String getGoodsImgAddTime() {
            return goodsImgAddTime;
        }

        public void setGoodsImgAddTime(String goodsImgAddTime) {
            this.goodsImgAddTime = goodsImgAddTime;
        }

        public int getGoodsImgStatus() {
            return goodsImgStatus;
        }

        public void setGoodsImgStatus(int goodsImgStatus) {
            this.goodsImgStatus = goodsImgStatus;
        }
    }
}
