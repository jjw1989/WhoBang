package com.whombang.app.entity;

import com.whombang.app.common.baseadapter.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/22.
 */

public class GoodsEntity implements MultiItemEntity {
    private List<BannerInfosBean> bannerInfos;
    private List<GroupGoodsBean> groupGoods;
    private List<AnnouncementInfosBean> announcementInfos;

    public List<BannerInfosBean> getBannerInfos() {
        return bannerInfos;
    }

    public void setBannerInfos(List<BannerInfosBean> bannerInfos) {
        this.bannerInfos = bannerInfos;
    }

    public List<GroupGoodsBean> getGroupGoods() {
        return groupGoods;
    }

    public void setGroupGoods(List<GroupGoodsBean> groupGoods) {
        this.groupGoods = groupGoods;
    }

    public List<AnnouncementInfosBean> getAnnouncementInfos() {
        return announcementInfos;
    }

    public void setAnnouncementInfos(List<AnnouncementInfosBean> announcementInfos) {
        this.announcementInfos = announcementInfos;
    }

    @Override
    public int getItemType() {
        return 0;
    }

    public static class BannerInfosBean {
        /**
         * bannerId : 1
         * bannerName : 恒大冰泉促销1
         * bannerContent : 演示banner1
         * bannerDesp : 这是个演示banner
         * bannerUrl : /xxx
         * bannerType : 0
         * bannerIndex : 0
         * bannerStatus : 0
         * bannerInnerType : 0
         * bannerPosition : 0
         * bannerJumpId : 1
         * bannerImgUrl : /static/goods_imgs/hengda.jpg
         */

        private int bannerId;
        private String bannerName;
        private String bannerContent;
        private String bannerDesp;
        private String bannerUrl;
        private int bannerType;
        private int bannerIndex;
        private int bannerStatus;
        private int bannerInnerType;
        private int bannerPosition;
        private String bannerJumpId;
        private String bannerImgUrl;

        public int getBannerId() {
            return bannerId;
        }

        public void setBannerId(int bannerId) {
            this.bannerId = bannerId;
        }

        public String getBannerName() {
            return bannerName;
        }

        public void setBannerName(String bannerName) {
            this.bannerName = bannerName;
        }

        public String getBannerContent() {
            return bannerContent;
        }

        public void setBannerContent(String bannerContent) {
            this.bannerContent = bannerContent;
        }

        public String getBannerDesp() {
            return bannerDesp;
        }

        public void setBannerDesp(String bannerDesp) {
            this.bannerDesp = bannerDesp;
        }

        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }

        public int getBannerType() {
            return bannerType;
        }

        public void setBannerType(int bannerType) {
            this.bannerType = bannerType;
        }

        public int getBannerIndex() {
            return bannerIndex;
        }

        public void setBannerIndex(int bannerIndex) {
            this.bannerIndex = bannerIndex;
        }

        public int getBannerStatus() {
            return bannerStatus;
        }

        public void setBannerStatus(int bannerStatus) {
            this.bannerStatus = bannerStatus;
        }

        public int getBannerInnerType() {
            return bannerInnerType;
        }

        public void setBannerInnerType(int bannerInnerType) {
            this.bannerInnerType = bannerInnerType;
        }

        public int getBannerPosition() {
            return bannerPosition;
        }

        public void setBannerPosition(int bannerPosition) {
            this.bannerPosition = bannerPosition;
        }

        public String getBannerJumpId() {
            return bannerJumpId;
        }

        public void setBannerJumpId(String bannerJumpId) {
            this.bannerJumpId = bannerJumpId;
        }

        public String getBannerImgUrl() {
            return bannerImgUrl;
        }

        public void setBannerImgUrl(String bannerImgUrl) {
            this.bannerImgUrl = bannerImgUrl;
        }
    }

    public static class GroupGoodsBean {
        /**
         * goodsGroupSellId : 5
         * goodsId : 1
         * goodsGroupSellPrice : 12.31
         * goodsGroupOriginalCount : 80
         * goodsGroupCurrentSoldCount : 30
         * goodsGroupLastPurchaserId :
         * goodsGroupSellBeginTime : 2017-12-05
         * goodsGroupSellDeadlineTime : 2017-12-31 15:30
         * goodsGroupSellStatus : 0
         * goodsGroupSellOrigPrice : 71.52
         * goodsGroupSellUnit : 500ML*24整箱
         * goodsGroupSellName : 恒大冰泉 长白山天然矿泉水5
         * goodsGroupSellTitleImgUrl : /static/goods_imgs/hengda.jpg
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
        private double goodsGroupSellOrigPrice;
        private String goodsGroupSellUnit;
        private String goodsGroupSellName;
        private String goodsGroupSellTitleImgUrl;

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

        public double getGoodsGroupSellOrigPrice() {
            return goodsGroupSellOrigPrice;
        }

        public void setGoodsGroupSellOrigPrice(double goodsGroupSellOrigPrice) {
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
    }

    public static class AnnouncementInfosBean {
        /**
         * announcementId : 1
         * announcementName : festaval
         * announcementContent : 周末狂欢节1
         * announcementDesp : 狂欢啦狂欢啦
         * announcementUrl : /oooo
         * announcementType : 0
         * announcementIndex : 0
         * announcementStatus : 0
         * announcementInnerType : 0
         * announcementJumpId : 2
         * announcementImgUrl : /static/goods_imgs/hengda.jpg
         */

        private int announcementId;
        private String announcementName;
        private String announcementContent;
        private String announcementDesp;
        private String announcementUrl;
        private int announcementType;
        private int announcementIndex;
        private int announcementStatus;
        private int announcementInnerType;
        private String announcementJumpId;
        private String announcementImgUrl;

        public int getAnnouncementId() {
            return announcementId;
        }

        public void setAnnouncementId(int announcementId) {
            this.announcementId = announcementId;
        }

        public String getAnnouncementName() {
            return announcementName;
        }

        public void setAnnouncementName(String announcementName) {
            this.announcementName = announcementName;
        }

        public String getAnnouncementContent() {
            return announcementContent;
        }

        public void setAnnouncementContent(String announcementContent) {
            this.announcementContent = announcementContent;
        }

        public String getAnnouncementDesp() {
            return announcementDesp;
        }

        public void setAnnouncementDesp(String announcementDesp) {
            this.announcementDesp = announcementDesp;
        }

        public String getAnnouncementUrl() {
            return announcementUrl;
        }

        public void setAnnouncementUrl(String announcementUrl) {
            this.announcementUrl = announcementUrl;
        }

        public int getAnnouncementType() {
            return announcementType;
        }

        public void setAnnouncementType(int announcementType) {
            this.announcementType = announcementType;
        }

        public int getAnnouncementIndex() {
            return announcementIndex;
        }

        public void setAnnouncementIndex(int announcementIndex) {
            this.announcementIndex = announcementIndex;
        }

        public int getAnnouncementStatus() {
            return announcementStatus;
        }

        public void setAnnouncementStatus(int announcementStatus) {
            this.announcementStatus = announcementStatus;
        }

        public int getAnnouncementInnerType() {
            return announcementInnerType;
        }

        public void setAnnouncementInnerType(int announcementInnerType) {
            this.announcementInnerType = announcementInnerType;
        }

        public String getAnnouncementJumpId() {
            return announcementJumpId;
        }

        public void setAnnouncementJumpId(String announcementJumpId) {
            this.announcementJumpId = announcementJumpId;
        }

        public String getAnnouncementImgUrl() {
            return announcementImgUrl;
        }

        public void setAnnouncementImgUrl(String announcementImgUrl) {
            this.announcementImgUrl = announcementImgUrl;
        }
    }
}
