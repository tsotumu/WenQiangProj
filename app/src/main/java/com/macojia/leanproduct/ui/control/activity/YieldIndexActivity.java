package com.macojia.leanproduct.ui.control.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.control.adapter.YieldAdapter;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;
import com.macojia.leanproduct.ui.control.model.YieldModel;
import com.macojia.leanproduct.ui.control.presenter.YieldPresenter;
import com.macojia.leanproduct.ui.login.LoginActivity;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 * 产量指标。
 */

public class YieldIndexActivity extends BaseActivity<YieldPresenter, YieldModel> implements YieldListContact.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_yield)
    ListView mListView;

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getListDataRequest();
    }

    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }

    public int getTitleId() {
        return R.string.control_yield_index;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_yieldindex;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
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
    public void onListDataReturn(YieldIndexData indexData) {
        mListView.setAdapter(YieldAdapter.getAdapter(indexData, getApplicationContext()));
    }

    @Override
    public void scrolltoTop() {

    }
}
