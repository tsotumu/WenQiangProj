package com.macojia.leanproduct.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.macojia.leanproduct.R;
import com.macojia.leanproduct.activity.news.AboutActivity;
import com.macojia.leanproduct.activity.zone.CircleZoneActivity;
import com.macojia.common.base.BaseFragment;
import com.macojia.common.commonutils.ImageLoaderUtils;
import com.macojia.common.commonwidget.WaveView;
import com.macojia.common.daynightmodeutils.ChangeModeController;
import com.macojia.leanproduct.ui.main.HotelEntityAdapter;
import com.macojia.leanproduct.ui.main.model.HotelEntity;
import com.macojia.leanproduct.ui.main.model.SectionedSpanSizeLookup;

import base.utils.JsonUtils;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * des:关注主页
 * Created by xsf
 * on 2016.09.17:07
 */
public class CareMainFragment extends BaseFragment {
    @Bind(R.id.view_recyclerView)
    RecyclerView mRecyclerView;

    private HotelEntityAdapter mAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.fra_care_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mAdapter = new HotelEntityAdapter(getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(mAdapter, manager));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        HotelEntity entity = JsonUtils.analysisJsonFile(getContext(), "json");
        mAdapter.setData(entity.allTagsList);
    }

//    @OnClick(R.id.ll_friend_zone)
    public void friendZone() {
        CircleZoneActivity.startAction(getContext());
    }

//    @OnClick(R.id.ll_daynight_toggle)
    public void dayNightToggle() {
        ChangeModeController.toggleThemeSetting(getActivity());
    }

//    @OnClick(R.id.ll_daynight_about)
    public void about() {
        AboutActivity.startAction(getContext());
    }
}
