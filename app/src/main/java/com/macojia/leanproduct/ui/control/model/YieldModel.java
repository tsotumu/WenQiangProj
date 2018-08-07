package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;

import java.util.ArrayList;

import base.utils.JsonUtils;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/7/24.
 */

public class YieldModel implements YieldListContact.Model {
    @Override
    public Observable<YieldIndexData> getData() {
        return Observable.create(new Observable.OnSubscribe<YieldIndexData>() {
            @Override
            public void call(Subscriber<? super YieldIndexData> subscriber) {

                YieldIndexData costIndexDataSource = new YieldIndexData();
                if (BuildConfig.DEBUG) {
                    costIndexDataSource = JsonUtils.analysisNewsJsonFile(YieldIndexData.class, "yield_index");
                    LogUtils.logd("cost index data source: " + costIndexDataSource.toString());
                }
                subscriber.onNext(costIndexDataSource);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<YieldIndexData>io_main());
    }
}
