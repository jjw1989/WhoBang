package com.whombang.app.entity.city.model;

import java.util.List;
public class CityModel {

    private String name ;
    private List<DistrictModel> districtModels ;

    public List<DistrictModel> getDistrictModels() {
        return districtModels;
    }

    public void setDistrictModels(List<DistrictModel> districtModels) {
        this.districtModels = districtModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
