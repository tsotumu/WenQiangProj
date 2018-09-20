package com.macojia.leanproduct.http;

import com.macojia.common.basebean.BaseRespose;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.bean.control.MatainGuideData;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.bean.hotel.VWDetailEntity;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;
import com.macojia.leanproduct.bean.login.User;
import com.macojia.leanproduct.bean.news.NewsDetailEntity;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.bean.video.VideoListData;
import com.macojia.leanproduct.bean.video.VideoListEntity;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {

    @GET("lpcms/appLogin")
    Call<String> login(@Query("username") String username, @Query("password") String password);

    @GET("lpcms/getNewDetail")
    Observable<NewsDetailEntity> getNewDetail(@Query("id") int id);

    @GET("lpcms/getNewsList")
    Observable<NewsListData> getNewsList(
            @Query("startPage") String startPage,
            @Query("type") String type);


    @GET("lpcms/getProductionInfo")
    Observable<ForcastData> getForcastData();

    @GET("lpcms/getMarkIndexData")
    Observable<CostIndexData> getCostData(@Query("markindex") String markindex);

    @GET("lpcms/getEquipFaultData")
    Observable<MatainGuideData> getMaintain();

    @GET("lpcms/getWindowList")
    Observable<ViewWindowEntity> getWindowList();

    @GET("lpcms/getWindowData")
    Call<VWDetailEntity> getWindowData();

    @GET("lpcms/getMarkIndexData")
    Observable<QualityIndexData> getControlList(@Query("markindex") String markindex);

    @GET("lpcms/getMarkIndexData")
    Observable<YieldIndexData> getYieldData(@Query("markindex") String markindex);

    @GET("lpcms/getMarkIndexData")
    Observable<EfficiencyIndexData> getEfficiencyData(@Query("markindex") String markindex);

    @GET("lpcms/getVideoList")
    Observable<VideoListEntity> getVideoList(
            @Query("startPage") int startPage,
            @Query("type") String type);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Header("Cache-Control") String cacheControl,
            @Url String photoPath);

    @GET("rank")
    Call<String> getRank(
            @Query("key") String key, @Query("area") String area);

}
