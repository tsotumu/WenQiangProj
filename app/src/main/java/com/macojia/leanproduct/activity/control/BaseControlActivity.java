package com.macojia.leanproduct.activity.control;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public abstract class BaseControlActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
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

    public abstract int getTitleId();
}
