package com.macojia.leanproduct.ui.news.contract;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.bean.news.NewsSummary;

import java.util.List;

import rx.Observable;

/**
 * des:新闻列表contract
 * Created by xsf
 * on 2016.09.14:38
 */
public interface NewsListContract {
    interface Model extends BaseModel {
        //请求获取新闻
        Observable<NewsListData> getNewsListData(String type, final String id, int startPage);
    }

    interface View extends BaseView {
        //返回获取的新闻
        void OnNewsListDataReturned(NewsListData newsSummaries);

        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取新闻请求
        public abstract void getNewsListDataRequest(String type, final String id, int startPage);
    }
}
