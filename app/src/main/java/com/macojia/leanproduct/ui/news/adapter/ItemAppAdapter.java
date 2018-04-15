package com.macojia.leanproduct.ui.news.adapter;

import android.content.Context;
import android.view.View;

import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.ItemApp;
import com.macojia.leanproduct.activity.news.AboutActivity;
import com.macojia.leanproduct.activity.news.CompreIndexActivity;
import com.macojia.leanproduct.activity.news.CostIndexActivity;
import com.macojia.leanproduct.activity.news.EfficiencyIndexActivity;
import com.macojia.leanproduct.activity.news.NewsChannelActivity;
import com.macojia.leanproduct.activity.news.QualityIndexActivity;
import com.macojia.leanproduct.activity.news.YieldIndexActivity;
import com.macojia.common.commonutils.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/25 0025.
 */

public class ItemAppAdapter extends CommonRecycleViewAdapter<ItemApp> {

    private ItemAppAdapter.OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(ItemAppAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    public ItemAppAdapter(Context context, int layoutId,final List<ItemApp> datas) {
        super(context, layoutId,datas);
    }

    private void setItemValues(final ViewHolderHelper holder, final ItemApp itemApp, final int position) {

        String name = itemApp.getName();
        int image = itemApp.getImage();

        holder.setText(R.id.control_item_name,name);
        holder.setImageResource(R.id.control_item_icon,image);

        holder.setOnClickListener(R.id.rl_control_root, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int pos = holder.getLayoutPosition();
                LogUtils.logd("我的"+pos);
                //产量、质量、消耗、效率、综合指标、质量反馈、维修指导、进度预测
                if(pos==2){
                    YieldIndexActivity.startAction(mContext);
                }
                if(pos==3){
                    QualityIndexActivity.startAction(mContext);
                }
                if(pos==4){
                    CostIndexActivity.startAction(mContext);
                }
                if(pos==5){
                    EfficiencyIndexActivity.startAction(mContext);
                }
                if(pos==6){
                    CompreIndexActivity.startAction(mContext);
                }
                if(pos==7){
                    NewsChannelActivity.startAction(mContext);
                }
                if(pos==8){
                    NewsChannelActivity.startAction(mContext);
                }
                if(pos==9){
                    AboutActivity.startAction(mContext);
                }


                //ItemApp itemApp = mDatas.get();
               // String pos = ""+holder.getLayoutPosition();
              //  LogUtil.logd(pos,itemApp.getName());
               /* if(itemApp.getName().equals(AppConstant.QUALITY_ITEM)){

                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.EFFICIENCY_ITEM)){
                    AboutActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.YIELD_ITEM)){
                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.CONSUME_ITEM)){
                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.COMPREHENSIVE_ITEM)){
                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.FORECAST_ITEM)){
                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.FEEDBACK_ITEM)){
                    NewsChannelActivity.startActivity(mContext);
                }
                else if(itemApp.getName().equals(AppConstant.REPAIR_ITEM)){
                    AboutActivity.startActivity(mContext);
                }else{

                }*/


            }
        });
    }

    @Override
    public void convert(ViewHolderHelper holder, ItemApp itemApp) {
        setItemValues(holder,itemApp,getPosition(holder));
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
