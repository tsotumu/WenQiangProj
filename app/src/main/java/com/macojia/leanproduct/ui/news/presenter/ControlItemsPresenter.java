package com.macojia.leanproduct.ui.news.presenter;

import com.macojia.leanproduct.app.AppConstant;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.bean.NewsChannelTable;
import com.macojia.leanproduct.ui.news.contract.ControlItemContract;
import com.macojia.leanproduct.ui.news.contract.NewsChannelContract;
import com.macojia.common.baserx.RxSubscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * des:管控应用列表
 * Created by macojia
 * on 2018.03.26 14:30
 */
public class ControlItemsPresenter extends ControlItemContract.Presenter{

    @Override
    public void lodeItemsRequest() {
        mRxManage.add(mModel.lodeMineControlItems().subscribe(new RxSubscriber<List<ItemApp>>(mContext,false) {
            @Override
            protected void _onNext(List<ItemApp> itemApps) {
                mView.returnMineControlItems(itemApps);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
