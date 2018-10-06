package com.macojia.leanproduct.ui.control.contact;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;

import rx.Observable;

public class ViewWindowContact {
    public interface Model extends BaseModel {
        Observable<ViewWindowEntity> getData();
    }

    public interface View extends BaseView {
        void onIndexDataReturn(ViewWindowEntity data);

        //返回顶部
        void scrolltoTop();
    }

    public abstract static class Presenter extends BasePresenter<ViewWindowContact.View, ViewWindowContact.Model> {
        public abstract void getDataRequest();
    }
}
