package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexPresenter extends QualityIndexContract.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribe(new RxSubscriber<QualityIndexData>(mContext, false) {
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
