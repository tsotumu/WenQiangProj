package com.macojia.leanproduct.ui.control.activity;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;
import com.macojia.leanproduct.ui.control.adapter.EfficiencyAdapter;
import com.macojia.leanproduct.ui.control.contact.EfficiencyIndexContract;
import com.macojia.leanproduct.ui.control.model.EfficiencyModel;
import com.macojia.leanproduct.ui.control.presenter.EfficiencyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class EfficiencyIndexActivity extends  BaseActivity<EfficiencyPresenter, EfficiencyModel> implements EfficiencyIndexContract.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_efficient)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_efficiencyindex;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getDataRequest();
    }

    private void initToolBar() {
        mToolbar.setTitle(getTitleId());
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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

    public int getTitleId() {
        return R.string.efficiencyindex;
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

    @Override
    public void onDataReturn(EfficiencyIndexData indexData) {
        mListView.setAdapter(EfficiencyAdapter.getAdapter(getApplicationContext(), indexData));

    }

    @Override
    public void scrolltoTop() {

    }

}
