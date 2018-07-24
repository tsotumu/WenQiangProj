package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;

import java.util.List;

/**
 * Created by Administrator on 2018/7/24.
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
}
