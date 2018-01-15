package com.whombang.amaplibrary.model;

import java.util.ArrayList;
import java.util.List;


public class MarkerInfo {

    private String markerId;
    private double markerLat;
    private double markerLon;
    private String markerIcon;
    private String markerName;
    private String stationName;
    private String stationAddress;
    private String stationManagerTel;

    public String getMarkerId() {
        return markerId;
    }

    public void setMarkerId(String markerId) {
        this.markerId = markerId;
    }

    public double getMarkerLat() {
        return markerLat;
    }

    public void setMarkerLat(double markerLat) {
        this.markerLat = markerLat;
    }

    public double getMarkerLon() {
        return markerLon;
    }

    public void setMarkerLon(double markerLon) {
        this.markerLon = markerLon;
    }

    public String getMarkerIcon() {
        return markerIcon;
    }

    public void setMarkerIcon(String markerIcon) {
        this.markerIcon = markerIcon;
    }

    public String getMarkerName() {
        return markerName;
    }

    public void setMarkerName(String markerName) {
        this.markerName = markerName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getStationManagerTel() {
        return stationManagerTel;
    }

    public void setStationManagerTel(String stationManagerTel) {
        this.stationManagerTel = stationManagerTel;
    }
}
