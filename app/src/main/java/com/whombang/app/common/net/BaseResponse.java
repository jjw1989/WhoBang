package com.whombang.app.common.net;


/**
 * 网络返回基类 支持泛型
 * Created by Tamic on 2016-06-06.
 * {@link # https://github.com/Tamicer/RetrofitClient}
 */
public class BaseResponse<T> {

    private int resultCode;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return resultCode == 0;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + resultCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
