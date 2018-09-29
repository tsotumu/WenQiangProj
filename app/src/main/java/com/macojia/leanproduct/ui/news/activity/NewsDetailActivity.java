package com.macojia.leanproduct.ui.news.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.macojia.common.base.BaseActivity;
import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonutils.TimeUtil;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.news.NewsDetailEntity;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.news.contract.NewsDetailContract;
import com.macojia.leanproduct.ui.news.model.NewsDetailModel;
import com.macojia.leanproduct.ui.news.presenter.NewsDetailPresenter;
import com.macojia.leanproduct.widget.URLImageGetter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;

/**
 * des:普通新闻详情
 * Created by xsf
 * on 2016.09.16:57
 */
public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter, NewsDetailModel> implements NewsDetailContract.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.news_sub_title)
    TextView newsDetailFromTv;
    @Bind(R.id.news_detail_body_tv)
    TextView newsDetailBodyTv;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    private String postId;
    private String mNewsTitle;
    private String mShareLink;

    /**
     * 入口
     *
     * @param mContext
     * @param postId
     */
    public static void startAction(Context mContext, View view, String postId, String imgUrl) {
        Intent intent = new Intent(mContext, NewsDetailActivity.class);
        intent.putExtra(AppConstant.NEWS_POST_ID, postId);
        intent.putExtra(AppConstant.NEWS_IMG_RES, imgUrl);

    /*    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation((Activity) mContext, view, AppConstant.TRANSITION_ANIMATION_NEWS_PHOTOS);
            mContext.startActivity(intent, options.toBundle());
        } else {
*/
        //让新的Activity从一个小的范围扩大到全屏
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity((Activity) mContext, intent, options.toBundle());
        /*}*/

    }


    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void initView() {
        SetTranslanteBar();
        postId = getIntent().getStringExtra(AppConstant.NEWS_POST_ID);
        mPresenter.getOneNewsDataRequest(postId);
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
    public void OnOneNewsDataReturned(NewsDetailEntity newsDetail) {
        LogUtils.logd("OnOneNewsDataReturned->" + newsDetail.toString());
//        mShareLink = newsDetail.getShareLink();
        mNewsTitle = newsDetail.getNews_title();
        String newsSource = newsDetail.getNews_category();
        String newsTime = TimeUtil.formatDate(newsDetail.getNews_datetime());
        String newsBody = newsDetail.getNews_content();
        String NewsImgSrc = getImgSrcs(newsDetail);

        //mNewsDetailTitleTv.setText(newsTitle);
        newsDetailFromTv.setText(getString(R.string.news_from, newsSource, newsTime));
        setNewsDetailBodyTv(newsDetail, newsBody);
        ((TextView) findViewById(R.id.news_title)).setText(newsDetail.getNews_title());
    }

    private void setNewsDetailBodyTv(final NewsDetailEntity newsDetail, final String newsBody) {
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

    private void setBody(NewsDetailEntity newsDetail, String newsBody) {
        int imgTotal = newsDetail.getImg().size();
//        if (isShowBody(newsBody, imgTotal)) {
//              mNewsDetailBodyTv.setMovementMethod(LinkMovementMethod.getInstance());//加这句才能让里面的超链接生效,实测经常卡机崩溃
        URLImageGetter mUrlImageGetter = new URLImageGetter(newsDetailBodyTv, newsBody, imgTotal);
        newsDetailBodyTv.setText(Html.fromHtml(newsBody, mUrlImageGetter, null));
//        } else {
//            newsDetailBodyTv.setText(Html.fromHtml(newsBody));
//        }
    }

    private boolean isShowBody(String newsBody, int imgTotal) {
        return imgTotal >= 2 && newsBody != null;
    }

    private String getImgSrcs(NewsDetailEntity newsDetail) {
        List<NewsDetailEntity.ImgBean> imgSrcs = newsDetail.getImg();
        String imgSrc;
        if (imgSrcs != null && imgSrcs.size() > 0) {
            imgSrc = imgSrcs.get(0).getSrc();
        } else {
            imgSrc = getIntent().getStringExtra(AppConstant.NEWS_IMG_RES);
        }
        return imgSrc;
    }

    private boolean canBrowse(Intent intent) {
        return intent.resolveActivity(getPackageManager()) != null && mShareLink != null;
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

}
