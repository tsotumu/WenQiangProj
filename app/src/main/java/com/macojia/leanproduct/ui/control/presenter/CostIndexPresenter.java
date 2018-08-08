package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexPresenter extends CostListContact.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribe(new RxSubscriber<CostIndexData>(mContext, false) {
            @Override
            protected void _onNext(CostIndexData newsChannelTables) {
                mView.onDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
