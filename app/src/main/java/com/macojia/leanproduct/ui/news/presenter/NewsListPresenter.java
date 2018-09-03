package com.macojia.leanproduct.ui.news.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.news.contract.NewsListContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * des:
 * Created by xsf
 * on 2016.09.14:53
 */
public class NewsListPresenter extends NewsListContract.Presenter {

    @Override
    public void onStart() {
        super.onStart();
        //监听返回顶部动作
        mRxManage.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scrolltoTop();
            }
        });
    }

    /**
     * 请求获取列表数据
     * */
    public void getNewsListDataRequest(String type, int startPage) {
        mRxManage.add(mModel.getNewsListData(type, startPage).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<NewsListData>(mContext, false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onNext(NewsListData newsSummaries) {
                mView.OnNewsListDataReturned(newsSummaries);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
