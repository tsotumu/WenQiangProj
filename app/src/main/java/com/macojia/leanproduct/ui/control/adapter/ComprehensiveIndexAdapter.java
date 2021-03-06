package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.bean.control.ComprehensiveIndexData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LC on 2018/7/17.
 */

public class ComprehensiveIndexAdapter extends ArrayAdapter<BarData> {

    public ComprehensiveIndexAdapter(Context context, List<BarData> objects) {
        super(context, 0, objects);
    }

    public static ComprehensiveIndexAdapter getAdapter(ComprehensiveIndexData data) {
        List<String> titleList = new ArrayList<>();
        ArrayList<BarData> list = new ArrayList<>();
        for (int i = 0; i < data.indexData.size(); i++) {
            ComprehensiveIndexData.MonthlyData costIndexData = data.indexData.get(i);
            list.add(generateData(costIndexData));
        }
        ComprehensiveIndexAdapter adapter = new ComprehensiveIndexAdapter(AppApplication.getInstance(), list);
        return adapter;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private static BarData generateData(ComprehensiveIndexData.MonthlyData monthlyDataList) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int count = 0; count < monthlyDataList.data.size(); count++) {
            entries.add(new BarEntry(count, monthlyDataList.data.get(count)));
        }
        BarDataSet barDataSet = new BarDataSet(entries, "");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();
        sets.add(barDataSet);

        BarData barData = new BarData(sets);
        barData.setBarWidth(0.9f);
        return barData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BarData data = getItem(position);

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_vitical_barchart, null);
            holder.chart = (BarChart) convertView.findViewById(R.id.chart);
            holder.chartTitle = (TextView) convertView.findViewById(R.id.tv_bar_title);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // apply styling
//            data.setValueTypeface(mTfLight);
        holder.chartTitle.setText(position + "号包装机");

        data.setValueTextColor(Color.BLACK);
        holder.chart.getDescription().setEnabled(false);
        holder.chart.setDrawGridBackground(false);
        holder.chart.getDescription().setEnabled(false);
        holder.chart.getLegend().setFormSize(0);

        XAxis xAxis = holder.chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//            xAxis.setTypeface(mTfLight);
        xAxis.setDrawGridLines(false);

        YAxis leftAxis = holder.chart.getAxisLeft();
//            leftAxis.setTypeface(mTfLight);
        leftAxis.setLabelCount(5, false);
        leftAxis.setSpaceTop(15f);

        YAxis rightAxis = holder.chart.getAxisRight();
//            rightAxis.setTypeface(mTfLight);
        rightAxis.setLabelCount(5, false);
        rightAxis.setSpaceTop(15f);

        // set data
        holder.chart.setData(data);
        holder.chart.setFitBars(true);

        // do not forget to refresh the chart
//            holder.chart.invalidate();
        holder.chart.animateY(700);

        return convertView;
    }

    private class ViewHolder {
        BarChart chart;
        TextView chartTitle;
    }
}
