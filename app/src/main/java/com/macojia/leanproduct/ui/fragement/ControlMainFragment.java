package com.macojia.leanproduct.ui.fragement;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.macojia.common.base.BaseFragment;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.ui.control.activity.ForecastProgressActivity;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.ui.control.activity.ComprehensiveIndexActivity;
import com.macojia.leanproduct.ui.control.activity.CostIndexActivity;
import com.macojia.leanproduct.ui.control.activity.EfficiencyIndexActivity;
import com.macojia.leanproduct.ui.control.activity.MaintainGuidanceActivity;
import com.macojia.leanproduct.ui.control.activity.QualityFeedBackActivity;
import com.macojia.leanproduct.ui.control.activity.QualityIndexActivity;
import com.macojia.leanproduct.ui.control.activity.YieldIndexActivity;
import com.macojia.leanproduct.ui.news.contract.ControlItemContract;
import com.macojia.leanproduct.ui.news.model.ControlItemsModel;
import com.macojia.leanproduct.ui.news.presenter.ControlItemsPresenter;

import java.util.List;

import base.utils.ActivityUtil;
import butterknife.Bind;

/**
 * des:管控主页
 * Created by macojia
 * on 2018.03.25 03:40
 */
public class ControlMainFragment extends BaseFragment<ControlItemsPresenter, ControlItemsModel> implements ControlItemContract.View {
    @Bind(R.id.irc)
    IRecyclerView controlItemsMineRv;
    private ItemAppAdapter itemAppAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.control_main_fragment;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    protected void initView() {
        mPresenter.lodeItemsRequest();

    }

    @Override
    public void returnMineControlItems(List<ItemApp> controlItemsMine) {

        itemAppAdapter = new ItemAppAdapter(getContext(), R.layout.item_control, controlItemsMine);
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

    private class ItemAppAdapter extends CommonRecycleViewAdapter<ItemApp> {

        public ItemAppAdapter(Context context, int layoutId, final List<ItemApp> datas) {
            super(context, layoutId, datas);
        }

        private void setItemValues(final ViewHolderHelper holder, final ItemApp itemApp, final int position) {

            String name = itemApp.getName();
            int image = itemApp.getImage();

            holder.setText(R.id.control_item_name, name);
            holder.setImageResource(R.id.control_item_icon, image);

            holder.setOnClickListener(R.id.rl_control_root, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    LogUtils.logd("我的6666" + pos);
                    switch (pos){
                        // 产量指标
                        case 2:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, YieldIndexActivity.class);
                            break;
                        }
                        // 质量指标
                        case 3:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, QualityIndexActivity.class);
                            break;
                        }
                        //消耗指标
                        case 4:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, CostIndexActivity.class);
                            break;
                        }
                        //效率指标
                        case 5:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, EfficiencyIndexActivity.class);
                            break;
                        }
                        //综合指标
                        case 6:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, ComprehensiveIndexActivity.class);
                            break;
                        }
                        // 质量反馈
                        case 7:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, QualityFeedBackActivity.class);
                            break;
                        }
                        // 维修指导
                        case 8:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, MaintainGuidanceActivity.class);
                            break;
                        }
                        // 进度预测
                        case 9:{
                            ActivityUtil.startActivity(ControlMainFragment.this.mActivity, ForecastProgressActivity.class);
                            break;
                        }
                    }
                }
            });
        }

        @Override
        public void convert(ViewHolderHelper holder, ItemApp itemApp) {
            setItemValues(holder, itemApp, getPosition(holder));
        }

    }
}
