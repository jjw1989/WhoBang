package com.whombang.app.common.entity;

/**
 * 实体基类
 * Created by David on 2017/12/9.
 */

public class BaseEntity {

    /**
     * resultCode : -3
     * msg : total amount exceeded
     * data : {}
     */

    private int resultCode;
    private String msg;
    private DataBean data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
