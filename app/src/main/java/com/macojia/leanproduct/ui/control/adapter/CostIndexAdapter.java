package com.macojia.leanproduct.ui.control.adapter;

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
import com.macojia.leanproduct.app.AppApplication;
import com.macojia.leanproduct.bean.control.CostIndexData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by LC on 2018/7/10.
 */

public class CostIndexAdapter extends ArrayAdapter<BarData> {

    public static CostIndexAdapter getAdapter(List<CostIndexData> data){
        ArrayList<BarData> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++){
            CostIndexData costIndexData = data.get(i);
            list.add(generateData(costIndexData.monthlyDataList, costIndexData.machineName));
        }
        CostIndexAdapter adapter = new CostIndexAdapter(AppApplication.getInstance(), list);
        return adapter;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private static BarData generateData(List<CostIndexData.MonthlyData> monthlyDataList,  String dataTitle) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int count = 0; count < monthlyDataList.size(); count++){
            entries.add(new BarEntry(count, monthlyDataList.get(count).value));
        }
        BarDataSet barDataSet = new BarDataSet(entries, dataTitle);
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();
        sets.add(barDataSet);

        BarData barData = new BarData(sets);
        barData.setBarWidth(0.9f);
        return barData;
    }

    public CostIndexAdapter(Context context, List<BarData> objects) {
        super(context, 0, objects);
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

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // apply styling
//            data.setValueTypeface(mTfLight);
        data.setValueTextColor(Color.BLACK);
        holder.chart.getDescription().setEnabled(false);
        holder.chart.setDrawGridBackground(false);

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
    }
}
