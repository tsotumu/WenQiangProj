package com.macojia.leanproduct.ui.control.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonwidget.LoadingTip;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.ui.MainActivity;
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
public class ForecastProgressActivity extends BaseActivity<ForcastPresenter, ForcastModel> implements ForcastContact.View, OnRefreshListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.irc_forcast)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    @Bind(R.id.forcast_title)
    TextView forcast_title;
    private CommonRecycleViewAdapter<ForcastData.DataListBean> ListAdapter;


    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }

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
        intView();
        mPresenter.getDataRequest();
    }

    private void intView() {
        ListAdapter = ForcastAdapter.getAdapter(getApplicationContext());
        irc.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        irc.setItemAnimator(new DefaultItemAnimator());
        irc.setAdapter(ListAdapter);
        irc.setOnRefreshListener(this);
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
        if (costIndexData != null) {
            if (ListAdapter.getPageBean().isRefresh()) {
                irc.setRefreshing(false);
                ListAdapter.replaceAll(costIndexData.getDataList());
                forcast_title.setText(costIndexData.getProgressTitle());
            } else {
                if (costIndexData.getDataList().size() > 0) {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                    ListAdapter.addAll(costIndexData.getDataList());
                    forcast_title.setText(costIndexData.getProgressTitle());
                } else {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                }
            }
        }
    }

    @Override
    public void scrolltoTop() {
        irc.smoothScrollToPosition(0);

    }

    @Override
    public void showLoading(String title) {
        if (ListAdapter.getPageBean().isRefresh()) {
            if (ListAdapter.getSize() <= 0) {
                loadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            }
        }

    }

    @Override
    public void stopLoading() {
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);

    }

    @Override
    public void showErrorTip(String msg) {
        if (ListAdapter.getPageBean().isRefresh()) {
            if (ListAdapter.getSize() <= 0) {
                loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
                loadedTip.setTips(msg);
            }
            irc.setRefreshing(false);
        } else {
            irc.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
        }

    }

    @Override
    public void onRefresh() {

        ListAdapter.getPageBean().setRefresh(true);
        //发起请求
        irc.setRefreshing(true);
        mPresenter.getDataRequest();
    }
}
