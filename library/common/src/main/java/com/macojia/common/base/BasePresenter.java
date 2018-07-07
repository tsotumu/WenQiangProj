package com.macojia.common.base;

import android.content.Context;

import com.macojia.common.baserx.RxManager;

/**
 * des:基类presenter
 * Created by xsf
 * on 2016.07.11:55
 */
public abstract class BasePresenter<ViewType, ModelType>{
    public Context mContext;
    public ModelType mModel;
    public ViewType mView;
    public RxManager mRxManage = new RxManager();

    public void setView_Model(ViewType v, ModelType m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){
    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
