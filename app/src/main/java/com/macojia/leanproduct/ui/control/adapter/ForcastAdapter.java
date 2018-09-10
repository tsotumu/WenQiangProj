package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.chart.ChartItem;
import com.macojia.leanproduct.ui.control.contact.MatainGuideConstract;

import java.util.ArrayList;
import java.util.List;

public class ForcastAdapter extends CommonRecycleViewAdapter<ForcastData.DataListBean> {

    public ForcastAdapter(Context context) {
        super(context,  R.layout.layout_forcast_item);
    }

    public static ForcastAdapter getAdapter(Context context) {
        return new ForcastAdapter(context);
    }

    @Override
    public void convert(ViewHolderHelper helper, ForcastData.DataListBean forcastData) {
        NumberProgressBar numberProgressBar = helper.getView(R.id.tsyh);
        numberProgressBar.setMax(100);
        numberProgressBar.setProgress(forcastData.getPercent());
        numberProgressBar.setPrefix(forcastData.getName());
    }
}
