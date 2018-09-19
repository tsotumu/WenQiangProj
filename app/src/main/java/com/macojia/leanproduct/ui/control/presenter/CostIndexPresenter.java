package com.macojia.leanproduct.ui.control.presenter;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import java.util.List;
import java.util.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexPresenter extends CostListContact.Presenter {
    @Override
    public void getDataRequest() {
        /**
         * 把数据发射源和数据接受者联系起来。
         * Observable可观察对象；Subscriber订阅者；Observable.subscribe(Subscriber)
         * Observer同Subcriber，只是不能取消订阅。
         */
        rx.Observable<CostIndexData> observable = mModel.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        Subscriber subscriber = new RxSubscriber<CostIndexData>(mContext, false) {
            @Override
            protected void _onNext(CostIndexData newsChannelTables) {
                mView.onDataReturn(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        };
        /**
         * 在页面退出的时候，清空当前页面相关订阅。
         */
        mRxManage.add(observable.subscribe(subscriber));
    }
}
