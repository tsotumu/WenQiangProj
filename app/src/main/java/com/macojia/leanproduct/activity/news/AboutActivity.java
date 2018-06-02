package com.macojia.leanproduct.activity.news;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;

import butterknife.Bind;

import static com.macojia.leanproduct.R.layout.activity_about_us;

/**
 * des:关于
 * Created by xsf
 * on 2016.09.16:57
 */
public class AboutActivity extends BaseActivity {


    @Bind(R.id.news_detail_photo_iv)
    ImageView newsDetailPhotoIv;
    @Bind(R.id.mask_view)
    View maskView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.news_detail_from_tv)
    TextView newsDetailFromTv;
    @Bind(R.id.tv_code_des)
    TextView tvCodeDes;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private String mShareLink;

    /**
     * 入口
     *
     * @param mContext
     */
    public static void startAction(Context mContext) {
        Intent intent = new Intent(mContext, AboutActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return activity_about_us;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        SetTranslanteBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
        toolbar.setTitle(getString(R.string.app_name));
        toolbarLayout.setTitle(getString(R.string.app_name));
        //分享
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mShareLink == null) {
                    mShareLink = "";
                }
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, getString(R.string.app_name), mShareLink));
                startActivity(Intent.createChooser(intent, getTitle()));
            }
        });

    }
}
