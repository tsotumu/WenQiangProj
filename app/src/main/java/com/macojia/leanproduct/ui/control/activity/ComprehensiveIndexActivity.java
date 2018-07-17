package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.ComprehensiveIndexData;
import com.macojia.leanproduct.ui.control.adapter.ComprehensiveIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.ComprehensiveIndexContract;
import com.macojia.leanproduct.ui.control.model.ComprehensiveIndexModel;
import com.macojia.leanproduct.ui.control.presenter.ComprehensivePresenter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class ComprehensiveIndexActivity extends BaseActivity<ComprehensivePresenter, ComprehensiveIndexModel> implements ComprehensiveIndexContract.View{
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_copmprehensive)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_comprehensiveindex;
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

    private void initToolBar(){
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
        return R.string.comprehenindex;
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
    public void onIndexListDataReturn(List<ComprehensiveIndexData> comprehensiveData) {
        LogUtils.logd("Cost index test：" + comprehensiveData.toString());

        ComprehensiveIndexAdapter cda = ComprehensiveIndexAdapter.getAdapter(comprehensiveData);
        mListView.setAdapter(cda);

    }

    @Override
    public void scrolltoTop() {

    }
}
