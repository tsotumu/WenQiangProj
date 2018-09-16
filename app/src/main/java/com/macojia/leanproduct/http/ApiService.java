package com.macojia.leanproduct.http;

import com.macojia.common.basebean.BaseRespose;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.bean.control.YieldIndexData;
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

    @GET("login")
    Observable<BaseRespose<User>> login(@Query("username") String username, @Query("password") String password);

    @GET("lpcms/getNewDetail")
    Observable<NewsDetailEntity> getNewDetail(@Query("id") int id);

    @GET("lpcms/getNewsList")
    Observable<NewsListData> getNewsList(
            @Query("startPage") String startPage,
            @Query("type") String type);


    @GET("lpcms/getMarkIndexData")
    Observable<QualityIndexData> getControlList(@Query("markindex") String markindex);

    @GET("lpcms/getMarkIndexData")
    Observable<YieldIndexData> getYieldData(@Query("markindex") String markindex);

    @GET("lpcms/getMarkIndexData")
    Observable<EfficiencyIndexData> getEfficiencyData(@Query("markindex") String markindex);

    @GET("lpcms/getVideoList")
    Observable<VideoListData> getVideoList(
            @Query("startPage") String startPage,
            @Query("type") String type);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Header("Cache-Control") String cacheControl,
            @Url String photoPath);
    //@Url，它允许我们直接传入一个请求的URL。这样以来我们可以将上一个请求的获得的url直接传入进来，baseUrl将被无视
    // baseUrl 需要符合标准，为空、""、或不合法将会报错

    @GET("nc/video/list/{type}/n/{startPage}-10.html")
    Observable<Map<String, List<VideoListEntity.VideoEntity>>> getVideoList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type,
            @Path("startPage") int startPage);

    @GET("rank")
    Call<String> getRank(
            @Query("key") String key, @Query("area") String area);

}
