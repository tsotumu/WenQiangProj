package com.macojia.leanproduct.ui.fragement;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.macojia.common.base.BaseFragment;
import com.macojia.common.daynightmodeutils.ChangeModeController;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.pojo.HotelEntity;
import com.macojia.leanproduct.pojo.SectionedSpanSizeLookup;
import com.macojia.leanproduct.activity.news.AboutActivity;
import com.macojia.leanproduct.activity.zone.CircleZoneActivity;
import com.macojia.leanproduct.ui.main.HotelEntityAdapter;

import base.utils.JsonUtils;
import butterknife.Bind;

/**
 * des:视窗首页
 * Created by xsf
 * on 2016.09.17:07
 */
public class CareMainFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
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
