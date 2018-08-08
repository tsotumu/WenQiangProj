package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.adapter.CostIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.CostListContact;
import com.macojia.leanproduct.ui.control.model.CostIndexModel;
import com.macojia.leanproduct.ui.control.presenter.CostIndexPresenter;

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
        mPresenter.getDataRequest();
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
    public void onDataReturn(CostIndexData costIndexData) {
        LogUtils.logd("Cost index test：" + costIndexData.toString());

        CostIndexAdapter cda = CostIndexAdapter.getAdapter(costIndexData);
        mListView.setAdapter(cda);

    }

    @Override
    public void scrolltoTop() {

    }

}
