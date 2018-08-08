package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.MatainGuideData;
import com.macojia.leanproduct.ui.control.adapter.MaintainGuideAdapter;
import com.macojia.leanproduct.ui.control.contact.MatainGuideConstract;
import com.macojia.leanproduct.ui.control.model.MatainGuideModel;
import com.macojia.leanproduct.ui.control.presenter.MatainGuidePresenter;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class MaintainGuidanceActivity extends BaseActivity<MatainGuidePresenter, MatainGuideModel> implements MatainGuideConstract.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_matain)
    ListView mListView;

    public int getLayoutId() {
        return R.layout.activity_maintain_guidance;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        initToolBar();
        mPresenter.getListDataRequest();
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
        return R.string.repairguide;
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
    public void onListDataReturn(MatainGuideData indexData) {
        mListView.setAdapter(MaintainGuideAdapter.getAdapter(indexData));

    }

    @Override
    public void scrolltoTop() {

    }
}
