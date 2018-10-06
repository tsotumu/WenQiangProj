package com.macojia.leanproduct.ui.hotel.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.common.commonutils.ToastUitl;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.hotel.VWDetailEntity;
import com.macojia.leanproduct.ui.control.contact.ViewWindowContact;
import com.macojia.leanproduct.ui.hotel.contact.ViewWindowDetailContact;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LC on 2018/10/6.
 */

public class VWDetailPresenter extends ViewWindowDetailContact.Presenter {

    @Override
    public void getDataRequest(int postId) {

        mRxManage.add(mModel.getData(postId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<VWDetailEntity>(mContext) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onNext(VWDetailEntity newsDetail) {
                mView.OnReturned(newsDetail);
            }

            @Override
            protected void _onError(String message) {
                ToastUitl.showToastWithImg(message, R.drawable.ic_wrong);
            }
        }));
    }
}
