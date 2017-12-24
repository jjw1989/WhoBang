package com.whombang.app.entity;

import com.whombang.app.common.baseadapter.entity.MultiItemEntity;
import com.whombang.app.common.config.ViewType;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/22.
 */

public class GoodsEntity {


    /**
     * resultCode : 0
     * msg : success
     * data : [{"itemType":"banner","itemContentList":[{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.baidu.com","index":0,"jumpType":2,"jumpId":"0"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.sohu.com","index":0,"jumpType":2,"jumpId":"0"}],"module":"banner"},{"itemType":"announcement","itemContentList":[{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.baidu.com","index":0,"jumpType":2,"jumpId":"0"}],"module":"announcement"},{"itemType":"goodsInfo","itemContentList":[{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":1,"goodsName":"康帅傅羊肉泡馍"}],"module":"goodsInfo"}]
     */

    private int resultCode;
    private String msg;
    private List<DataBean> data;


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean implements MultiItemEntity {
        /**
         * itemType : banner
         * itemContentList : [{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.baidu.com","index":0,"jumpType":2,"jumpId":"0"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.sohu.com","index":0,"jumpType":2,"jumpId":"0"}]
         * module : banner
         */

        public String itemType;
        public String module;
        public List<ItemContentListBean> itemContentList;

        @Override
        public int getItemType() {
            if("banner".equals(itemType)){
                return ViewType.VIEW_TYPE_BANNER;
            }
            else if("announcement".equals(itemType)){
                return ViewType.VIEW_TYPE_ANNOUNCEMENT;
            }
           return ViewType.VIEW_TYPE_GOODSINFO;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public List<ItemContentListBean> getItemContentList() {
            return itemContentList;
        }

        public void setItemContentList(List<ItemContentListBean> itemContentList) {
            this.itemContentList = itemContentList;
        }

        public static class ItemContentListBean {
            /**
             * imageUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
             * clickUrl : http://www.baidu.com
             * index : 0
             * jumpType : 2
             * jumpId : 0
             */

            private String imageUrl;
            private String clickUrl;
            private int index;
            private int jumpType;
            private String jumpId;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getClickUrl() {
                return clickUrl;
            }

            public void setClickUrl(String clickUrl) {
                this.clickUrl = clickUrl;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public int getJumpType() {
                return jumpType;
            }

            public void setJumpType(int jumpType) {
                this.jumpType = jumpType;
            }

            public String getJumpId() {
                return jumpId;
            }

            public void setJumpId(String jumpId) {
                this.jumpId = jumpId;
            }
        }
    }
}
