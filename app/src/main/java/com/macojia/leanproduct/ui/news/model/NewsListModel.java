package com.macojia.leanproduct.ui.news.model;

import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.http.HttpUtil;
import com.macojia.leanproduct.http.NetworkConstants;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.news.contract.NewsListContract;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;

/**
 * des:获取新闻列表
 * Created by xsf
 * on 2016.09.14:54
 */
public class NewsListModel implements NewsListContract.Model {
    @Override
    public Observable<NewsListData> getNewsListData(final String type, final int startPage) {
     /*       Map<String, Object> params = new HashMap<>();
            params.put("startPage", 0);
            HttpUtil.makeLionHttpRequest(NetworkManager.getOkHttpClient(), NetworkConstants.NEWS_LIST_TEST, params, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtils.logd(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                }
            });
            retrofit2.Call call =  NetworkManager.getDefault(0).getNewsList("1", "党建");
            call.enqueue(new retrofit2.Callback() {
                @Override
                public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                    retrofit2.Response response1 = response;
                    LogUtils.logd(response1.body().toString());
                }

                @Override
                public void onFailure(retrofit2.Call call, Throwable t) {
                    LogUtils.logd(t.getMessage());

                }
            });*/
            return NetworkManager.getDefault(0).getNewsList("1", type);


      /*  Observable<NewsSummary> newsSummaryObservable = listObserver.flatMap(new Func1<Map<String, List<NewsSummary>>, Observable<NewsSummary>>() {
            @Override
            public Observable<NewsSummary> call(Map<String, List<NewsSummary>> map) {
                return Observable.from(map.get(id));
            }
        });
        return newsSummaryObservable.map(new Func1<NewsSummary, NewsSummary>() {
            @Override
            public NewsSummary call(NewsSummary newsSummary) {
                String ptime = TimeUtil.formatDate(newsSummary.getNews_datetime());
                newsSummary.setNews_datetime(ptime);
                return newsSummary;
            }
        }).distinct()//去重
                .toSortedList(new Func2<NewsSummary, NewsSummary, Integer>() {
                    @Override
                    public Integer call(NewsSummary newsSummary, NewsSummary newsSummary2) {
                        return newsSummary2.getNews_datetime().compareTo(newsSummary.getNews_datetime());
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<NewsSummary>>io_main());*/
    }
}
