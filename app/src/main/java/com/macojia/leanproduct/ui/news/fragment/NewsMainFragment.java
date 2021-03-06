package com.macojia.leanproduct.ui.news.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.macojia.common.base.BaseFragment;
import com.macojia.common.base.BaseFragmentAdapter;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.ui.news.activity.NewsChannelActivity;
import com.macojia.leanproduct.bean.news.NewsChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.news.contract.NewsMainContractBase;
import com.macojia.leanproduct.ui.control.model.NewsMainModel;
import com.macojia.leanproduct.ui.news.presenter.NewsMainPresenter;
import base.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 新闻子页面。
 */
public class NewsMainFragment extends BaseFragment<NewsMainPresenter, NewsMainModel> implements NewsMainContractBase.View {
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.add_channel_iv)
    ImageView addChannelIv;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton mFloatBtn;

    private BaseFragmentAdapter fragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.app_bar_news;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.logd("NewsMainFragment onresume");
    }

    @Override
    public void initView() {
        LogUtils.logd("lodeChannelsRequest");
        mPresenter.lodeChannelsRequest();
        mFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
    }

    @OnClick(R.id.add_channel_iv)
    public void clickAdd() {
        NewsChannelActivity.startAction(getContext());
    }

    @Override
    public void OnNewsChannelsReturned(List<NewsChannelTable> newsChannelsMine) {
        LogUtils.logd("OnNewsChannelsReturned->" + newsChannelsMine);
        if (newsChannelsMine != null) {
            List<String> channelNames = new ArrayList<>();
            List<Fragment> mNewsFragmentList = new ArrayList<>();
            for (int i = 0; i < newsChannelsMine.size(); i++) {
                channelNames.add(newsChannelsMine.get(i).getNewsChannelName());
                mNewsFragmentList.add(createListFragments(newsChannelsMine.get(i)));
            }
            if (fragmentAdapter == null) {
                fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
            } else {
                //刷新fragment
                fragmentAdapter.setFragments(getChildFragmentManager(), mNewsFragmentList, channelNames);
            }
            viewPager.setAdapter(fragmentAdapter);
            tabLayout.setupWithViewPager(viewPager);
            MyUtils.dynamicSetTabLayoutMode(tabLayout);
            setPageChangeListener();
        }
    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private NewsListFragment createListFragments(NewsChannelTable newsChannel) {
        LogUtils.logd("create new List fragment->"+newsChannel.toString());
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.NEWS_TYPE, newsChannel.getNewsChannelName());
        bundle.putInt(AppConstant.CHANNEL_POSITION, newsChannel.getNewsChannelIndex());
        fragment.setArguments(bundle);
        return fragment;
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
