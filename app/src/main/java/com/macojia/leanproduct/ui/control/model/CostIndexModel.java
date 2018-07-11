package com.macojia.leanproduct.ui.control.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by LC on 2018/7/9.
 * 获取数据：
 *      数据格式 {"1号装机":[1,2,3,4,5,6,7,8,9,10,11,12], "2号装机":[1,2,3,4,5,6,7,8,9,10,11,12], "3号装机":[1,2,3,4,5,6,7,8,9,10,11,12]}
 */
public class CostIndexModel implements CostListContact.Model {
    @Override
    public Observable<List<com.macojia.leanproduct.bean.control.CostIndexData>> getNewsListData() {
        return Observable.create(new Observable.OnSubscribe<List<com.macojia.leanproduct.bean.control.CostIndexData>>() {
            @Override
            public void call(Subscriber<? super List<com.macojia.leanproduct.bean.control.CostIndexData>> subscriber) {

                ArrayList<CostIndexData> costIndexList = new ArrayList<>();
                if (BuildConfig.DEBUG) {
                    String str = "[{'machineName':'1号包装机','monthlyDataList':[{'value':100},{'value':78},{'value':98},{'value':28},{'value':8},{'value':-9},{'value':98},{'value':98},{'value':8},{'value':98},{'value':10},{'value':-110},{'value':110}]},{'machineName':'2号装机','monthlyDataList':[{'value':33} ,{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55},{'value':55}]}]";
                    List<CostIndexData> costIndexDataSource = base.utils.JsonUtils.parseJsonArrayWithGson(str, CostIndexData.class);
                    LogUtils.logd("cost index data source: " + costIndexDataSource.toString());
                    costIndexList.addAll(costIndexDataSource);
                }
                subscriber.onNext(costIndexList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<com.macojia.leanproduct.bean.control.CostIndexData>>io_main());
    }

}
