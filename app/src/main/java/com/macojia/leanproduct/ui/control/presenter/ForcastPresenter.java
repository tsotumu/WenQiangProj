package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.ui.control.contact.ForcastContact;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ForcastPresenter extends ForcastContact.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<ForcastData>(mContext, false) {
            @Override
            protected void _onNext(ForcastData newsChannelTables) {
                mView.onIndexDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));

    }
}
