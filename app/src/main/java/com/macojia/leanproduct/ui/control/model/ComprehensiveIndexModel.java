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
    public Observable<List<ComprehensiveIndexData>> getListData() {
        return Observable.create(new Observable.OnSubscribe<List<com.macojia.leanproduct.bean.control.ComprehensiveIndexData>>() {
            @Override
            public void call(Subscriber<? super List<ComprehensiveIndexData>> subscriber) {

                ArrayList<ComprehensiveIndexData> costIndexList = new ArrayList<>();
                if (BuildConfig.DEBUG) {
                    String str = "[{'machineName':'1号包装机','matainDataPerMachine':[{'value':100},{'value':78},{'value':98},{'value':28},{'value':8},{'value':-9},{'value':98},{'value':98},{'value':8},{'value':98},{'value':10},{'value':-110},{'value':110}]},{'machineName':'2号装机','matainDataPerMachine':[{'value':33} ,{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55}]}]";
                    List<ComprehensiveIndexData> costIndexDataSource = base.utils.JsonUtils.parseJsonArrayWithGson(str, ComprehensiveIndexData.class);
                    LogUtils.logd("cost index data source: " + costIndexDataSource.toString());
                    costIndexList.addAll(costIndexDataSource);
                }
                subscriber.onNext(costIndexList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<com.macojia.leanproduct.bean.control.ComprehensiveIndexData>>io_main());
    }
}
