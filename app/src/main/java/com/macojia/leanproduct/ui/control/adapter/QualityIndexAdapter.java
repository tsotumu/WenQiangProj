package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.data.BarData;
import com.macojia.leanproduct.app.AppApplication;
import com.macojia.leanproduct.chart.ChartItem;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexAdapter extends ArrayAdapter<ChartItem> {

    public QualityIndexAdapter(Context context, List<ChartItem> objects) {
        super(context, 0, objects);
    }

    public static QualityIndexAdapter getAdapter(){
        return new QualityIndexAdapter(AppApplication.getAppContext(), null);
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
