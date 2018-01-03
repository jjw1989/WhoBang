package com.whombang.app.entity;

/**
 * Created by sundy.jiang on 2018/1/3.
 */

public class DefaultAddressEntity {

    /**
     * userDefaultAddress : {"userAddressInfoId":"021b1cf37d0b47868c4a197ab11c4939","userId":"0d0e53b9d2114444854fe13606ce583b","userAddressDetail":"福建省龙岩市连城县刚刚好","userAddressDefault":true,"userAddressStatus":0,"userAddressContactPeople":"刚刚干活","userAddressContactTel":"12345678909"}
     */

    private UserDefaultAddressBean userDefaultAddress;

    public UserDefaultAddressBean getUserDefaultAddress() {
        return userDefaultAddress;
    }

    public void setUserDefaultAddress(UserDefaultAddressBean userDefaultAddress) {
        this.userDefaultAddress = userDefaultAddress;
    }

    public static class UserDefaultAddressBean {
        /**
         * userAddressInfoId : 021b1cf37d0b47868c4a197ab11c4939
         * userId : 0d0e53b9d2114444854fe13606ce583b
         * userAddressDetail : 福建省龙岩市连城县刚刚好
         * userAddressDefault : true
         * userAddressStatus : 0
         * userAddressContactPeople : 刚刚干活
         * userAddressContactTel : 12345678909
         */

        private String userAddressInfoId;
        private String userId;
        private String userAddressDetail;
        private boolean userAddressDefault;
        private int userAddressStatus;
        private String userAddressContactPeople;
        private String userAddressContactTel;

        public String getUserAddressInfoId() {
            return userAddressInfoId;
        }

        public void setUserAddressInfoId(String userAddressInfoId) {
            this.userAddressInfoId = userAddressInfoId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserAddressDetail() {
            return userAddressDetail;
        }

        public void setUserAddressDetail(String userAddressDetail) {
            this.userAddressDetail = userAddressDetail;
        }

        public boolean isUserAddressDefault() {
            return userAddressDefault;
        }

        public void setUserAddressDefault(boolean userAddressDefault) {
            this.userAddressDefault = userAddressDefault;
        }

        public int getUserAddressStatus() {
            return userAddressStatus;
        }

        public void setUserAddressStatus(int userAddressStatus) {
            this.userAddressStatus = userAddressStatus;
        }

        public String getUserAddressContactPeople() {
            return userAddressContactPeople;
        }

        public void setUserAddressContactPeople(String userAddressContactPeople) {
            this.userAddressContactPeople = userAddressContactPeople;
        }

        public String getUserAddressContactTel() {
            return userAddressContactTel;
        }

        public void setUserAddressContactTel(String userAddressContactTel) {
            this.userAddressContactTel = userAddressContactTel;
        }
    }
}
