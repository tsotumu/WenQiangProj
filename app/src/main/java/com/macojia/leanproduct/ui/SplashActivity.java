package com.macojia.leanproduct.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.ui.login.LoginActivity;

import base.utils.ActivityUtil;
import butterknife.Bind;

/**
 * des:启动页
 * Created by xsf
 * on 2016.09.15:16
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        SetTranslanteBar();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {

                ActivityUtil.startActivity(SplashActivity.this, LoginActivity.class);
                finish();
            }
        }, 3000);
    }

}
