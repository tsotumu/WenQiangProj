package com.macojia.leanproduct.ui.control.contact;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;

import rx.Observable;

public class ViewWindowContact {
    public interface Model extends BaseModel {
        //请求获取消耗指标
        Observable<ViewWindowEntity> getData();
    }

    public interface View extends BaseView {
        //返回获取的消耗指标
        void onIndexDataReturn(ViewWindowEntity data);

        //返回顶部
        void scrolltoTop();
    }

    public abstract static class Presenter extends BasePresenter<ViewWindowContact.View, ViewWindowContact.Model> {
        //发起获取消耗指标请求
        public abstract void getDataRequest();
    }
}
