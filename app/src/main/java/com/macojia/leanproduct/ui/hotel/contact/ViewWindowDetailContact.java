package com.macojia.leanproduct.ui.hotel.contact;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.hotel.VWDetailEntity;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;

import rx.Observable;

/**
 * Created by Administrator on 2018/10/6.
 */

public class ViewWindowDetailContact {
    public interface Model extends BaseModel {
        //请求获取新闻
        Observable<VWDetailEntity> getData(int postId);
    }

    public interface View extends BaseView {
        //返回获取的新闻
        void OnReturned(VWDetailEntity vmDetail);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取单条新闻请求
        public abstract void getDataRequest(int postId);
    }
}
