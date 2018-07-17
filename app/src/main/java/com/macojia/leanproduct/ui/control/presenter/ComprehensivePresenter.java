package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.ComprehensiveIndexData;
import com.macojia.leanproduct.ui.control.contact.ComprehensiveIndexContract;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public class ComprehensivePresenter extends ComprehensiveIndexContract.Presenter {
    @Override
    public void getCostListDataRequest() {
        mRxManage.add(mModel.getListData().subscribe(new RxSubscriber<List<ComprehensiveIndexData>>(mContext, false) {
            @Override
            protected void _onNext(List<ComprehensiveIndexData> newsChannelTables) {
                mView.onIndexListDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));

    }
}
