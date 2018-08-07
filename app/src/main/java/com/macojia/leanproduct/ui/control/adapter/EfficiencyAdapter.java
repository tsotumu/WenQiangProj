package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.EfficiencyIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;

import java.util.ArrayList;
import java.util.List;

import base.utils.ResourceUtil;

/**
 * Created by Administrator on 2018/8/7.
 */

public class EfficiencyAdapter extends ArrayAdapter<ChartItem> {

    public EfficiencyAdapter(Context context, List<ChartItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(position, convertView, getContext());
    }

    @Override
    public int getItemViewType(int position) {
        // return the views type
        return getItem(position).getItemType();
    }

    @Override
    public int getViewTypeCount() {
        return 2; // we have 3 different item-types
    }

    public static EfficiencyAdapter getAdapter(Context context, EfficiencyIndexData indexData) {
        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        list.add(new HorizonBarChartItem(generateDataBar(1), context, "产量年度指标", "指标", "包装机号"));
        // 30 items
        for (int i = 0; i < 19; i++) {
            list.add(new LineChartItem(generateDataLine(i + 1), context, i + "号包装机", ResourceUtil.getString(R.string.x_label_month), ResourceUtil.getString(R.string.y_label_index)));
        }
        return new EfficiencyAdapter(context, list);
    }

    private static LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e1.add(new Entry(i, (int) (Math.random() * 65) + 40));
        }

        LineDataSet d1 = new LineDataSet(e1,"");
        d1.setDrawValues(true);

        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 6; i++) {
            e2.add(new Entry(i, e1.get(i).getY() - 30));
        }

        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(d1);

        LineData cd = new LineData(sets);
        return cd;
    }

    private static BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 19; i++) {
            entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }
}