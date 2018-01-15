package com.whombang.app.entity;

/**
 * Created by Franksun on 2018/1/14.
 */

public class ServiceDetailsEntity {

    /**
     * userorderserviceInfo : {"stationId":13,"demanderName":"站主11","individuationServiceDesc":"up家破人亡","individuationServiceAddTime":"2018-01-14 15:26:04","contact":"15000000011","provideTime":"","type":3,"currentLocation":"1265","serviceOrderId":"ae0d34559f4c421aacdb1ab33677e7c3","orderId":"F20180114152604572","individuationServiceId":"6abcdb53742540c29ef23261dbd71704","userId":"13faa9ff253b4fe8832a4c5167e35088","takeTime":"","createTime":"2018-01-14 15:26:04","serviceOrderStatus":1,"status":0,"stationManagerName":"站主11","stationManagerTel":"15000000011","stationName":"北京市垂杨柳中街5栋附近","inuserId":"","phone":"","userRealName":"","userSex":2,"finishTime":null}
     */

    private UserorderserviceInfoBean userorderserviceInfo;

    public UserorderserviceInfoBean getUserorderserviceInfo() {
        return userorderserviceInfo;
    }

    public void setUserorderserviceInfo(UserorderserviceInfoBean userorderserviceInfo) {
        this.userorderserviceInfo = userorderserviceInfo;
    }

    public static class UserorderserviceInfoBean {
        /**
         * stationId : 13
         * demanderName : 站主11
         * individuationServiceDesc : up家破人亡
         * individuationServiceAddTime : 2018-01-14 15:26:04
         * contact : 15000000011
         * provideTime :
         * type : 3
         * currentLocation : 1265
         * serviceOrderId : ae0d34559f4c421aacdb1ab33677e7c3
         * orderId : F20180114152604572
         * individuationServiceId : 6abcdb53742540c29ef23261dbd71704
         * userId : 13faa9ff253b4fe8832a4c5167e35088
         * takeTime :
         * createTime : 2018-01-14 15:26:04
         * serviceOrderStatus : 1
         * status : 0
         * stationManagerName : 站主11
         * stationManagerTel : 15000000011
         * stationName : 北京市垂杨柳中街5栋附近
         * inuserId :
         * phone :
         * userRealName :
         * userSex : 2
         * finishTime : null
         */

        private int stationId;
        private String demanderName;
        private String individuationServiceDesc;
        private String individuationServiceAddTime;
        private String contact;
        private String provideTime;
        private int type;
        private String currentLocation;
        private String serviceOrderId;
        private String orderId;
        private String individuationServiceId;
        private String userId;
        private String takeTime;
        private String createTime;
        private int serviceOrderStatus;
        private int status;
        private String stationManagerName;
        private String stationManagerTel;
        private String stationName;
        private String inuserId;
        private String phone;
        private String userRealName;
        private int userSex;
        private Object finishTime;

        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }

        public String getDemanderName() {
            return demanderName;
        }

        public void setDemanderName(String demanderName) {
            this.demanderName = demanderName;
        }

        public String getIndividuationServiceDesc() {
            return individuationServiceDesc;
        }

        public void setIndividuationServiceDesc(String individuationServiceDesc) {
            this.individuationServiceDesc = individuationServiceDesc;
        }

        public String getIndividuationServiceAddTime() {
            return individuationServiceAddTime;
        }

        public void setIndividuationServiceAddTime(String individuationServiceAddTime) {
            this.individuationServiceAddTime = individuationServiceAddTime;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getProvideTime() {
            return provideTime;
        }

        public void setProvideTime(String provideTime) {
            this.provideTime = provideTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCurrentLocation() {
            return currentLocation;
        }

        public void setCurrentLocation(String currentLocation) {
            this.currentLocation = currentLocation;
        }

        public String getServiceOrderId() {
            return serviceOrderId;
        }

        public void setServiceOrderId(String serviceOrderId) {
            this.serviceOrderId = serviceOrderId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getIndividuationServiceId() {
            return individuationServiceId;
        }

        public void setIndividuationServiceId(String individuationServiceId) {
            this.individuationServiceId = individuationServiceId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTakeTime() {
            return takeTime;
        }

        public void setTakeTime(String takeTime) {
            this.takeTime = takeTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getServiceOrderStatus() {
            return serviceOrderStatus;
        }

        public void setServiceOrderStatus(int serviceOrderStatus) {
            this.serviceOrderStatus = serviceOrderStatus;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getInuserId() {
            return inuserId;
        }

        public void setInuserId(String inuserId) {
            this.inuserId = inuserId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUserRealName() {
            return userRealName;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public Object getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(Object finishTime) {
            this.finishTime = finishTime;
        }
    }
}
