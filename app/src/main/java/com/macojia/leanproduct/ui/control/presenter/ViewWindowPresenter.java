package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;
import com.macojia.leanproduct.bean.news.NewsChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.control.contact.ViewWindowContact;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ViewWindowPresenter extends ViewWindowContact.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<ViewWindowEntity>(mContext, false) {
            @Override
            protected void _onNext(ViewWindowEntity newsChannelTables) {
                mView.onIndexDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
