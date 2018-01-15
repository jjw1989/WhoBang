package com.whombang.app.entity.event;

/**
 * Created by sundy.jiang on 2018/1/15.
 */

public class EventAddress {
    public String stationName;
    public String stationAddress;
    public String stationPhone;

    public EventAddress(String stationName, String stationAddress, String stationPhone) {
        this.stationName = stationName;
        this.stationAddress = stationAddress;
        this.stationPhone = stationPhone;
    }
}
