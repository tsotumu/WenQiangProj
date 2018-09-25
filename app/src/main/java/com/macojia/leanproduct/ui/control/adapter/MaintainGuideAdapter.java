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
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.MatainGuideData;
import com.macojia.leanproduct.chart.LabelFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/8.
 */

public class MaintainGuideAdapter extends ArrayAdapter<BarData> {
    private List<String> mTitleList;
    private List<List<String>> mAxisLabels;

    public MaintainGuideAdapter(Context context, List<BarData> objects) {
        super(context, 0, objects);
    }

    public static MaintainGuideAdapter getAdapter(MatainGuideData data) {
        List<String> barTitleList = new ArrayList<>();
        ArrayList<BarData> barList = new ArrayList<>();
        List<List<String>> axisLabels = new ArrayList<>();
        List<MatainGuideData.MaintainDataListBean> maintainDataListBeanList = data.getMaintainDataList();
        for (int i = 0; i < maintainDataListBeanList.size(); i++) {
            List<MatainGuideData.MaintainDataListBean.DataBean> dataList = maintainDataListBeanList.get(i).getData();
            barList.add(generateData(dataList));
            barTitleList.add(maintainDataListBeanList.get(i).getMachineName());
            List<String> titleList = new ArrayList<>();
            for (MatainGuideData.MaintainDataListBean.DataBean dataBean : dataList) {
                titleList.add(dataBean.getKey());
            }
            axisLabels.add(titleList);
        }
        MaintainGuideAdapter adapter = new MaintainGuideAdapter(AppApplication.getInstance(), barList);
        adapter.mAxisLabels = axisLabels;
        adapter.mTitleList = barTitleList;
        return adapter;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private static BarData generateData(List<MatainGuideData.MaintainDataListBean.DataBean> dataList) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int count = 0; count < dataList.size(); count++) {
            entries.add(new BarEntry(count, dataList.get(count).getValue()));
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
        holder.chartTitle.setText(mTitleList.get(position));

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
        if (mAxisLabels != null && mAxisLabels.get(position) != null) {
            String[] titles = new String[0];
            titles = mAxisLabels.get(position).toArray(titles);
            xAxis.setValueFormatter(new LabelFormatter(titles));
            xAxis.setLabelRotationAngle(25);
            xAxis.setLabelCount(titles.length);
        }

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
