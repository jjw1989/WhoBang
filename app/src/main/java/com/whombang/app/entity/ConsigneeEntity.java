package com.whombang.app.entity;

import java.util.List;

/**
 * 收件人地址管理
 * Created by sundy.jiang on 2017/11/29.
 */

public class ConsigneeEntity {
    private List<UserAddressInfosBean> userAddressInfos;

    public List<UserAddressInfosBean> getUserAddressInfos() {
        return userAddressInfos;
    }

    public void setUserAddressInfos(List<UserAddressInfosBean> userAddressInfos) {
        this.userAddressInfos = userAddressInfos;
    }

    public static class UserAddressInfosBean {
        /**
         * userAddressInfoId : 00490aaba9d94eefa2991a4519255e1d
         * userId : 907da6c5fa1841ada22cb1227b157c51
         * userAddressDetail : 上海浦东新区99号
         * userAddressDefault : 0
         * userAddressStatus : 0
         * userAddressContactPeople : 阿紫
         * userAddressContactTel : 13710000000
         */

        private String userAddressInfoId;
        private String userId;
        private String userAddressDetail;
        private int userAddressDefault;
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

        public int getUserAddressDefault() {
            return userAddressDefault;
        }

        public void setUserAddressDefault(int userAddressDefault) {
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

//    private int id ;
//    private String consignee ;
//    private String phone ;
//    private String addr ;
//    private String zipCode ;
//    private boolean isDefault ;
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getConsignee() {
//        return consignee;
//    }
//
//    public void setConsignee(String consignee) {
//        this.consignee = consignee;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddr() {
//        return addr;
//    }
//
//    public void setAddr(String addr) {
//        this.addr = addr;
//    }
//
//    public boolean isDefault() {
//        return isDefault;
//    }
//
//    public void setDefault(boolean aDefault) {
//        isDefault = aDefault;
//    }

}
