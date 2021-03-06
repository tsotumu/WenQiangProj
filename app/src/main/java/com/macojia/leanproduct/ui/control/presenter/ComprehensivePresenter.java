package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.common.commonutils.ToastUitl;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.ComprehensiveIndexData;
import com.macojia.leanproduct.ui.control.contact.ComprehensiveIndexContract;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public class ComprehensivePresenter extends ComprehensiveIndexContract.Presenter {
    @Override
    public void getDataRequest() {
        mRxManage.add(mModel.getData().subscribe(new RxSubscriber<ComprehensiveIndexData>(mContext, false) {
            @Override
            protected void _onNext(ComprehensiveIndexData newsChannelTables) {
                mView.onDataReturn(newsChannelTables);
            }
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onError(String message) {
                ToastUitl.showToastWithImg(message, R.drawable.ic_wrong);
            }
        }));

    }
}
