package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexPresenter extends QualityIndexContract.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<QualityIndexData>(mContext, false) {
            @Override
            protected void _onNext(QualityIndexData newsChannelTables) {
                mView.onIndexDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
        mModel.getData();
    }
}
