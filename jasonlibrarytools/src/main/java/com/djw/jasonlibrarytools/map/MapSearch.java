package com.djw.jasonlibrarytools.map;

import android.content.Context;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.djw.jasonlibrarytools.R;
import com.djw.jasonlibrarytools.interfaces.InputSearchListener;
import com.djw.jasonlibrarytools.interfaces.SearchPoiListener;
import com.djw.jasonlibrarytools.map.data.InputSearchData;
import com.djw.jasonlibrarytools.map.data.SearchData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonDong on 2017/1/20.
 */

public class MapSearch implements PoiSearch.OnPoiSearchListener, Inputtips.InputtipsListener {

    private static MapSearch mapSearch;
    private Context context;
    private PoiSearch.Query query;
    private InputSearchListener inputSearchLisetener;
    private SearchPoiListener searchPoiListener;
    private String keys;

    private MapSearch(Context context) {
        initSearch(context);
    }

    public static MapSearch newInstance(Context context) {
        if (mapSearch == null) {
            mapSearch = new MapSearch(context);
        }
        return mapSearch;
    }

    private void initSearch(Context context) {
        this.context = context;
        String[] pois = context.getResources().getStringArray(R.array.poi);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pois.length; i++) {
            sb.append(pois[i]);
            if (i != pois.length - 1)
                sb.append("|");
        }
        keys = sb.toString();
    }

    /**
     * 根据经纬度搜索
     * @param latLonPoint 经纬度
     * @param code 城市code
     * @param cruPage 查询页码
     * @param listener 监听回调
     */
    public void latLonPoiSearch(LatLonPoint latLonPoint,String code,int cruPage,SearchPoiListener listener){
        query = new PoiSearch.Query("", keys, code);
        query.setPageSize(20);
        query.setPageNum(cruPage);
        PoiSearch poiSearch = new PoiSearch(context, query);
        //设置周边搜索的中心点以及半径
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()), 1000));
        poiSearch.setOnPoiSearchListener(this);
        setOnSearchLisetener(listener);
        poiSearch.searchPOIAsyn();
    }

    /**
     * 关键字搜索
     *
     * @param keyWord  关键字
     * @param cityCode 城市id
     * @param curPage  查询页码
     */
    public void keywordsPoiSearch(String keyWord, String cityCode, int curPage, SearchPoiListener listener) {
        query = new PoiSearch.Query(keyWord, keys, cityCode);
        query.setPageSize(10);
        query.setPageNum(curPage);
        PoiSearch poiSearch = new PoiSearch(context, query);
        poiSearch.setOnPoiSearchListener(this);
        setOnSearchLisetener(listener);
        //开始搜索
        poiSearch.searchPOIAsyn();
    }

    /**
     * 自动提示搜索
     *
     * @param keyword 搜索关键字
     * @param city    搜索城市
     */
    public void inPutPoiSearch(String keyword, String city, InputSearchListener listener) {
        //第二个参数传入null或者“”代表在全国进行检索，否则按照传入的city进行检索
        InputtipsQuery inputquery = new InputtipsQuery(keyword, city);
        inputquery.setCityLimit(true);//限制在当前城市
        Inputtips inputTips = new Inputtips(context, inputquery);
        inputTips.setInputtipsListener(this);
        setOnInputSearchLisetener(listener);
        //开始搜索
        inputTips.requestInputtipsAsyn();
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        if (i == 1000) {//搜索成功
            if (poiResult != null && poiResult.getQuery() != null) {
                if (poiResult.getQuery().equals(query)) {
                    ArrayList<PoiItem> poiItems = poiResult.getPois();
                    if (poiItems != null && poiItems.size() > 0) {
                        List<SearchData> searchDatas = new ArrayList<>();
                        for (int j = 0; j < poiItems.size(); j++) {
                            PoiItem poiItem = poiItems.get(j);
                            searchDatas.add(new SearchData(
                                    poiItem.getAdCode(),
                                    poiItem.getAdName(),
                                    poiItem.getCityCode(),
                                    poiItem.getCityName(),
                                    poiItem.getDistance(),
                                    poiItem.getEnter(),
                                    poiItem.getExit(),
                                    poiItem.getLatLonPoint(),
                                    poiItem.getProvinceCode(),
                                    poiItem.getProvinceName(),
                                    poiItem.getSnippet(),
                                    poiItem.getTel(),
                                    poiItem.getTitle()
                            ));
                            searchPoiListener.searchSuccess(searchDatas);
                        }
                    }
                }
            }
        }else {
            searchPoiListener.searchFail("搜索失败");
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public void onGetInputtips(List<Tip> tips, int i) {
        if (i == 1000) {//搜索成功
            List<InputSearchData> inputSearchDatas = new ArrayList<>();
            for (int j = 0; j < tips.size(); j++) {
                Tip tip = tips.get(j);
                if (!tip.getPoiID().equals("") && tip.getPoint() != null){
                    //可直接显示在地图上
                    inputSearchDatas.add(new InputSearchData(
                            tip.getAdcode(),
                            tip.getAddress(),
                            tip.getName(),
                            tip.getPoint().getLatitude(),
                            tip.getPoint().getLongitude(),
                            tip.getDistrict()
                    ));
                    inputSearchLisetener.inputSearchSuccess(inputSearchDatas);
                }
            }
        } else {
            //搜索失败
            inputSearchLisetener.inputSearchFail("搜索失败");
        }
    }

    private void setOnSearchLisetener(SearchPoiListener searchPoiListener) {
        this.searchPoiListener = searchPoiListener;
    }

    private void setOnInputSearchLisetener(InputSearchListener inputSearchLisetener) {
        this.inputSearchLisetener = inputSearchLisetener;
    }
}
