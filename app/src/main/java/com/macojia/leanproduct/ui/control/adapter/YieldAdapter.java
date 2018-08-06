package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;

import java.util.ArrayList;
import java.util.List;

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

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e1.add(new Entry(i, monthlyIndex.monthlyIndex.get(i)));
        }

        LineDataSet dataSet = new LineDataSet(e1, "号包装机");
        dataSet.setLineWidth(2.5f);
        dataSet.setCircleRadius(4.5f);
        dataSet.setHighLightColor(Color.rgb(244, 117, 117));
        dataSet.setDrawValues(false);

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
        sets.add(dataSet);
//        sets.add(d2);

        LineData cd = new LineData(sets);
        return cd;
    }

    public static YieldAdapter getAdapter(YieldIndexData indexData, Context context){
        ArrayList<ChartItem> list = new ArrayList<>();

        list.add(new HorizonBarChartItem(generateDataBar(indexData.machineIndex), context, "产量年度指标", "指标", "包装机号"));

        for (int i = 0; i < 19; i++) {
            list.add(new LineChartItem(generateDataLine(indexData.monthlyIndexPerMachine.get(i)), context));
        }

        return new YieldAdapter(context, list);
    }
}
