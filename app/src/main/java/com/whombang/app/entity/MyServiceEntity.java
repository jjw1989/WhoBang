package com.whombang.app.entity;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/20.
 */

public class MyServiceEntity {

    private List<ServiceOrderListBean> serviceOrderList;

    public List<ServiceOrderListBean> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrderListBean> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

    public static class ServiceOrderListBean {
        /**
         * stationId : 1
         * demanderName : 张三
         * individuationServiceDesc : 修水管
         * individuationServiceAddTime : 2017-12-19 21:57:18
         * contact : 15011465513
         * provideTime :
         * type : 3
         * currentLocation : 中国
         * serviceOrderId : 7610a4bd2ac64a41835c515150fb034f
         * orderId : F20171219215718708
         * individuationServiceId : 7322382e75c94dacbf8ea1652b08abcf
         * userId : 07079157402541abacfb34aab42d80e2
         * takeTime :
         * createTime : 2017-12-19 21:57:18
         * serviceOrderStatus : 1
         * status : 0
         * stationManagerName : 张丹枫
         * stationManagerTel : 15011465513
         * stationName : 大傻站点
         * inuserId :
         * phone : null
         * userRealName : null
         * userSex : null
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
        private Object phone;
        private Object userRealName;
        private Object userSex;

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

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getUserRealName() {
            return userRealName;
        }

        public void setUserRealName(Object userRealName) {
            this.userRealName = userRealName;
        }

        public Object getUserSex() {
            return userSex;
        }

        public void setUserSex(Object userSex) {
            this.userSex = userSex;
        }
    }
}
