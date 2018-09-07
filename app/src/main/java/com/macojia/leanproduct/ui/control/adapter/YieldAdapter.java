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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import base.utils.ResourceUtil;

/**
 * Created by LC on 2018/7/24.
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

    private static BarData generateDataBar(List<YieldIndexData.MachineIndexBean> data) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < data.size(); i++) {
            entries.add(new BarEntry(i, Double.valueOf(data.get(i).getValue()).floatValue()));
        }

        BarDataSet d = new BarDataSet(entries, "");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private static LineData generateDataLine(YieldIndexData.MonthlyIndexPerMachineBean monthlyIndex) {

        ArrayList<Entry> monthlyDataSet = new ArrayList<Entry>();

        for (int i = 0; i < monthlyIndex.getIndexList().size(); i++) {
            monthlyDataSet.add(new Entry(i, Double.valueOf(monthlyIndex.getIndexList().get(i).getValue()).floatValue()));
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

        list.add(new HorizonBarChartItem(generateDataBar(indexData.getMachineIndex()), context, "产量年度指标", "指标", "包装机号", getHorizonBarChartLabels(indexData.getMachineIndex())));

        List<YieldIndexData.MonthlyIndexPerMachineBean> monthlyIndexPerMachineBeen = indexData.getMonthlyIndexPerMachine();

        for (int i = 0; i < monthlyIndexPerMachineBeen.size(); i++) {
            list.add(new LineChartItem(
                    generateDataLine(monthlyIndexPerMachineBeen.get(i)),
                    context,
                    monthlyIndexPerMachineBeen.get(i).getMachineName(),
                    ResourceUtil.getString(R.string.x_label_month),
                    ResourceUtil.getString(R.string.y_label_index),
                    getXAxis(monthlyIndexPerMachineBeen.get(i)))
            );
        }

        return new YieldAdapter(context, list);
    }

    private static String[] getHorizonBarChartLabels(List<YieldIndexData.MachineIndexBean> machineIndexBeanList){
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[machineIndexBeanList.size()];
        for (YieldIndexData.MachineIndexBean machineIndexBean : machineIndexBeanList){
            labels.add(machineIndexBean.getKey());
        }
        return labels.toArray(result);
    }

    private static String[] getXAxis(YieldIndexData.MonthlyIndexPerMachineBean monthlyIndexPerMachineBean){
        ArrayList<String> axis = new ArrayList<>();
        List<YieldIndexData.MonthlyIndexPerMachineBean.IndexListBean> monthlyIndex = monthlyIndexPerMachineBean.getIndexList();
        for (YieldIndexData.MonthlyIndexPerMachineBean.IndexListBean monthlyIndexBean : monthlyIndex){
            axis.add(monthlyIndexBean.getKey());
        }
        String[] strings = new String[axis.size()];
        return  axis.toArray(strings);
    }
}
