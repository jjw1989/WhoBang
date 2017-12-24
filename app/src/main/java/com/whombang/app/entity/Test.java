package com.whombang.app.entity;

import java.util.List;

/**
 * Created by David on 2017/12/24.
 */

public class Test {

    /**
     * itemType : banner
     * itemContentList : [{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.baidu.com","index":0,"jumpType":2,"jumpId":"0"},{"imageUrl":"http://47.104.105.135:8080/WhomBangServer/static/goods_imgs/hengda.jpg","clickUrl":"http://www.sohu.com","index":0,"jumpType":2,"jumpId":"0"}]
     * module : banner
     */

    private String itemType;
    private String module;
    private List<ItemContentListBean> itemContentList;

    public String getItemType() {
        return itemType;
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
