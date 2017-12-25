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
     * data : [{"itemType":"goodsInfo","itemContentList":[{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":32,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":31,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":30,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":29,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":28,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":27,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":26,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":25,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":24,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":23,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":22,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":21,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":20,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":19,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":18,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":17,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":16,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":15,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":14,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":13,"goodsName":"康帅傅羊肉泡馍"}],"module":"goodsInfo"}]
     */

    public int resultCode;
    public String msg;
    public List<DataBean> data;



    public static class DataBean implements MultiItemEntity {
        /**
         * itemType : goodsInfo
         * itemContentList : [{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":32,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":31,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":30,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":29,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":28,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":27,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":26,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":25,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":24,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":23,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":22,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":21,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":20,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":19,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":18,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":17,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":16,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":15,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":14,"goodsName":"康帅傅羊肉泡馍"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"","index":"","jumpType":"","jumpId":"","originalPrice":0,"sellPrice":80.5,"sellUnit":"整箱（x20)","beginTime":"2017-12-24","endTime":"2017-12-26","goodsId":10,"goodsSellId":13,"goodsName":"康帅傅羊肉泡馍"}]
         * module : goodsInfo
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "itemType='" + itemType + '\'' +
                    ", module='" + module + '\'' +
                    ", itemContentList=" + itemContentList +
                    '}';
        }

        public static class ItemContentListBean {
            /**
             * imageUrl : http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg
             * clickUrl :
             * index :
             * jumpType :
             * jumpId :
             * originalPrice : 0
             * sellPrice : 80.5
             * sellUnit : 整箱（x20)
             * beginTime : 2017-12-24
             * endTime : 2017-12-26
             * goodsId : 10
             * goodsSellId : 32
             * goodsName : 康帅傅羊肉泡馍
             */

            public String imageUrl;
            public String clickUrl;
            public String index;
            public String jumpType;
            public String jumpId;
            public int originalPrice;
            public double sellPrice;
            public String sellUnit;
            public String beginTime;
            public String endTime;
            public int goodsId;
            public int goodsSellId;
            public String goodsName;

            @Override
            public String toString() {
                return "ItemContentListBean{" +
                        "imageUrl='" + imageUrl + '\'' +
                        ", clickUrl='" + clickUrl + '\'' +
                        ", index='" + index + '\'' +
                        ", jumpType='" + jumpType + '\'' +
                        ", jumpId='" + jumpId + '\'' +
                        ", originalPrice=" + originalPrice +
                        ", sellPrice=" + sellPrice +
                        ", sellUnit='" + sellUnit + '\'' +
                        ", beginTime='" + beginTime + '\'' +
                        ", endTime='" + endTime + '\'' +
                        ", goodsId=" + goodsId +
                        ", goodsSellId=" + goodsSellId +
                        ", goodsName='" + goodsName + '\'' +
                        '}';
            }
        }
    }
}
