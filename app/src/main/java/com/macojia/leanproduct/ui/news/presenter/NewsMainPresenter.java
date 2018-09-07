package com.macojia.leanproduct.ui.news.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.bean.news.NewsChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.news.contract.NewsMainContractBase;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * des:
 * Created by xsf
 * on 2016.09.17:43
 */
public class NewsMainPresenter extends NewsMainContractBase.Presenter {

    @Override
    public void onStart() {
        super.onStart();
        //监听新闻频道变化刷新
        mRxManage.on(AppConstant.NEWS_CHANNEL_CHANGED, new Action1<List<NewsChannelTable>>() {

            @Override
            public void call(List<NewsChannelTable> newsChannelTables) {
                if (newsChannelTables != null) {
                    mView.OnNewsChannelsReturned(newsChannelTables);
                }
            }
        });
    }

    @Override
    public void lodeChannelsRequest() {
        LogUtils.logd("lodeChannelsRequest" );
        mRxManage.add(mModel.loadNewsChannels().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<List<NewsChannelTable>>(mContext, false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.OnNewsChannelsReturned(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
