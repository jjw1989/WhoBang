package com.whombang.app.entity.city.model;

import java.util.List;

public class PrivinceModel {

    private String name ;
    private List<CityModel> cityModels ;

    public List<CityModel> getCityModels() {
        return cityModels;
    }

    public void setCityModels(List<CityModel> cityModels) {
        this.cityModels = cityModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
