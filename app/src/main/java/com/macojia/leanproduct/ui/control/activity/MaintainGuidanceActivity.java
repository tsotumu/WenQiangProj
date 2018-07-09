package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;

import butterknife.Bind;

/**
 * Created by LC on 2018/5/1.
 */

public class MaintainGuidanceActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    public int getLayoutId() {
        return R.layout.activity_maintain_guidance;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initToolBar();
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
}
