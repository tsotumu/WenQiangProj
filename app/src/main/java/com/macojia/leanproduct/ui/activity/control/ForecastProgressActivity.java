package com.macojia.leanproduct.ui.activity.control;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.daimajia.numberprogressbar.NumberProgressBar;
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
 * des:产量进度预测
 * Created by macojia
 * on 2018.04.21 08:50
 */
public class ForecastProgressActivity extends BaseActivity{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tsbx)
    NumberProgressBar tsbx;//泰山八喜
    @Bind(R.id.tsyh)
    NumberProgressBar tsyh;//泰山硬红
    @Bind(R.id.tshdm)
    NumberProgressBar tshdm;//泰山哈德门
    @Bind(R.id.tswy)
    NumberProgressBar tswy;//泰山望岳
    @Bind(R.id.bsy)
    NumberProgressBar bsy;//白沙硬
    @Bind(R.id.bsjp)
    NumberProgressBar bsjp;//白沙精品
    @Bind(R.id.njh)
    NumberProgressBar njh;//南京红
    @Bind(R.id.tshdmyh)
    NumberProgressBar tshdmyh;//泰山哈德门一号
    @Bind(R.id.tshp)
    NumberProgressBar tshp;//泰山琥珀
    @Bind(R.id.tsqy)
    NumberProgressBar tsqy;//泰山齐烟
    @Bind(R.id.tsdf)
    NumberProgressBar tsdf;//泰山东方


    @Override
    public int getLayoutId() {
        return R.layout.activity_forecast_progress;
    }

    @Override
    public void initPresenter() {

    }


    /**
     * 入口
     * @param context
     */
    public static void startAction(Context context){
        Intent intent = new Intent(context, ForecastProgressActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tsbx.setPrefix("泰山（八喜）");
        tsyh.setPrefix("泰山（硬红）");
        tsdf.setPrefix("泰山（东方）");
        tshdm.setPrefix("泰山（哈德门）精品");
        tshdmyh.setPrefix("泰山（哈德门）短支一号");
        tshp.setPrefix("泰山（琥珀）");
        tsqy.setPrefix("泰山（齐烟）");
        tswy.setPrefix("泰山（望岳）");
        bsy.setPrefix("白沙（硬）");
        bsjp.setPrefix("白沙（精品）");
        njh.setPrefix("南京（红）");
        ArrayList<BarData> list = new ArrayList<BarData>();

        // 20 items
        for (int i = 0; i < 20; i++) {
            list.add(generateData(i + 1));
        }


    }

    @Override
    public void initView() {
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


    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private BarData generateData(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 12; i++) {
            entries.add(new BarEntry(i, (float) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "New DataSet " + cnt);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

}
