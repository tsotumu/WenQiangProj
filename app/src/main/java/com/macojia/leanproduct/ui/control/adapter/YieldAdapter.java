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
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;

import java.util.ArrayList;
import java.util.List;

import base.utils.ResourceUtil;

/**
 * Created by Administrator on 2018/7/24.
 */

public class YieldAdapter extends ArrayAdapter<ChartItem> {

    public YieldAdapter(Context context, List<ChartItem> objects) {
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

    private static BarData generateDataBar(List<Integer> data) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 19; i++) {
            entries.add(new BarEntry(i, (data.get(i))));
        }

        BarDataSet d = new BarDataSet(entries, "");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private static LineData generateDataLine(YieldIndexData.MonthlyIndex monthlyIndex) {

        ArrayList<Entry> monthlyDataSet = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            monthlyDataSet.add(new Entry(i, monthlyIndex.monthlyIndex.get(i)));
        }

        LineDataSet dataSet = new LineDataSet(monthlyDataSet, "");
        dataSet.setDrawValues(true);

        ArrayList<ILineDataSet> sets = new ArrayList<>();
        sets.add(dataSet);

        LineData cd = new LineData(sets);
        return cd;
    }

    public static YieldAdapter getAdapter(YieldIndexData indexData, Context context){
        ArrayList<ChartItem> list = new ArrayList<>();

        list.add(new HorizonBarChartItem(generateDataBar(indexData.machineIndex), context, "产量年度指标", "指标", "包装机号"));

        for (int i = 0; i < 19; i++) {
            list.add(new LineChartItem(generateDataLine(indexData.monthlyIndexPerMachine.get(i)), context, i + "号包装机", ResourceUtil.getString(R.string.x_label_month), ResourceUtil.getString(R.string.y_label_index)));
        }

        return new YieldAdapter(context, list);
    }
}
