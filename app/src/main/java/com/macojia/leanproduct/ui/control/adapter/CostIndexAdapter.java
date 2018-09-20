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
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.chart.LabelFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LC on 2018/7/10.
 */

public class CostIndexAdapter extends ArrayAdapter<BarData> {
    private List<String> mTitleList;
    private List<List<String>> mAxisLabels;

    public CostIndexAdapter(Context context, List<BarData> objects) {
        super(context, 0, objects);
    }

    public static CostIndexAdapter getAdapter(CostIndexData costIndexData) {
        List<String> barTitleList = new ArrayList<>();
        ArrayList<BarData> barList = new ArrayList<>();
        List<List<String>> axisLabels = new ArrayList<>();
        List<CostIndexData.MonthlyIndexPerMachineBean> monthlyIndexPerMachineBeans = costIndexData.getMonthlyIndexPerMachine();
        for (int i = 0; i < monthlyIndexPerMachineBeans.size(); i++) {
            List<CostIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanList = monthlyIndexPerMachineBeans.get(i).getIndexList();
            barList.add(generateSingleBarData(indexListBeanList));
            barTitleList.add(monthlyIndexPerMachineBeans.get(i).getMachineName());
            List<String> titleList = new ArrayList<>();
            for (CostIndexData.MonthlyIndexPerMachineBean.IndexListBean indexListBean : indexListBeanList){
                titleList.add(indexListBean.getKey());
            }
            axisLabels.add(titleList);
        }
        CostIndexAdapter adapter = new CostIndexAdapter(AppApplication.getInstance(), barList);
        adapter.mTitleList = barTitleList;
        adapter.mAxisLabels = axisLabels;
        return adapter;
    }

    private static BarData generateSingleBarData(List<CostIndexData.MonthlyIndexPerMachineBean.IndexListBean> indexListBeanLis) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int count = 0; count < indexListBeanLis.size(); count++) {
            entries.add(new BarEntry(count, indexListBeanLis.get(count).getValue()));
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

   /*     if (convertView == null) {*/

            holder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_vitical_barchart, null);
            holder.chart = (BarChart) convertView.findViewById(R.id.chart);
            holder.chartTitle = (TextView) convertView.findViewById(R.id.tv_bar_title);

            convertView.setTag(holder);

       /* } else {
            holder = (ViewHolder) convertView.getTag();
        }*/

        holder.chartTitle.setText(mTitleList.get(position));

        // apply styling
//            data.setValueTypeface(mTfLight);
        data.setValueTextColor(Color.BLACK);
        holder.chart.getDescription().setEnabled(false);
        holder.chart.getLegend().setFormSize(0);
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

        if (mAxisLabels != null && mAxisLabels.get(position) != null) {
            String[] titles = new String[0];
            titles = mAxisLabels.get(position).toArray(titles);
            xAxis.setValueFormatter(new LabelFormatter(titles));
            xAxis.setLabelRotationAngle(25);
        }
        rightAxis.setLabelCount(mAxisLabels.get(position).size(), false);
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
        TextView xTextView;
        TextView yTextView;
    }
}
