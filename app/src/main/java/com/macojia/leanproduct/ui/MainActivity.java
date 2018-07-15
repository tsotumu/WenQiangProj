package com.macojia.leanproduct.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.macojia.common.base.BaseActivity;
import com.macojia.common.baseapp.AppConfig;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.daynightmodeutils.ChangeModeController;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.TabEntity;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.fragement.CareMainFragment;
import com.macojia.leanproduct.ui.fragement.ControlMainFragment;
import com.macojia.leanproduct.ui.news.NewsMainFragment;
import com.macojia.leanproduct.ui.fragement.VideoMainFragment;

import java.util.ArrayList;

import base.utils.ResourceUtil;
import butterknife.Bind;
import cn.hugeterry.updatefun.UpdateFunGO;
import cn.hugeterry.updatefun.config.UpdateKey;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import rx.functions.Action1;

/**
 * Created by xsf on 2016.09.15:32
 */
public class MainActivity extends BaseActivity {
    private static int tabLayoutHeight;

    @Bind(R.id.tab_layout)
    CommonTabLayout mTabLayout;

    private int[] mTitles = {R.string.home, R.string.control, R.string.weiguan, R.string.shichuang};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal,
            R.mipmap.ic_girl_normal,
            R.mipmap.ic_video_normal,
            R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected,
            R.mipmap.ic_girl_selected,
            R.mipmap.ic_video_selected,
            R.mipmap.ic_care_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private NewsMainFragment newsFragment;
    // private PhotosMainFragment photosMainFragment;
    private VideoMainFragment videoMainFragment;
    private CareMainFragment careMainFragment;
    private ControlMainFragment controlMainFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //切换daynight模式要立即变色的页面
        ChangeModeController.getInstance().init(this, R.attr.class);
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        mTabLayout.measure(0, 0);
        tabLayoutHeight = mTabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏
        mRxManager.on(AppConstant.MENU_SHOW_HIDE, new Action1<Boolean>() {

            @Override
            public void call(Boolean hideOrShow) {
                startAnimation(hideOrShow);
            }
        });
    }

    @Override
    public void initView() {
        //此处填上在http://fir.im/注册账号后获得的API_TOKEN以及APP的应用ID
        UpdateKey.API_TOKEN = AppConfig.API_FIRE_TOKEN;
        UpdateKey.APP_ID = AppConfig.APP_FIRE_ID;
        //如果你想通过Dialog来进行下载，可以如下设置
//        UpdateKey.DialogOrNotification=UpdateKey.WITH_DIALOG;
        UpdateFunGO.init(this);
        //初始化菜单
        initTab();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }

    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(ResourceUtil.getString(mTitles[i]), mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);
        //点击监听
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchFragment(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            newsFragment = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsFragment");
            //  photosMainFragment = (PhotosMainFragment) getSupportFragmentManager().findFragmentByTag("photosMainFragment");
            videoMainFragment = (VideoMainFragment) getSupportFragmentManager().findFragmentByTag("videoMainFragment");
            careMainFragment = (CareMainFragment) getSupportFragmentManager().findFragmentByTag("careMainFragment");
            controlMainFragment = (ControlMainFragment) getSupportFragmentManager().findFragmentByTag("controlMainFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            newsFragment = new NewsMainFragment();
            //      photosMainFragment = new PhotosMainFragment();
            videoMainFragment = new VideoMainFragment();
            careMainFragment = new CareMainFragment();
            controlMainFragment = new ControlMainFragment();
            transaction.add(R.id.fl_container, newsFragment, "newsFragment");
            //     transaction.add(R.id.fl_body, photosMainFragment, "photosMainFragment");
            transaction.add(R.id.fl_container, videoMainFragment, "videoMainFragment");
            transaction.add(R.id.fl_container, careMainFragment, "careMainFragment");
            transaction.add(R.id.fl_container, controlMainFragment, "controlMainFragment");
        }
        transaction.commit();
        switchFragment(currentTabPosition);
        mTabLayout.setCurrentTab(currentTabPosition);
    }

    private void switchFragment(int position) {
        LogUtils.logd("主页菜单position" + position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0: {
                //首页
                transaction.hide(controlMainFragment);
                //     transaction.hide(photosMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(newsFragment);
                transaction.commitAllowingStateLoss();
                break;
            }
            case 1: {
                // 管控
                transaction.hide(newsFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                //transaction.show(photosMainFragment);
                transaction.show(controlMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            }
            case 2: {
                //视频
                transaction.hide(newsFragment);
                // transaction.hide(photosMainFragment);
                transaction.hide(controlMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            }
            case 3: {
                //关注
                transaction.hide(newsFragment);
                // transaction.hide(photosMainFragment);
                transaction.hide(controlMainFragment);
                transaction.hide(videoMainFragment);
                transaction.show(careMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            }
            default:
                break;
        }
    }

    /**
     * 菜单显示隐藏动画
     *
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide) {
        final ViewGroup.LayoutParams layoutParams = mTabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if (!showOrHide) {
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(mTabLayout, "alpha", 1, 0);
        } else {
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(mTabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = (int) valueAnimator.getAnimatedValue();
                mTabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator, alpha);
        animatorSet.start();
    }

    /**
     * 监听全屏视频时返回键
     */
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //奔溃前保存位置
        LogUtils.loge("onSaveInstanceState进来了1");
        if (mTabLayout != null) {
            LogUtils.loge("onSaveInstanceState进来了2");
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, mTabLayout.getCurrentTab());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        UpdateFunGO.onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        UpdateFunGO.onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ChangeModeController.onDestory();
    }
}
