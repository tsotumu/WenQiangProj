package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.MatainGuideData;
import com.macojia.leanproduct.ui.control.contact.MatainGuideConstract;

import base.utils.DebugUtil;
import base.utils.JsonUtils;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/8/8.
 */

public class MatainGuideModel implements MatainGuideConstract.Model {
    @Override
    public Observable<MatainGuideData> getData() {
        return Observable.create(new Observable.OnSubscribe<MatainGuideData>() {
            @Override
            public void call(Subscriber<? super MatainGuideData> subscriber) {

                MatainGuideData costIndexDataSource = new MatainGuideData();
                if (DebugUtil.DEBUG) {
                    costIndexDataSource = JsonUtils.analysisNewsJsonFile(MatainGuideData.class, "maintain_guide");
                    LogUtils.logd("cost index data source: " + costIndexDataSource.toString());
                }
                subscriber.onNext(costIndexDataSource);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<MatainGuideData>io_main());
    }
}
