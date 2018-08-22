package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;

import java.util.List;

import base.utils.DebugUtil;
import base.utils.JsonUtils;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexModel implements QualityIndexContract.Model {
    @Override
    public Observable<QualityIndexData> getData() {
        return Observable.create(new Observable.OnSubscribe<QualityIndexData>() {
            @Override
            public void call(Subscriber<? super QualityIndexData> subscriber) {

                QualityIndexData costIndexDataSource = new QualityIndexData();
                if (DebugUtil.DEBUG) {
                    costIndexDataSource = JsonUtils.analysisNewsJsonFile(QualityIndexData.class, "yield_index");
                    LogUtils.logd("cost index data source: " + costIndexDataSource.toString());
                }
                subscriber.onNext(costIndexDataSource);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<QualityIndexData>io_main());
    }
}
