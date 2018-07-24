package com.macojia.leanproduct.ui.control.contact;

import android.database.Observable;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.control.YieldIndexData;

import java.util.List;

/**
 * Created by Administrator on 2018/7/24.
 */

public interface YieldListContact {
    interface Model extends BaseModel {
        //请求获取消耗指标
        Observable<List<YieldIndexData>> geListData();
    }

    interface View extends BaseView {
        //返回获取的消耗指标
        void onListDataReturn(List<YieldIndexData> indexData);

        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取消耗指标请求
        public abstract void getListDataRequest();
    }
}
