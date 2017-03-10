package com.djw.jasonlibrarytools.map;

import android.content.Context;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;

/**
 * Created by JasonDong on 2017/1/22.
 */

public class LocationMap implements LocationSource {
    private static LocationMap locationMap;

    private LocationMap(Context context) {
        initMap(context);
    }

    public static LocationMap newInstance(Context context) {
        if (locationMap == null)
            locationMap = new LocationMap(context);
        return locationMap;
    }

    private void initMap(Context context) {

    }

    public void startLocation(AMap map){
        // 设置定位监听
        map.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        map.setMyLocationEnabled(true);
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        
    }

    @Override
    public void deactivate() {

    }
}
