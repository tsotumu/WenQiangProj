package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.ui.control.adapter.ForcastAdapter;
import com.macojia.leanproduct.ui.control.contact.ForcastContact;
import com.macojia.leanproduct.ui.control.model.ForcastModel;
import com.macojia.leanproduct.ui.control.presenter.ForcastPresenter;

import butterknife.Bind;


/**
 * des:产量进度预测
 * Created by macojia
 * on 2018.04.21 08:50
 */
public class ForecastProgressActivity extends BaseActivity<ForcastPresenter, ForcastModel> implements ForcastContact.View {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.irc_forcast)
    IRecyclerView irc;
    private CommonRecycleViewAdapter<ForcastData.DataListBean> ListAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_forecast_progress;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getDataRequest();
        intView();
    }

    private void intView() {
        ListAdapter = ForcastAdapter.getAdapter(getApplicationContext());
        irc.setAdapter(ListAdapter);
    }

    private void initToolBar() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    public void onIndexDataReturn(ForcastData costIndexData) {
        ListAdapter.removeAll(costIndexData.getDataList());
    }

    @Override
    public void scrolltoTop() {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
