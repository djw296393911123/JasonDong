package com.djw.jasonlibrarytools.interfaces;


import com.djw.jasonlibrarytools.map.data.InputSearchData;

import java.util.List;

/**
 * Created by JasonDong on 2017/1/22.
 */

public interface InputSearchListener {
    void inputSearchSuccess(List<InputSearchData> inputSearchDatas);
    void inputSearchFail(String msg);
}
