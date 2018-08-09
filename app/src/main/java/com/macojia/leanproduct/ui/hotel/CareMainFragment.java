package com.macojia.leanproduct.ui.hotel;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.macojia.common.base.BaseFragment;
import com.macojia.common.daynightmodeutils.ChangeModeController;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.hotel.HotelEntity;
import com.macojia.leanproduct.ui.news.activity.AboutActivity;

import base.utils.JsonUtils;
import butterknife.Bind;

/**
 * des:视窗首页
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
        HotelEntity entity = JsonUtils.analysisNewsJsonFile(HotelEntity.class, "shichuang");
        mAdapter.setData(entity.allTagsList);
    }

    //    @OnClick(R.id.ll_daynight_toggle)
    public void dayNightToggle() {
        ChangeModeController.toggleThemeSetting(getActivity());
    }

    //    @OnClick(R.id.ll_daynight_about)
    public void about() {
        AboutActivity.startAction(getContext());
    }

    /**
     * A SpanSizeLookup to draw section headers or footer spanning the whole width of the RecyclerView
     * when using a GridLayoutManager
     */
    public static class SectionedSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        protected SectionedRecyclerViewAdapter<?, ?, ?> adapter = null;
        protected GridLayoutManager layoutManager = null;

        public SectionedSpanSizeLookup(SectionedRecyclerViewAdapter<?, ?, ?> adapter, GridLayoutManager layoutManager) {
            this.adapter = adapter;
            this.layoutManager = layoutManager;
        }

        @Override
        public int getSpanSize(int position) {

            if (adapter.isSectionHeaderPosition(position) || adapter.isSectionFooterPosition(position)) {
                return layoutManager.getSpanCount();
            } else {
                return 1;
            }

        }
    }
}
