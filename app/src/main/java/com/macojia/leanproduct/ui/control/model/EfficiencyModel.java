package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.bean.control.ControlType;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.control.contact.EfficiencyIndexContract;

import base.utils.DebugUtil;
import base.utils.JsonUtils;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/8/7.
 */

public class EfficiencyModel implements EfficiencyIndexContract.Model {
    @Override
    public Observable<EfficiencyIndexData> getData() {
        if (DebugUtil.DEBUG && false) {
            return Observable.create(new Observable.OnSubscribe<EfficiencyIndexData>() {
                @Override
                public void call(Subscriber<? super EfficiencyIndexData> subscriber) {

                    EfficiencyIndexData IndexDataSource = new EfficiencyIndexData();
                    if (DebugUtil.DEBUG) {
                        IndexDataSource = JsonUtils.analysisNewsJsonFile(EfficiencyIndexData.class, "yield_index");
                        LogUtils.logd("efficiency_index data source: " + IndexDataSource.toString());
                    }
                    subscriber.onNext(IndexDataSource);
                    subscriber.onCompleted();
                }
            }).compose(RxSchedulers.<EfficiencyIndexData>io_main());
        } else {
            return NetworkManager.getDefault(0).getEfficiencyData(ControlType.EFFICIENCY_INDEX);
        }
    }
}
