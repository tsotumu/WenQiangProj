package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.common.commonutils.ToastUitl;
import com.macojia.leanproduct.R;
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
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onError(String message) {
                ToastUitl.showToastWithImg(message, R.drawable.ic_wrong);
            }
        }));
        mModel.getData();
        
    }
}
