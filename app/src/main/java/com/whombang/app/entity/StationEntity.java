package com.whombang.app.entity;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/28.
 */

public class StationEntity {

    private List<StationInfoBean> stationInfo;

    public List<StationInfoBean> getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(List<StationInfoBean> stationInfo) {
        this.stationInfo = stationInfo;
    }

    public static class StationInfoBean {
        /**
         * stationId : 1
         * stationName : 测试站点（张）
         * stationDescription : 五星级测试站点
         * stationAddress : 澳大利亚
         * stationLongitude : 123.1312
         * stationLatitude : 432.2131
         * stationLevel : 0
         * stationManagerId : 1
         * stationManagerName : 张丹枫
         * stationManagerTel : 15011465518
         * stationManagerAddress : 四川省绵阳
         */

        private int stationId;
        private String stationName;
        private String stationDescription;
        private String stationAddress;
        private String stationLongitude;
        private String stationLatitude;
        private int stationLevel;
        private int stationManagerId;
        private String stationManagerName;
        private String stationManagerTel;
        private String stationManagerAddress;

        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationDescription() {
            return stationDescription;
        }

        public void setStationDescription(String stationDescription) {
            this.stationDescription = stationDescription;
        }

        public String getStationAddress() {
            return stationAddress;
        }

        public void setStationAddress(String stationAddress) {
            this.stationAddress = stationAddress;
        }

        public String getStationLongitude() {
            return stationLongitude;
        }

        public void setStationLongitude(String stationLongitude) {
            this.stationLongitude = stationLongitude;
        }

        public String getStationLatitude() {
            return stationLatitude;
        }

        public void setStationLatitude(String stationLatitude) {
            this.stationLatitude = stationLatitude;
        }

        public int getStationLevel() {
            return stationLevel;
        }

        public void setStationLevel(int stationLevel) {
            this.stationLevel = stationLevel;
        }

        public int getStationManagerId() {
            return stationManagerId;
        }

        public void setStationManagerId(int stationManagerId) {
            this.stationManagerId = stationManagerId;
        }

        public String getStationManagerName() {
            return stationManagerName;
        }

        public void setStationManagerName(String stationManagerName) {
            this.stationManagerName = stationManagerName;
        }

        public String getStationManagerTel() {
            return stationManagerTel;
        }

        public void setStationManagerTel(String stationManagerTel) {
            this.stationManagerTel = stationManagerTel;
        }

        public String getStationManagerAddress() {
            return stationManagerAddress;
        }

        public void setStationManagerAddress(String stationManagerAddress) {
            this.stationManagerAddress = stationManagerAddress;
        }
    }
}
