package com.djw.jasonlibrarytools.interfaces;


import com.djw.jasonlibrarytools.map.data.SearchData;

import java.util.List;

/**
 * Created by JasonDong on 2017/1/22.
 */

public interface SearchPoiListener {
    void searchSuccess(List<SearchData> locationDatas);
    void searchFail(String msg);
}
