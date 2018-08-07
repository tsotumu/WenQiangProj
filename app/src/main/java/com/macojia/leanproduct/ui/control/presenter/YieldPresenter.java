package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;

/**
 * Created by LC on 2018/7/24.
 */

public class YieldPresenter extends YieldListContact.Presenter {
    @Override
    public void getListDataRequest() {
        mRxManage.add(mModel.getData().subscribe(new RxSubscriber<YieldIndexData>(mContext, false) {
            @Override
            protected void _onNext(YieldIndexData newsChannelTables) {
                mView.onListDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
        mModel.getData();
    }
}
