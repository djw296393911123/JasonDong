package com.djw.jasonlibrarytools.map.data;

import com.amap.api.services.core.LatLonPoint;

/**
 * Created by JasonDong on 2017/1/22.
 */

public class SearchData {
    /**
     * POI 的行政区划代码。
     */
    private String adCode;

    /**
     * POI 的行政区划名称。
     */
    private String adName;

    /**
     * POI的城市编码
     */
    private String cityCode;

    /**
     * POI的城市名称。
     */
    private String cityName;

    /**
     * POI 距离中心点的距离。
     */
    private int distance;

    /**
     * POI入口经纬度。
     */
    private LatLonPoint enter;

    /**
     * POI出口经纬度。
     */
    private LatLonPoint exit;

    /**
     * POI经纬度
     */
    private LatLonPoint latlon;

    /**
     *  POI 的省/自治区/直辖市/特别行政区编码。
     */
    private String provinceCode;

    /**
     * POI的省/自治区/直辖市/特别行政区名称 。
     */
    private String provinceName;

    /**
     * POI的地址。
     */
    private String snippet;

    /**
     * POI的电话号码。
     */
    private String phone;

    /**
     * POI的名称。
     */
    private String title;

    public SearchData(String adCode, String adName, String cityCode, String cityName, int distance, LatLonPoint enter, LatLonPoint exit, LatLonPoint latlon, String provinceCode, String provinceName, String snippet, String phone, String title) {
        this.adCode = adCode;
        this.adName = adName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.distance = distance;
        this.enter = enter;
        this.exit = exit;
        this.latlon = latlon;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.snippet = snippet;
        this.phone = phone;
        this.title = title;
    }

    public LatLonPoint getLatlon() {
        return latlon;
    }

    public void setLatlon(LatLonPoint latlon) {
        this.latlon = latlon;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LatLonPoint getEnter() {
        return enter;
    }

    public void setEnter(LatLonPoint enter) {
        this.enter = enter;
    }

    public LatLonPoint getExit() {
        return exit;
    }

    public void setExit(LatLonPoint exit) {
        this.exit = exit;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "adCode='" + adCode + '\'' +
                ", adName='" + adName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", distance=" + distance +
                ", enter=" + enter +
                ", exit=" + exit +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", snippet='" + snippet + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
