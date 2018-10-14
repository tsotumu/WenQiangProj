package com.macojia.leanproduct.ui.control.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.chart.LabelFormatter;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.control.adapter.CostIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.CostListContact;
import com.macojia.leanproduct.ui.control.model.CostIndexModel;
import com.macojia.leanproduct.ui.control.presenter.CostIndexPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class CostIndexActivity extends BaseActivity<CostIndexPresenter, CostIndexModel> implements CostListContact.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_cost)
    ListView mListView;
    @Bind(R.id.chart)
    com.github.mikephil.charting.charts.HorizontalBarChart horizontalBarChart;
    @Bind(R.id.tv_bar_title)
    TextView barTitle;
    @Bind(R.id.tv_label_y)
    TextView labelY;
    @Bind(R.id.tv_label_x)
    TextView labelX;

    @Override
    public int getLayoutId() {
        return R.layout.activity_costindex;
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

    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
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
        return R.string.control_cost_index;
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
    public void onDataReturn(CostIndexData costIndexData) {
        LogUtils.logd("Cost index test：" + costIndexData.toString());
        // 水平直方图
        setBarchart(costIndexData);
        // 垂直直方图列表
        CostIndexAdapter cda = CostIndexAdapter.getAdapter(costIndexData);
        mListView.setAdapter(cda);

    }

    private void setBarchart(CostIndexData costIndexData) {
        horizontalBarChart.getLegend().setFormSize(0);

        // apply styling
        horizontalBarChart.getLegend().setFormSize(0);
        horizontalBarChart.getDescription().setEnabled(false);
        horizontalBarChart.setDrawGridBackground(false);
        horizontalBarChart.setDrawBarShadow(false);

        XAxis xAxis = horizontalBarChart.getXAxis();
        String[] mLeftAxisLabels = getHorizonBarChartLabels(costIndexData.getMachineIndex());
        if (mLeftAxisLabels != null) {
            xAxis.setValueFormatter(new LabelFormatter(mLeftAxisLabels));
            xAxis.setLabelRotationAngle(25);
            xAxis.setLabelCount(mLeftAxisLabels.length);
        }
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(Typeface.createFromAsset(AppApplication.getInstance().getAssets(), "OpenSans-Regular.ttf"));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = horizontalBarChart.getAxisLeft();
        leftAxis.setTypeface(Typeface.createFromAsset(AppApplication.getInstance().getAssets(), "OpenSans-Regular.ttf"));
        leftAxis.setLabelCount(5, false);
        leftAxis.setSpaceTop(20f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = horizontalBarChart.getAxisRight();
        rightAxis.setTypeface(Typeface.createFromAsset(AppApplication.getInstance().getAssets(), "OpenSans-Regular.ttf"));
        rightAxis.setLabelCount(5, false);
        rightAxis.setSpaceTop(20f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        
        horizontalBarChart.setData(generateDataBar(costIndexData.getMachineIndex()));
        horizontalBarChart.refreshDrawableState();
        
        labelX.setText("消耗得分");
        labelY.setText("机组号");
        barTitle.setText(costIndexData.getMachineTitle());
        findViewById(R.id.cost_barchart).setVisibility(View.VISIBLE);
    }

    @Override
    public void scrolltoTop() {

    }

    private static BarData generateDataBar(List<CostIndexData.MachineIndexBean> machineIndexBeanList) {

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < machineIndexBeanList.size(); i++) {
            entries.add(new BarEntry(i, Double.valueOf(machineIndexBeanList.get(i).getValue()).floatValue()));
        }

        BarDataSet d = new BarDataSet(entries, "");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private static String[] getHorizonBarChartLabels(List<CostIndexData.MachineIndexBean> machineIndexBeanList) {
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[machineIndexBeanList.size()];
        for (CostIndexData.MachineIndexBean machineIndexBean : machineIndexBeanList) {
            labels.add(machineIndexBean.getKey());
        }
        return labels.toArray(result);
    }


}
