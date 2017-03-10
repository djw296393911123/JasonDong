package com.djw.jasonlibrarytools.interfaces;


import com.djw.jasonlibrarytools.map.data.LocationData;

/**
 * Created by JasonDong on 2017/1/20.
 */

public interface locationListener {
    void locationSuccess(LocationData data);
    void locationFail(String string);
}
