package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.ACache;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.bean.news.NewsChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.db.NewsChannelTableManager;
import com.macojia.leanproduct.ui.news.contract.NewsMainContractBase;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * des:
 * Created by xsf
 * on 2016.09.17:05
 */
public class NewsMainModel implements NewsMainContractBase.Model {
    @Override
    public Observable<List<NewsChannelTable>> loadNewsChannels() {
        LogUtils.logd("loadNewsChannels" );
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                LogUtils.logd("loadNewsChannels begin");
                ArrayList<NewsChannelTable> newsChannelTableList = new ArrayList<>();
                try {
                    newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
                }catch (Exception e){
                    LogUtils.loge("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", e);
                    e.printStackTrace();
                }
                LogUtils.logd("from cache->");
                if (newsChannelTableList == null) {
                    LogUtils.logd("load news channels.");
                    newsChannelTableList = (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsChannelsStatic();
                    LogUtils.logd("loadNewsChannelsStatic->" + newsChannelTableList.toString());
                    ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MINE, newsChannelTableList);
                }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }
}
