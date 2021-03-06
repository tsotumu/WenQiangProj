package com.macojia.leanproduct.ui.hotel;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.macojia.common.base.BaseFragment;
import com.macojia.common.daynightmodeutils.ChangeModeController;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;
import com.macojia.leanproduct.ui.control.contact.ViewWindowContact;
import com.macojia.leanproduct.ui.control.model.ViewWindowModel;
import com.macojia.leanproduct.ui.control.presenter.ViewWindowPresenter;
import com.macojia.leanproduct.ui.news.activity.AboutActivity;

import base.utils.JsonUtils;
import butterknife.Bind;

/**
 * des:视窗首页
 * Created by xsf
 * on 2016.09.17:07
 */
public class ViewWindowFragment extends BaseFragment<ViewWindowPresenter, ViewWindowModel> implements ViewWindowContact.View{
    @Bind(R.id.view_recyclerView)
    RecyclerView mRecyclerView;

    private HotelEntityAdapter mAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.fra_view_window_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    protected void initView() {
        mAdapter = new HotelEntityAdapter(getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(mAdapter, manager));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getDataRequest();
    }

    //    @OnClick(R.id.ll_daynight_toggle)
    public void dayNightToggle() {
        ChangeModeController.toggleThemeSetting(getActivity());
    }

    //    @OnClick(R.id.ll_daynight_about)
    public void about() {
        AboutActivity.startAction(getContext());
    }

    @Override
    public void onIndexDataReturn(ViewWindowEntity data) {

//        ViewWindowEntity entity = JsonUtils.analysisNewsJsonFile(ViewWindowEntity.class, "shichuang");
        mAdapter.setData(data.getAllTagsList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void scrolltoTop() {

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
