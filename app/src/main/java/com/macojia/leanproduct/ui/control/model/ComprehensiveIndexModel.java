package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.ComprehensiveIndexData;
import com.macojia.leanproduct.ui.control.contact.ComprehensiveIndexContract;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/7/17.
 */

public class ComprehensiveIndexModel implements ComprehensiveIndexContract.Model{
    @Override
    public Observable<ComprehensiveIndexData> getData() {
        return Observable.create(new Observable.OnSubscribe<com.macojia.leanproduct.bean.control.ComprehensiveIndexData>() {
            @Override
            public void call(Subscriber<? super ComprehensiveIndexData> subscriber) {

                ComprehensiveIndexData costIndexList = new ComprehensiveIndexData();
                if (BuildConfig.DEBUG) {
                    costIndexList = base.utils.JsonUtils.analysisNewsJsonFile(ComprehensiveIndexData.class, "comprehensive_index");
                }
                subscriber.onNext(costIndexList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<com.macojia.leanproduct.bean.control.ComprehensiveIndexData>io_main());
    }
}
