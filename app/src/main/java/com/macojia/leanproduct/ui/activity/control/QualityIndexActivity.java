package com.macojia.leanproduct.ui.activity.control;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.leanproduct.R;

import java.util.ArrayList;
import java.util.List;


/**
 * des:质量指标详情
 * Created by xsf
 * on 2016.09.11:51
 */
public class QualityIndexActivity extends BaseControlActivity {

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        super.initView();
        setPageTitle(R.string.control_quality_index);
    }
}
