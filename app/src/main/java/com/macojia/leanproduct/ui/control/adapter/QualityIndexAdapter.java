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
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;

import java.util.ArrayList;
import java.util.List;

import base.utils.ResourceUtil;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexAdapter extends ArrayAdapter<ChartItem> {

    public QualityIndexAdapter(Context context, List<ChartItem> objects) {
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

    private static LineData generateDataLine(List<QualityIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanList) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < indexListBeanList.size(); i++) {
            e1.add(new Entry(i, Double.valueOf(indexListBeanList.get(i).getValue()).floatValue()));
        }
        LineDataSet lineDataSet = new LineDataSet(e1, "");
        lineDataSet.setDrawValues(true);

        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(lineDataSet);

        LineData cd = new LineData(sets);
        return cd;
    }

    private static BarData generateDataBar(List<QualityIndexData.MachineIndexBean> machineIndexBeanList) {

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

    public static QualityIndexAdapter getAdapter(Context context, QualityIndexData qualityIndexData) {
        ArrayList<ChartItem> list = new ArrayList<>();
        list.add(new HorizonBarChartItem(generateDataBar(qualityIndexData.getMachineIndex()), context, qualityIndexData.getMachineTitle(), "指标", "包装机号", getHorizonBarChartLabels(qualityIndexData.getMachineIndex())));
        // 30 items
        List<QualityIndexData.MonthlyIndexPerMachineBean> monthlyIndexPerMachineBeanList = qualityIndexData.getMonthlyIndexPerMachine();
        for (int i = 0; i < monthlyIndexPerMachineBeanList.size(); i++) {
            List<QualityIndexData.MonthlyIndexPerMachineBean.IndexListBean> listBeanList = monthlyIndexPerMachineBeanList.get(i).getIndexList();
            list.add(new LineChartItem(generateDataLine(listBeanList), context, monthlyIndexPerMachineBeanList.get(i).getMachineName(), ResourceUtil.getString(R.string.x_label_month), ResourceUtil.getString(R.string.y_label_index), getLineChartLabels(listBeanList)));
        }
        return new QualityIndexAdapter(AppApplication.getAppContext(), list);
    }

    private static String[] getHorizonBarChartLabels(List<QualityIndexData.MachineIndexBean> machineIndexBeanList) {
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[machineIndexBeanList.size()];
        for (QualityIndexData.MachineIndexBean machineIndexBean : machineIndexBeanList) {
            labels.add(machineIndexBean.getKey());
        }
        return labels.toArray(result);
    }

    private static String[] getLineChartLabels(List<QualityIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanList) {
        ArrayList<String> labels = new ArrayList<>();
        String[] result = new String[indexListBeanList.size()];
        for (QualityIndexData.MonthlyIndexPerMachineBean.IndexListBean indexListBean : indexListBeanList) {
            labels.add(indexListBean.getKey());
        }
        return labels.toArray(result);
    }
}
