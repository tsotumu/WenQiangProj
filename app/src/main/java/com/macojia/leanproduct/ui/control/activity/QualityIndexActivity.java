package com.macojia.leanproduct.ui.control.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.control.adapter.QualityIndexAdapter;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;
import com.macojia.leanproduct.ui.control.model.QualityIndexModel;
import com.macojia.leanproduct.ui.control.presenter.QualityIndexPresenter;

import butterknife.Bind;


/**
 * des:质量指标详情
 * Created by LC
 */
public class QualityIndexActivity extends BaseActivity<QualityIndexPresenter, QualityIndexModel> implements QualityIndexContract.View{
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.lv_quality)
    ListView mListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_qualityindex;
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


    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }
    public int getTitleId() {
        return R.string.qualityindex;
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
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void onIndexDataReturn(QualityIndexData qualityIndexData) {
        mListView.setAdapter(QualityIndexAdapter.getAdapter(getApplicationContext(), qualityIndexData));
    }

    @Override
    public void scrolltoTop() {

    }


}
