package com.macojia.leanproduct.ui.activity.control;

import android.content.Context;
import android.content.Intent;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.activity.news.ForecastProgressActivity;

/**
 * Created by LC on 2018/5/1.
 */

public class CostIndexActivity extends BaseControlActivity {
    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        super.initView();
        setPageTitle(R.string.control_cost_index);
    }

}
