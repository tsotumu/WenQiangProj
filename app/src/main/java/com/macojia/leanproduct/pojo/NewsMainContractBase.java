package com.macojia.leanproduct.pojo;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.news.NewsChannelTable;

import java.util.List;

import rx.Observable;

/**
 * des:
 * Created by xsf
 * on 2016.09.11:53
 */
public interface NewsMainContractBase {

    interface Model extends BaseModel {
        Observable<List<NewsChannelTable>> loadNewsChannels();
    }

    interface View extends BaseView {
        void OnNewsChannelsReturned(List<NewsChannelTable> newsChannelsMine);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodeChannelsRequest();
    }
}
