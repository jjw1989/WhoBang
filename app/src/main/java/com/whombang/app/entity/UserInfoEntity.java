package com.whombang.app.entity;

import java.util.List;

/**
 * Created by sundy.jiang on 2017/12/12.
 */

public class UserInfoEntity {


    /**
     * userInfo : {"userId":"907da6c5fa1841ada22cb1227b157c51","userRealName":"测试者","userAge":null,"userAgeScope":null,"userHeadImgUrl":null,"userNickName":null,"userTel":"15712848950","userSex":null,"userIdentityNumber":null,"userIdentityType":null,"userAddress":null,"userPassword":"lueSGJZetyySpUndWjMBEg==","userEmail":null,"userRegistTime":null,"userCurrentDevice":null,"userType":0,"userLastLoginTime":null,"userLastLogoutTime":null,"userLevel":null,"userScore":null,"userStatus":0,"userDeadTimes":null,"userInvitationCode":null,"userInvitationUserId":"f941eb2b9ea64506bca0c6eda08c7428","userStationId":2}
     * stationInfo : {"stationId":2,"stationName":"大傻站点","stationDescription":"五星级傻点，你是有多傻","stationAddress":"澳大利亚","stationLongitude":"123.1312","stationLatitude":"432.2131","stationManagerId":2,"stationLevel":0,"stationRegisteredTime":null,"stationRegisteredType":0,"stationRegisteredPerson":null,"stationWorkTime":null,"stationScore":0,"stationSaleRate1":null,"stationSaleRate2":null,"stationSaleRate3":null,"stationType":0,"stationStatus":0,"stationScale":0}
     * userAddressInfos : [{"userAddressInfoId":"00490aaba9d94eefa2991a4519255e1d","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"上海浦东新区99号","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"阿紫","userAddressContactTel":"13710000000"},{"userAddressInfoId":"121cb976214b430f8cc92727b4f0dcc1","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"北京市朝阳区大裤衩子街130号","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"段正淳","userAddressContactTel":"13710000011"},{"userAddressInfoId":"316d71464846496b9120da584c37950d","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"北京市朝阳区绿帽子街211号","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"王语嫣","userAddressContactTel":"13710000011"},{"userAddressInfoId":"454ae47f4efb4a02b833b34dfe37dcb6","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"北京市朝阳区大帽子街211号","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"虚竹","userAddressContactTel":"13710000001"},{"userAddressInfoId":"aef29cccc6ba4731be53342cd80bf0ae","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"北京市朝阳区绿帽子街211号","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"乔峰","userAddressContactTel":"13710000011"},{"userAddressInfoId":"b217a3b99bff46eb9e3efaf12f008123","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"大粪坑旁边....","userAddressDefault":0,"userAddressStatus":0,"userAddressContactPeople":"阿绿","userAddressContactTel":"13710000000"},{"userAddressInfoId":"ba42b1e75c2f42afafbd4f25531e5478","userId":"907da6c5fa1841ada22cb1227b157c51","userAddressDetail":"洛杉矶银河队主场旁边....","userAddressDefault":1,"userAddressStatus":0,"userAddressContactPeople":"阿朱","userAddressContactTel":"13710000000"}]
     * stationManagerInfo : {"stationManagerId":2,"stationManagerName":"张丹枫","stationManagerTel":"15011465514","stationManagerAddress":"四川省绵阳","stationManagerAge":0,"stationManagerComment":"莫道萍踪随逝水","stationManagerEmergencyContactName":null,"stationManagerEmergencyContactTel":null,"stationManagerScore":null,"stationManagerLevel":0,"stationManagerBonusLevel":null,"stationManagerBonusMoney":0.05,"stationManagerSaleRate":0.04,"stationManagerStatus":0,"userId":"f941eb2b9ea64506bca0c6eda08c7428","stationId":2}
     */

    private UserInfoBean userInfo;
    private StationInfoBean stationInfo;
    private StationManagerInfoBean stationManagerInfo;
    private List<UserAddressInfosBean> userAddressInfos;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public StationInfoBean getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(StationInfoBean stationInfo) {
        this.stationInfo = stationInfo;
    }

    public StationManagerInfoBean getStationManagerInfo() {
        return stationManagerInfo;
    }

    public void setStationManagerInfo(StationManagerInfoBean stationManagerInfo) {
        this.stationManagerInfo = stationManagerInfo;
    }

    public List<UserAddressInfosBean> getUserAddressInfos() {
        return userAddressInfos;
    }

    public void setUserAddressInfos(List<UserAddressInfosBean> userAddressInfos) {
        this.userAddressInfos = userAddressInfos;
    }

    public static class UserInfoBean {
        /**
         * userId : 07079157402541abacfb34aab42d80e2
         * userRealName : 站主张丹枫
         * userAge : 0
         * userAgeScope : 1
         * userHeadImgUrl :
         * userNickName :
         * userTel : 15011465513
         * userSex : 0
         * userIdentityNumber :
         * userIdentityType : 1
         * userAddress :
         * userPassword : lueSGJZetyySpUndWjMBEg==
         * userEmail :
         * userRegistTime :
         * userCurrentDevice : 1
         * userType : 1
         * userLastLoginTime : 2017-12-16 16:46:43
         * userLastLogoutTime : 2017-12-15 16:41:08
         * userLevel : 1
         * userScore : 0
         * userStatus : 0
         * userDeadTimes : 0
         * userInvitationCode : 11086570
         * userInvitationUserId :
         * userStationId : 0
         */

        private String userId;
        private String userRealName;
        private int userAge;
        private int userAgeScope;
        private String userHeadImgUrl;
        private String userNickName;
        private String userTel;
        private int userSex;
        private String userIdentityNumber;
        private int userIdentityType;
        private String userAddress;
        private String userPassword;
        private String userEmail;
        private String userRegistTime;
        private int userCurrentDevice;
        private int userType;
        private String userLastLoginTime;
        private String userLastLogoutTime;
        private int userLevel;
        private int userScore;
        private int userStatus;
        private int userDeadTimes;
        private String userInvitationCode;
        private String userInvitationUserId;
        private int userStationId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserRealName() {
            return userRealName;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }

        public int getUserAge() {
            return userAge;
        }

        public void setUserAge(int userAge) {
            this.userAge = userAge;
        }

        public int getUserAgeScope() {
            return userAgeScope;
        }

        public void setUserAgeScope(int userAgeScope) {
            this.userAgeScope = userAgeScope;
        }

        public String getUserHeadImgUrl() {
            return userHeadImgUrl;
        }

        public void setUserHeadImgUrl(String userHeadImgUrl) {
            this.userHeadImgUrl = userHeadImgUrl;
        }

        public String getUserNickName() {
            return userNickName;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserIdentityNumber() {
            return userIdentityNumber;
        }

        public void setUserIdentityNumber(String userIdentityNumber) {
            this.userIdentityNumber = userIdentityNumber;
        }

        public int getUserIdentityType() {
            return userIdentityType;
        }

        public void setUserIdentityType(int userIdentityType) {
            this.userIdentityType = userIdentityType;
        }

        public String getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserRegistTime() {
            return userRegistTime;
        }

        public void setUserRegistTime(String userRegistTime) {
            this.userRegistTime = userRegistTime;
        }

        public int getUserCurrentDevice() {
            return userCurrentDevice;
        }

        public void setUserCurrentDevice(int userCurrentDevice) {
            this.userCurrentDevice = userCurrentDevice;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getUserLastLoginTime() {
            return userLastLoginTime;
        }

        public void setUserLastLoginTime(String userLastLoginTime) {
            this.userLastLoginTime = userLastLoginTime;
        }

        public String getUserLastLogoutTime() {
            return userLastLogoutTime;
        }

        public void setUserLastLogoutTime(String userLastLogoutTime) {
            this.userLastLogoutTime = userLastLogoutTime;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public int getUserScore() {
            return userScore;
        }

        public void setUserScore(int userScore) {
            this.userScore = userScore;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public int getUserDeadTimes() {
            return userDeadTimes;
        }

        public void setUserDeadTimes(int userDeadTimes) {
            this.userDeadTimes = userDeadTimes;
        }

        public String getUserInvitationCode() {
            return userInvitationCode;
        }

        public void setUserInvitationCode(String userInvitationCode) {
            this.userInvitationCode = userInvitationCode;
        }

        public String getUserInvitationUserId() {
            return userInvitationUserId;
        }

        public void setUserInvitationUserId(String userInvitationUserId) {
            this.userInvitationUserId = userInvitationUserId;
        }

        public int getUserStationId() {
            return userStationId;
        }

        public void setUserStationId(int userStationId) {
            this.userStationId = userStationId;
        }
    }

    public static class StationInfoBean {
        /**
         * stationId : 2
         * stationName : 大傻站点
         * stationDescription : 五星级傻点，你是有多傻
         * stationAddress : 澳大利亚
         * stationLongitude : 123.1312
         * stationLatitude : 432.2131
         * stationManagerId : 2
         * stationLevel : 0
         * stationRegisteredTime : null
         * stationRegisteredType : 0
         * stationRegisteredPerson : null
         * stationWorkTime : null
         * stationScore : 0
         * stationSaleRate1 : null
         * stationSaleRate2 : null
         * stationSaleRate3 : null
         * stationType : 0
         * stationStatus : 0
         * stationScale : 0
         */

        private int stationId;
        private String stationName;
        private String stationDescription;
        private String stationAddress;
        private String stationLongitude;
        private String stationLatitude;
        private int stationManagerId;
        private int stationLevel;
        private Object stationRegisteredTime;
        private int stationRegisteredType;
        private Object stationRegisteredPerson;
        private Object stationWorkTime;
        private int stationScore;
        private Object stationSaleRate1;
        private Object stationSaleRate2;
        private Object stationSaleRate3;
        private int stationType;
        private int stationStatus;
        private int stationScale;

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

        public int getStationManagerId() {
            return stationManagerId;
        }

        public void setStationManagerId(int stationManagerId) {
            this.stationManagerId = stationManagerId;
        }

        public int getStationLevel() {
            return stationLevel;
        }

        public void setStationLevel(int stationLevel) {
            this.stationLevel = stationLevel;
        }

        public Object getStationRegisteredTime() {
            return stationRegisteredTime;
        }

        public void setStationRegisteredTime(Object stationRegisteredTime) {
            this.stationRegisteredTime = stationRegisteredTime;
        }

        public int getStationRegisteredType() {
            return stationRegisteredType;
        }

        public void setStationRegisteredType(int stationRegisteredType) {
            this.stationRegisteredType = stationRegisteredType;
        }

        public Object getStationRegisteredPerson() {
            return stationRegisteredPerson;
        }

        public void setStationRegisteredPerson(Object stationRegisteredPerson) {
            this.stationRegisteredPerson = stationRegisteredPerson;
        }

        public Object getStationWorkTime() {
            return stationWorkTime;
        }

        public void setStationWorkTime(Object stationWorkTime) {
            this.stationWorkTime = stationWorkTime;
        }

        public int getStationScore() {
            return stationScore;
        }

        public void setStationScore(int stationScore) {
            this.stationScore = stationScore;
        }

        public Object getStationSaleRate1() {
            return stationSaleRate1;
        }

        public void setStationSaleRate1(Object stationSaleRate1) {
            this.stationSaleRate1 = stationSaleRate1;
        }

        public Object getStationSaleRate2() {
            return stationSaleRate2;
        }

        public void setStationSaleRate2(Object stationSaleRate2) {
            this.stationSaleRate2 = stationSaleRate2;
        }

        public Object getStationSaleRate3() {
            return stationSaleRate3;
        }

        public void setStationSaleRate3(Object stationSaleRate3) {
            this.stationSaleRate3 = stationSaleRate3;
        }

        public int getStationType() {
            return stationType;
        }

        public void setStationType(int stationType) {
            this.stationType = stationType;
        }

        public int getStationStatus() {
            return stationStatus;
        }

        public void setStationStatus(int stationStatus) {
            this.stationStatus = stationStatus;
        }

        public int getStationScale() {
            return stationScale;
        }

        public void setStationScale(int stationScale) {
            this.stationScale = stationScale;
        }
    }


    public static class StationManagerInfoBean {
        /**
         * stationManagerId : 1
         * stationManagerName : 张丹枫
         * stationManagerTel : 15011465513
         * stationManagerAddress : 四川省绵阳
         * stationManagerAge : 0
         * stationManagerComment : 莫道萍踪随逝水
         * stationManagerEmergencyContactName : null
         * stationManagerEmergencyContactTel : null
         * stationManagerScore : null
         * stationManagerLevel : 0
         * stationManagerBonusLevel : null
         * stationManagerBonusMoney : 0.05
         * stationManagerSaleRate : 0.04
         * stationManagerStatus : 0
         * userId : 07079157402541abacfb34aab42d80e2
         * stationId : 1
         */

        private int stationManagerId;
        private String stationManagerName;
        private String stationManagerTel;
        private String stationManagerAddress;
        private int stationManagerAge;
        private String stationManagerComment;
        private Object stationManagerEmergencyContactName;
        private Object stationManagerEmergencyContactTel;
        private Object stationManagerScore;
        private int stationManagerLevel;
        private Object stationManagerBonusLevel;
        private double stationManagerBonusMoney;
        private double stationManagerSaleRate;
        private int stationManagerStatus;
        private String userId;
        private int stationId;

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

        public int getStationManagerAge() {
            return stationManagerAge;
        }

        public void setStationManagerAge(int stationManagerAge) {
            this.stationManagerAge = stationManagerAge;
        }

        public String getStationManagerComment() {
            return stationManagerComment;
        }

        public void setStationManagerComment(String stationManagerComment) {
            this.stationManagerComment = stationManagerComment;
        }

        public Object getStationManagerEmergencyContactName() {
            return stationManagerEmergencyContactName;
        }

        public void setStationManagerEmergencyContactName(Object stationManagerEmergencyContactName) {
            this.stationManagerEmergencyContactName = stationManagerEmergencyContactName;
        }

        public Object getStationManagerEmergencyContactTel() {
            return stationManagerEmergencyContactTel;
        }

        public void setStationManagerEmergencyContactTel(Object stationManagerEmergencyContactTel) {
            this.stationManagerEmergencyContactTel = stationManagerEmergencyContactTel;
        }

        public Object getStationManagerScore() {
            return stationManagerScore;
        }

        public void setStationManagerScore(Object stationManagerScore) {
            this.stationManagerScore = stationManagerScore;
        }

        public int getStationManagerLevel() {
            return stationManagerLevel;
        }

        public void setStationManagerLevel(int stationManagerLevel) {
            this.stationManagerLevel = stationManagerLevel;
        }

        public Object getStationManagerBonusLevel() {
            return stationManagerBonusLevel;
        }

        public void setStationManagerBonusLevel(Object stationManagerBonusLevel) {
            this.stationManagerBonusLevel = stationManagerBonusLevel;
        }

        public double getStationManagerBonusMoney() {
            return stationManagerBonusMoney;
        }

        public void setStationManagerBonusMoney(double stationManagerBonusMoney) {
            this.stationManagerBonusMoney = stationManagerBonusMoney;
        }

        public double getStationManagerSaleRate() {
            return stationManagerSaleRate;
        }

        public void setStationManagerSaleRate(double stationManagerSaleRate) {
            this.stationManagerSaleRate = stationManagerSaleRate;
        }

        public int getStationManagerStatus() {
            return stationManagerStatus;
        }

        public void setStationManagerStatus(int stationManagerStatus) {
            this.stationManagerStatus = stationManagerStatus;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }
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
}
