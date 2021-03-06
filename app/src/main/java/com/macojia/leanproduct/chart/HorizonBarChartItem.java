package com.macojia.leanproduct.chart;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.macojia.leanproduct.R;

public class HorizonBarChartItem extends ChartItem {

    private Typeface mTf;
    private String mTitle;
    private String mXLabel;
    private String mYLabel;
    private String[] mLeftAxisLabels;

    public HorizonBarChartItem(ChartData<?> cd, Context c, String title, String xLabel, String yLabel) {
        super(cd);
        mTitle = title;
        mXLabel = xLabel;
        mYLabel = yLabel;
        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
    }

    public HorizonBarChartItem(ChartData<?> cd, Context c, String title, String xLabel, String yLabel, String[] leftAxisLabels) {
        super(cd);
        mTitle = title;
        mXLabel = xLabel;
        mYLabel = yLabel;
        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
        mLeftAxisLabels = leftAxisLabels;
    }

    @Override
    public int getItemType() {
        return TYPE_BARCHART;
    }

    @Override
    public View getView(int position, View convertView, Context c) {

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(c).inflate(
                    R.layout.list_item_barchart, null);
            holder.chart = (BarChart) convertView.findViewById(R.id.chart);
            holder.titleView = (TextView) convertView.findViewById(R.id.tv_bar_title);
            holder.xLabelView = (TextView) convertView.findViewById(R.id.tv_label_x);
            holder.yLabelView = (TextView) convertView.findViewById(R.id.tv_label_y);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.chart.getLegend().setFormSize(0);
        holder.titleView.setText(mTitle);
        holder.xLabelView.setText(mXLabel);
        holder.yLabelView.setText(mYLabel);

        // apply styling
        holder.chart.getLegend().setFormSize(0);
        holder.chart.getDescription().setEnabled(false);
        holder.chart.setDrawGridBackground(false);
        holder.chart.setDrawBarShadow(false);

        XAxis xAxis = holder.chart.getXAxis();
        if (mLeftAxisLabels != null) {
            xAxis.setValueFormatter(new LabelFormatter(mLeftAxisLabels));
            xAxis.setLabelRotationAngle(25);
            xAxis.setLabelCount(mLeftAxisLabels.length);
        }
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = holder.chart.getAxisLeft();
        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(5, false);
        leftAxis.setSpaceTop(20f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = holder.chart.getAxisRight();
        rightAxis.setTypeface(mTf);
        rightAxis.setLabelCount(5, false);
        rightAxis.setSpaceTop(20f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        mChartData.setValueTypeface(mTf);

        // set data
        holder.chart.setData((BarData) mChartData);
        holder.chart.setFitBars(true);

        // do not forget to refresh the chart
//        holder.chart.invalidate();
        holder.chart.animateY(700);

        return convertView;
    }

    private static class ViewHolder {
        BarChart chart;
        TextView titleView;
        TextView xLabelView;
        TextView yLabelView;
    }
}
