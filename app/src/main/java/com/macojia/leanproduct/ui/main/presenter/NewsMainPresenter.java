package com.macojia.leanproduct.ui.main.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.NewsChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.pojo.NewsMainContractBase;

import java.util.List;

import rx.functions.Action1;

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
                    mView.returnNewsChannels(newsChannelTables);
                }
            }
        });
    }

    @Override
    public void lodeChannelsRequest() {
        mRxManage.add(mModel.loadNewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(mContext, false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
