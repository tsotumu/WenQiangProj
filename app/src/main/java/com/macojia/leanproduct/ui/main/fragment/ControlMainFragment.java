package com.macojia.leanproduct.ui.main.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.db.ControlItemTableManager;
import com.macojia.leanproduct.ui.news.activity.AboutActivity;
import com.macojia.leanproduct.ui.news.adapter.ItemAppAdapter;
import com.macojia.leanproduct.ui.news.contract.ControlItemContract;
import com.macojia.leanproduct.ui.news.model.ControlItemsModel;
import com.macojia.leanproduct.ui.news.presenter.ControlItemsPresenter;
import com.macojia.leanproduct.ui.zone.activity.CircleZoneActivity;
import com.macojia.common.base.BaseFragment;
import com.macojia.common.commonutils.ImageLoaderUtils;
import com.macojia.common.commonwidget.WaveView;
import com.macojia.common.daynightmodeutils.ChangeModeController;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.support.v7.widget.LinearLayoutManager.*;

/**
 * des:管控主页
 * Created by macojia
 * on 2018.03.25 03:40
 */
public class ControlMainFragment extends BaseFragment<ControlItemsPresenter,ControlItemsModel> implements ControlItemContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.irc)
    IRecyclerView controlItemsMineRv;
    private ItemAppAdapter itemAppAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_control_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        mPresenter.lodeItemsRequest();

    }

    @Override
    public void returnMineControlItems(List<ItemApp> controlItemsMine) {

        itemAppAdapter = new ItemAppAdapter(getContext(), R.layout.item_control,controlItemsMine);
        controlItemsMineRv.setLayoutManager(new GridLayoutManager(getContext(), 4, LinearLayoutManager.VERTICAL, false));
        controlItemsMineRv.setItemAnimator(new DefaultItemAnimator());
        controlItemsMineRv.setAdapter(itemAppAdapter);

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
