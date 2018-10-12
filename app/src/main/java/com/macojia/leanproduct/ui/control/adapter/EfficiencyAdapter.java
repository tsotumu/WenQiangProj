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
import com.macojia.leanproduct.AppApplication;
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

    public static EfficiencyAdapter getAdapter(Context context, EfficiencyIndexData qualityIndexData) {
        ArrayList<ChartItem> list = new ArrayList<>();
        list.add(new HorizonBarChartItem(generateDataBar(qualityIndexData.getMachineIndex()), context, qualityIndexData.getMachineTitle(), "指标", "包装机号", getHorizonBarChartLabels(qualityIndexData.getMachineIndex())));
        // 30 items
        List<EfficiencyIndexData.MonthlyIndexPerMachineBean> monthlyIndexPerMachineBeanList = qualityIndexData.getMonthlyIndexPerMachine();
        for (int i = 0; i < monthlyIndexPerMachineBeanList.size(); i++) {
            List<EfficiencyIndexData.MonthlyIndexPerMachineBean.IndexListBean> listBeanList = monthlyIndexPerMachineBeanList.get(i).getIndexList();
            list.add(new LineChartItem(generateDataLine(listBeanList), context, monthlyIndexPerMachineBeanList.get(i).getMachineName(), ResourceUtil.getString(R.string.x_label_month), ResourceUtil.getString(R.string.y_label_index), getLineChartLabels(listBeanList)));
        }
        return new EfficiencyAdapter(AppApplication.getAppContext(), list);
    }

    private static LineData generateDataLine( List<EfficiencyIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanList) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < indexListBeanList.size(); i++) {
            e1.add(new Entry(i, Double.valueOf(indexListBeanList.get(i).getValue()).floatValue()));
        }

        LineDataSet d1 = new LineDataSet(e1, "");
        d1.setDrawValues(true);
        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(d1);

        LineData cd = new LineData(sets);
        return cd;
    }

    private static BarData generateDataBar(List<EfficiencyIndexData.MachineIndexBean> machineIndexBeanList) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

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

    private static String[] getHorizonBarChartLabels(List<EfficiencyIndexData.MachineIndexBean> machineIndexBeanList) {
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[machineIndexBeanList.size()];
        for (EfficiencyIndexData.MachineIndexBean machineIndexBean : machineIndexBeanList) {
            labels.add(machineIndexBean.getKey());
        }
        return labels.toArray(result);
    }

    private static String[] getLineChartLabels(List<EfficiencyIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanList) {
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[indexListBeanList.size()];
        for (EfficiencyIndexData.MonthlyIndexPerMachineBean.IndexListBean indexListBean : indexListBeanList) {
            labels.add(indexListBean.getKey());
        }
        return labels.toArray(result);
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
}