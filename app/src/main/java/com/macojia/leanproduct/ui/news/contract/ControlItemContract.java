package com.macojia.leanproduct.ui.news.contract;

import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by macojia on 2018/3/26 0026.
 */

public interface ControlItemContract {
    interface Model extends BaseModel{
        Observable<List<ItemApp>> lodeMineControlItems();
    }
    interface View extends BaseView{
        void returnMineControlItems(List<ItemApp> controlItemsMine);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodeItemsRequest();
    }
}
