package com.macojia.leanproduct.activity.control;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.chart.HorizonBarChartItem;
import com.macojia.leanproduct.chart.LineChartItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class EfficiencyIndexActivity extends BaseControlActivity {
    @Bind(R.id.lv_efficient)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_efficiencyindex;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        super.initView();

        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        list.add(new HorizonBarChartItem(generateDataBar(1), getApplicationContext()));
        // 30 items
        for (int i = 0; i < 19; i++) {
            list.add(new LineChartItem(generateDataLine(i + 1), getApplicationContext()));
        }
        mListView.setAdapter(new ChartDataAdapter(getApplicationContext(), list));
    }

    @Override
    public int getTitleId() {
        return R.string.efficiencyindex;
    }


    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {

        public ChartDataAdapter(Context context, List<ChartItem> objects) {
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
    }


    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e1.add(new Entry(i, (int) (Math.random() * 65) + 40));
        }

        LineDataSet d1 = new LineDataSet(e1, cnt + "号包装机");
        d1.setLineWidth(2.5f);
        d1.setCircleRadius(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);

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
        sets.add(d1);
//        sets.add(d2);

        LineData cd = new LineData(sets);
        return cd;
    }

    private BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 19; i++) {
            entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "效率指标");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

}
