package com.djw.jasonlibrarytools.map.data;

/**
 * Created by JasonDong on 2017/1/22.
 */

public class InputSearchData {
    private String adress;
    private String name;
    private double latitude;
    private double longitude;
    private String district;
    private String adCode;

    public InputSearchData(String adCode, String adress, String name, double latitude, double longitude, String district) {
        this.adCode = adCode;
        this.adress = adress;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    @Override
    public String toString() {
        return "InputSearchData{" +
                "adress='" + adress + '\'' +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", district='" + district + '\'' +
                ", adCode='" + adCode + '\'' +
                '}';
    }
}
