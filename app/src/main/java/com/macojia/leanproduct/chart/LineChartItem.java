
package com.macojia.leanproduct.chart;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.LineData;
import com.macojia.leanproduct.R;

import base.utils.LogUtil;
import base.utils.ResourceUtil;

public class LineChartItem extends ChartItem {

    private Typeface mTf;
    private String mTitle;
    private String mXLabel;
    private String mYLabel;
    private String[] mXAxisLabels;

    public LineChartItem(ChartData<?> cd, Context c, String title, String xLabel, String yLabel/*, String[] strings*/) {
        super(cd);
        mTitle = title;
        mXLabel = xLabel;
        mYLabel = yLabel;
        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
//        mXAxisLabels = strings;
    }

    public LineChartItem(ChartData<?> cd, Context c, String title, String xLabel, String yLabel, String[] strings) {
        super(cd);
        mTitle = title;
        mXLabel = xLabel;
        mYLabel = yLabel;
        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
        mXAxisLabels = strings;
    }


    @Override
    public int getItemType() {
        return TYPE_LINECHART;
    }

    @Override
    public View getView(int position, View convertView, Context c) {

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(c).inflate(
                    R.layout.list_item_linechart, null);
            holder.chart = (LineChart) convertView.findViewById(R.id.chart);
            holder.titleView = (TextView)convertView.findViewById(R.id.tv_bar_title);
            holder.xLabelView = (TextView)convertView.findViewById(R.id.tv_label_x);
            holder.yLabelView = (TextView)convertView.findViewById(R.id.tv_label_y);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // apply styling
        // holder.chart.setValueTypeface(mTf);
        holder.chart.getLegend().setFormSize(0);
        holder.titleView.setText(mTitle);
        holder.xLabelView.setText(mXLabel);
        holder.yLabelView.setText(mYLabel);

        holder.chart.getDescription().setEnabled(false);
        holder.chart.setDrawGridBackground(false);
        holder.chart.setDrawMarkers(true);
        holder.chart.getLegend().setFormSize(0);

        XAxis xAxis = holder.chart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = holder.chart.getAxisLeft();
        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(5, false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        
        YAxis rightAxis = holder.chart.getAxisRight();
        if (mXAxisLabels == null) {
            mXAxisLabels = new String[]{
                    "2017.8", "2017.8", "2017.8", "2017.8", "2017.8", "2017.8", "2017.8", "2017.8", "2017.8", "2017.8"
            };
        }
        xAxis.setValueFormatter(new LabelFormatter(mXAxisLabels));
        xAxis.setLabelCount(mXAxisLabels.length, true);
        LogUtil.pintArray("qualityIndex", "mXAxisLabels->", mXAxisLabels);
        rightAxis.setTypeface(mTf);
        rightAxis.setLabelCount(5, false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        mChartData.setValueTypeface(mTf);
        mChartData.setValueTextColor(ResourceUtil.getColor(R.color.alpha_40_black));
        mChartData.setValueTextSize(9f);
        // set data
        holder.chart.setData((LineData) mChartData);

        // do not forget to refresh the chart
        // holder.chart.invalidate();
        holder.chart.animateX(750);
        return convertView;
    }

    private static class ViewHolder {
        LineChart chart;
        TextView titleView;
        TextView xLabelView;
        TextView yLabelView;
    }
}
