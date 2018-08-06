package com.macojia.leanproduct.ui.control.activity;

import android.content.Context;
import android.graphics.Color;
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
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;
import com.macojia.leanproduct.ui.control.adapter.QualityIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;
import com.macojia.leanproduct.ui.control.model.QualityIndexModel;
import com.macojia.leanproduct.ui.control.presenter.QualityIndexPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * des:质量指标详情
 * Created by xsf
 * on 2016.09.11:51
 */
public class QualityIndexActivity extends BaseActivity<QualityIndexPresenter, QualityIndexModel> implements QualityIndexContract.View{
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_quality)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_qualityindex;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getListDataRequest();
    }

    public int getTitleId() {
        return R.string.qualityindex;
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
    public void onIndexListDataReturn(List<QualityIndexData> costIndexData) {

        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        list.add(new HorizonBarChartItem(generateDataBar(1), getApplicationContext(), "产量年度指标", "指标", "包装机号"));
        // 30 items
        for (int i = 0; i < 19; i++) {
            list.add(new LineChartItem(generateDataLine(i + 1), getApplicationContext()));
        }
        mListView.setAdapter(QualityIndexAdapter.getAdapter());

    }

    @Override
    public void scrolltoTop() {

    }


    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e1.add(new Entry(i, (int) (Math.random() * 65) + 40));
        }

        LineDataSet d1 = new LineDataSet(e1, cnt + "号包装机");
        d1.setLineWidth(2.5f);
        d1.setCircleRadius(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);

        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 6; i++) {
            e2.add(new Entry(i, e1.get(i).getY() - 30));
        }

     /*   LineDataSet d2 = new LineDataSet(e2, "New DataSet " + cnt + ", (2)");
        d2.setLineWidth(2.5f);
        d2.setCircleRadius(4.5f);
        d2.setHighLightColor(Color.rgb(244, 117, 117));
        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setDrawValues(false);*/

        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(d1);
//        sets.add(d2);

        LineData cd = new LineData(sets);
        return cd;
    }

    private BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 19; i++) {
            entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "质量指标");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

}
