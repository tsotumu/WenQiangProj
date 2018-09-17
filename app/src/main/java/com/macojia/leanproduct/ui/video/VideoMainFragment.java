package com.macojia.leanproduct.ui.video;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macojia.common.base.BaseFragment;
import com.macojia.common.base.BaseFragmentAdapter;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.video.VideoChannelTable;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.db.VideosChannelTableManager;

import java.util.ArrayList;
import java.util.List;

import base.utils.MyUtils;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * des:视频首页
 * Created by xsf
 * on 2016.09.16:45
 */
public class VideoMainFragment extends BaseFragment {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.video_main_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        List<String> channelNames = new ArrayList<>();
        List<VideoChannelTable> videoChannelTableList = VideosChannelTableManager.loadVideosChannelsMine();
        List<Fragment> mNewsFragmentList = new ArrayList<>();
        for (int i = 0; i < videoChannelTableList.size(); i++) {
            channelNames.add(videoChannelTableList.get(i).getChannelName());
            mNewsFragmentList.add(createListFragments(videoChannelTableList.get(i)));
        }
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        MyUtils.dynamicSetTabLayoutMode(tabs);
        setPageChangeListener();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
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

    private VideoChildFragment createListFragments(VideoChannelTable videoChannelTable) {
        VideoChildFragment fragment = new VideoChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.VIDEO_TYPE, videoChannelTable.getChannelId());
        bundle.putString(VideoChildFragment.EXTRA_TYPE, videoChannelTable.getChannelName());
        fragment.setArguments(bundle);
        return fragment;
    }
}
