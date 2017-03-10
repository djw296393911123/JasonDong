package com.djw.jasonlibrarytools.map;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.djw.jasonlibrarytools.interfaces.locationListener;
import com.djw.jasonlibrarytools.map.data.LocationData;

/**
 * Created by JasonDong on 2017/1/20.
 */

public class Location implements AMapLocationListener {

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;

    private static Location location;

    private locationListener listener;

    private Location(Context context) {
        initLocation(context);
    }

    public static Location newInstance(Context context) {
        if (location == null) {
            location = new Location(context);
        }
        return location;
    }

    private void initLocation(Context context) {
        //初始化定位
        mLocationClient = new AMapLocationClient(context);
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //配置地图参数
        initMapOption(mLocationOption);
    }

    public void startLocation(locationListener locationListener) {
        //启动定位
        mLocationClient.startLocation();
        setOnLocationListener(locationListener);
    }

    private void initMapOption(AMapLocationClientOption mLocationOption) {

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(false);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，
        // 启动定位时SDK会返回最近3s内精度最高的一次定位结果。
        // 如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocation(false);

        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(2000);

        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);

        //设置是否强制刷新WIFI，默认为true，强制刷新。
        mLocationOption.setWifiActiveScan(true);

        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);

        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);

        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    }

    public void setOnLocationListener(locationListener listener) {
        this.listener = listener;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            //定位成功
            if (aMapLocation.getErrorCode() == 0) {
                listener.locationSuccess(
                        new LocationData(
                                aMapLocation.getLocationType(),
                                aMapLocation.getLatitude(),
                                aMapLocation.getLongitude(),
                                aMapLocation.getAddress(),
                                aMapLocation.getCountry(),
                                aMapLocation.getProvince(),
                                aMapLocation.getCity(),
                                aMapLocation.getDistrict(),
                                aMapLocation.getStreet(),
                                aMapLocation.getStreetNum(),
                                aMapLocation.getCityCode(),
                                aMapLocation.getAdCode(),
                                aMapLocation.getAoiName(),
                                aMapLocation.getTime()
                        ));
            } else {
                //定位失败
                listener.locationFail("定位失败");
            }
        }
    }
}
