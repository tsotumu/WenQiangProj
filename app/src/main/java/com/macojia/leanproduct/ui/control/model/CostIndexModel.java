package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexModel implements CostListContact.Model {
    @Override
    public Observable<List<CostIndexData>> getNewsListData() {
        return Observable.create(new Observable.OnSubscribe<List<CostIndexData>>() {
            @Override
            public void call(Subscriber<? super List<CostIndexData>> subscriber) {
                ArrayList<CostIndexData> costIndexList = new ArrayList<>();
                if (BuildConfig.DEBUG) {
                    for (int i = 0; i < 19; i++) { // 19个机器
                        CostIndexData costIndexData = new CostIndexData();
                        costIndexData.mMachineData = new HashMap<Integer, Float>();
                        for (int j = 0; j < 12; j++) { // 12个月
                            costIndexData.mMachineData.put(j, (float) (Math.random() * 70) - 50);
                        }
                        costIndexList.add(costIndexData);
                    }
                }
                subscriber.onNext(costIndexList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<CostIndexData>>io_main());
    }
}
