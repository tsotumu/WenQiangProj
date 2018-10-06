package com.macojia.leanproduct.ui.hotel;

import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.macojia.common.base.BaseActivity;
import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.hotel.VWDetailEntity;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.hotel.contact.ViewWindowDetailContact;
import com.macojia.leanproduct.ui.hotel.model.VMDetailModel;
import com.macojia.leanproduct.ui.hotel.presenter.VWDetailPresenter;
import com.macojia.leanproduct.widget.URLImageGetter;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;

public class ViewWindowDetailActivity extends BaseActivity<VWDetailPresenter, VMDetailModel> implements ViewWindowDetailContact.View{
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.news_sub_title)
    TextView newsDetailFromTv;
    @Bind(R.id.news_detail_body_tv)
    TextView newsDetailBodyTv;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    public final static String VWDetailId = "vmDetailId";
    private int postId;


    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_view_window_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        // SetTranslanteBar();
        mToolbar.setTitle("");
        postId = getIntent().getIntExtra(VWDetailId, 0);
        mPresenter.getDataRequest(postId);
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
    public void OnReturned(VWDetailEntity vmDetail) {
        //mNewsDetailTitleTv.setText(newsTitle);
        setNewsDetailBodyTv(vmDetail, vmDetail.getWindow_content());
        ((TextView) findViewById(R.id.news_title)).setText(vmDetail.getWindow_title());
    }

    private void setNewsDetailBodyTv(final VWDetailEntity newsDetail, final String newsBody) {
        mRxManager.add(Observable.timer(500, TimeUnit.MILLISECONDS)
                .compose(RxSchedulers.<Long>io_main())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        setBody(newsDetail, newsBody);
                    }
                }));
    }

    private void setBody(VWDetailEntity newsDetail, String newsBody) {
//        if (isShowBody(newsBody, imgTotal)) {
//              mNewsDetailBodyTv.setMovementMethod(LinkMovementMethod.getInstance());//加这句才能让里面的超链接生效,实测经常卡机崩溃
        URLImageGetter mUrlImageGetter = new URLImageGetter(newsDetailBodyTv, newsBody, 0);
        newsDetailBodyTv.setText(Html.fromHtml(newsBody, mUrlImageGetter, null));
//        } else {
//            newsDetailBodyTv.setText(Html.fromHtml(newsBody));
//        }
    }

}
