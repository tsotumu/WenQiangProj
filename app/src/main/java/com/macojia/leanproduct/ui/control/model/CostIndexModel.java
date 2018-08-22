package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import base.utils.DebugUtil;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by LC on 2018/7/9.
 * 获取数据：
 * 数据格式 {"1号装机":[1,2,3,4,5,6,7,8,9,10,11,12], "2号装机":[1,2,3,4,5,6,7,8,9,10,11,12], "3号装机":[1,2,3,4,5,6,7,8,9,10,11,12]}
 */
public class CostIndexModel implements CostListContact.Model {
    @Override
    public Observable<CostIndexData> getData() {
        /**
         * Observer.create就是创建一个数据发射源。
         */
        Observable.OnSubscribe observable = new Observable.OnSubscribe<CostIndexData>() {
            @Override
            public void call(Subscriber<? super CostIndexData> subscriber) {

                CostIndexData costIndexList = new CostIndexData();
                if (DebugUtil.DEBUG) {
                    costIndexList = base.utils.JsonUtils.analysisNewsJsonFile(CostIndexData.class, "cost_index_json");
                }
                subscriber.onNext(costIndexList);
                subscriber.onCompleted();
            }
        };
        return Observable.create(observable).compose(RxSchedulers.<CostIndexData>io_main());
    }

}
