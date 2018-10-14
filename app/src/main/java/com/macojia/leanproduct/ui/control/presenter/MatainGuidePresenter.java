package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.common.commonutils.ToastUitl;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.MatainGuideData;
import com.macojia.leanproduct.ui.control.contact.MatainGuideConstract;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/8/8.
 */

public class MatainGuidePresenter extends MatainGuideConstract.Presenter {
    @Override
    public void getListDataRequest() {
        mRxManage.add(mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<MatainGuideData>(mContext, false) {
            @Override
            protected void _onNext(MatainGuideData newsChannelTables) {
                mView.onListDataReturn(newsChannelTables);
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