package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.ui.control.contact.EfficiencyIndexContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/8/7.
 */

public class EfficiencyPresenter extends EfficiencyIndexContract.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<EfficiencyIndexData>(mContext, false) {
            @Override
            protected void _onNext(EfficiencyIndexData newsChannelTables) {
                mView.onDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
        mModel.getData();
        
    }
}
