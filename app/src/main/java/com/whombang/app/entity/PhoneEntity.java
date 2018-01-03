package com.whombang.app.entity;

import java.util.List;

/**
 * 电话列表
 * Created by David on 2017/12/21.
 */

public class PhoneEntity {

    private List<GetProviderUserPhoneInfoListBean> getProviderUserPhoneInfoList;

    public List<GetProviderUserPhoneInfoListBean> getGetProviderUserPhoneInfoList() {
        return getProviderUserPhoneInfoList;
    }

    public void setGetProviderUserPhoneInfoList(List<GetProviderUserPhoneInfoListBean> getProviderUserPhoneInfoList) {
        this.getProviderUserPhoneInfoList = getProviderUserPhoneInfoList;
    }

    public static class GetProviderUserPhoneInfoListBean {
        /**
         * id : 1
         * userId : 470a09ea18134a28b08a7739d5fd0355
         * phone : 18611766105
         * withinPhoneList : 1
         * status : 1
         * addTime : 2017-12-26 22:48:32
         * serviceCount : 0
         * userStationId : 1
         */

        private int id;
        private String userId;
        private String phone;
        private int withinPhoneList;
        private int status;
        private String addTime;
        private int serviceCount;
        private int userStationId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getWithinPhoneList() {
            return withinPhoneList;
        }

        public void setWithinPhoneList(int withinPhoneList) {
            this.withinPhoneList = withinPhoneList;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public int getServiceCount() {
            return serviceCount;
        }

        public void setServiceCount(int serviceCount) {
            this.serviceCount = serviceCount;
        }

        public int getUserStationId() {
            return userStationId;
        }

        public void setUserStationId(int userStationId) {
            this.userStationId = userStationId;
        }
    }
}
