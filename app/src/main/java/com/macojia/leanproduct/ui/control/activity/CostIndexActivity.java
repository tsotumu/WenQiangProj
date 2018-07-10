package com.macojia.leanproduct.ui.control.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.adapter.CostIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.CostListContact;
import com.macojia.leanproduct.ui.control.model.CostIndexModel;
import com.macojia.leanproduct.ui.control.presenter.CostIndexPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class CostIndexActivity extends BaseActivity<CostIndexPresenter, CostIndexModel> implements CostListContact.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_cost)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_costindex;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getCostListDataRequest();
    }

    private void initToolBar() {
        mToolbar.setTitle(getTitleId());
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
    }

    public int getTitleId() {
        return R.string.control_cost_index;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private BarData generateData(int cnt) {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        for (int i = 0; i < 12; i++) {
            entries.add(new BarEntry(i, (float) (Math.random() * 70) - 50));
        }
        BarDataSet d = new BarDataSet(entries, cnt + "号机器");
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void returnCostIndexListData(List<CostIndexData> costIndexData) {
        LogUtils.logd("Cost index test：" + costIndexData.toString());

        ArrayList<BarData> list = new ArrayList<BarData>();
        // 20 items
        for (int i = 0; i < 19; i++) {
            list.add(generateData(i + 1));
        }
        CostIndexAdapter cda = new CostIndexAdapter();
        mListView.setAdapter(cda);
    }

    @Override
    public void scrolltoTop() {

    }

}