package com.macojia.leanproduct.ui.control.contact;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.control.YieldIndexData;

import rx.Observable;

/**
 * Created by Administrator on 2018/7/24.
 */

public interface YieldListContact {
    interface Model extends BaseModel {
        //请求获取消耗指标
        Observable<YieldIndexData> getData();
    }

    interface View extends BaseView {
        //返回获取的消耗指标
        void onListDataReturn(YieldIndexData indexData);

        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取消耗指标请求
        public abstract void getListDataRequest();
    }
}
