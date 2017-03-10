package com.djw.jasonlibrarytools.map.data;

import android.icu.text.SimpleDateFormat;

/**
 * Created by JasonDong on 2017/1/20.
 */

public class LocationData {
    /**
     * 定位结果来源
     */
    private int locationType;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 地址
     */
    private String adress;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 城区信息
     */
    private String district;

    /**
     * 街道信息
     */
    private String stress;

    /**
     * 街道门牌号
     */
    private String stressNum;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 地区编码
     */
    private String AdCode;

    /**
     * AOI name
     */
    private String aoiName;

    /**
     * 定位时间
     */
    private long LocationTime;

    /**
     * 搜索返回name
     */
    private String name;

    public LocationData(int locationType, double latitude, double longitude, String adress, String country, String province, String city, String district, String stress, String stressNum, String cityCode, String adCode, String aoiName, long locationTime) {
        this.locationType = locationType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.adress = adress;
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.stress = stress;
        this.stressNum = stressNum;
        this.cityCode = cityCode;
        AdCode = adCode;
        this.aoiName = aoiName;
        LocationTime = locationTime;
    }

    public LocationData(String adCode,String adress,String name,double latitude,double longitude,String district){
        this.AdCode = adCode;
        this.adress = adress;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public String getStressNum() {
        return stressNum;
    }

    public void setStressNum(String stressNum) {
        this.stressNum = stressNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return AdCode;
    }

    public void setAdCode(String adCode) {
        AdCode = adCode;
    }

    public String getAoiName() {
        return aoiName;
    }

    public void setAoiName(String aoiName) {
        this.aoiName = aoiName;
    }

    public long getLocationTime() {
        return LocationTime;
    }

    public void setLocationTime(long locationTime) {
        LocationTime = locationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocationData{" +
                "locationType=" + locationType +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", adress='" + adress + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", stress='" + stress + '\'' +
                ", stressNum='" + stressNum + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", AdCode='" + AdCode + '\'' +
                ", aoiName='" + aoiName + '\'' +
                ", LocationTime=" + LocationTime +
                ", name='" + name + '\'' +
                '}';
    }
}
