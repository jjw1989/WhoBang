package com.whombang.app.entity;

import java.util.List;

/**
 * Created by David on 2017/12/23.
 */

public class OfferServiceEntity {

    private List<ServiceOrderListBean> serviceOrderList;

    public List<ServiceOrderListBean> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrderListBean> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

    public static class ServiceOrderListBean {
        /**
         * stationId : 2
         * demanderName : 高宏伟
         * individuationServiceDesc : 打扫卫生间
         * individuationServiceAddTime : 2017-12-15 17:36:37
         * contact : 13910066757
         * provideTime :
         * type : 2
         * currentLocation : 北京市牛街80号院
         * serviceOrderId : 3ffd115b75444146aaca142b222fad0d0d
         * orderId : 12312312313qqq
         * individuationServiceId : aaaaaaaaaaaa
         * userId : 907da6c5fa1841ada22cb1227b157c51
         * takeTime :
         * createTime : 2017-12-15 17:36:37
         * serviceOrderStatus : 1
         * status : 1
         * stationManagerName : 张丹枫
         * stationManagerTel : 15011465514
         * stationName : 大傻站点
         * inuserId :
         * phone :
         * userRealName :
         * userSex : 0
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
    }
}
