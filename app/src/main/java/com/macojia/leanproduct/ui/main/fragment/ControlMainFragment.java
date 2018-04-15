package com.macojia.leanproduct.ui.main.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.aspsine.irecyclerview.IRecyclerView;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.ui.news.adapter.ItemAppAdapter;
import com.macojia.leanproduct.ui.news.contract.ControlItemContract;
import com.macojia.leanproduct.ui.news.model.ControlItemsModel;
import com.macojia.leanproduct.ui.news.presenter.ControlItemsPresenter;
import com.macojia.common.base.BaseFragment;

import java.util.List;

import butterknife.Bind;

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
