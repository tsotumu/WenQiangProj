package com.macojia.leanproduct.ui.news.model;

import android.content.ClipData;

import com.macojia.leanproduct.R;
import com.macojia.leanproduct.api.ApiConstants;
import com.macojia.leanproduct.app.AppApplication;
import com.macojia.leanproduct.app.AppConstant;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.bean.NewsChannelTable;
import com.macojia.leanproduct.db.ControlItemTableManager;
import com.macojia.leanproduct.db.NewsChannelTableManager;
import com.macojia.leanproduct.ui.news.contract.ControlItemContract;
import com.macojia.leanproduct.ui.news.contract.NewsChannelContract;
import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.ACache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * des:管控应用列表
 * Created by xsf
 * on 2016.09.17:05
 */
public class ControlItemsModel implements ControlItemContract.Model {

    @Override
    public Observable<List<ItemApp>> lodeMineControlItems() {
        return Observable.create(new Observable.OnSubscribe<List<ItemApp>>() {
            @Override
            public void call(Subscriber<? super List<ItemApp>> subscriber) {
                ArrayList<ItemApp> controlItemsTableList = (ArrayList<ItemApp>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CONTROL_ITEMS);
                if(controlItemsTableList==null){
                    controlItemsTableList= (ArrayList<ItemApp>) ControlItemTableManager.loadControlItemTable();
                }
                subscriber.onNext(controlItemsTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<ItemApp>>io_main());
    }
}
