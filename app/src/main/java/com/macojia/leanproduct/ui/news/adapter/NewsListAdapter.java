package com.macojia.leanproduct.ui.news.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.MultiItemRecycleViewAdapter;
import com.aspsine.irecyclerview.universaladapter.recyclerview.MultiItemTypeSupport;
import com.macojia.common.commonutils.DisplayUtil;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.bean.news.NewsPhotoDetail;
import com.macojia.leanproduct.ui.news.activity.NewsDetailActivity;
import com.macojia.leanproduct.ui.news.activity.NewsPhotoDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * des:新闻列表适配器
 * Created by xsf
 * on 2016.09.10:49
 */
public class NewsListAdapter extends MultiItemRecycleViewAdapter<NewsListData.NewsListBean> {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_PHOTO_ITEM = 1;

    public NewsListAdapter(Context context, final List<NewsListData.NewsListBean> datas) {
        super(context, datas, new MultiItemTypeSupport<NewsListData.NewsListBean>() {

            @Override
            public int getLayoutId(int type) {
                if (type == TYPE_PHOTO_ITEM) {
                    return R.layout.item_news_photo;
                } else {
                    return R.layout.item_news;
                }
            }

            @Override
            public int getItemViewType(int position, NewsListData.NewsListBean msg) {
                if (!TextUtils.isEmpty(msg.getNews_digest())) {
                    return TYPE_ITEM;
                }
                return TYPE_PHOTO_ITEM;
            }
        });
    }

    @Override
    public void convert(ViewHolderHelper holder, NewsListData.NewsListBean newsSummary) {
        switch (holder.getLayoutId()) {
            case R.layout.item_news:
                setItemValues(holder, newsSummary, getPosition(holder));
                break;
            case R.layout.item_news_photo:
                setPhotoItemValues(holder, newsSummary, getPosition(holder));
                break;
        }
    }

    /**
     * 普通样式
     *
     * @param holder
     * @param newsSummary
     * @param position
     */
    private void setItemValues(final ViewHolderHelper holder, final NewsListData.NewsListBean newsSummary, final int position) {
        String title = newsSummary.getNews_title();
        if (title == null) {
            title = newsSummary.getNews_title();
        }
        String ptime = newsSummary.getNews_datetime();
        String digest = newsSummary.getNews_digest();
        String imgSrc = newsSummary.getNews_cover();

        holder.setText(R.id.news_summary_title_tv, title);
        holder.setText(R.id.news_summary_ptime_tv, ptime);
        holder.setText(R.id.news_summary_digest_tv, digest);
        holder.setImageUrl(R.id.news_summary_photo_iv, imgSrc);
        holder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDetailActivity.startAction(mContext, holder.getView(R.id.news_summary_photo_iv), newsSummary.getId() + "", newsSummary.getNews_cover());
            }
        });
    }


    /**
     * 图文样式
     *
     * @param holder
     * @param position
     */
    private void setPhotoItemValues(ViewHolderHelper holder, final NewsListData.NewsListBean newsSummary, int position) {
        String title = newsSummary.getNews_title();
        String ptime = newsSummary.getNews_datetime();
        holder.setText(R.id.news_summary_title_tv, title);
        holder.setText(R.id.news_summary_ptime_tv, ptime);
        setImageView(holder, newsSummary);
        holder.setOnClickListener(R.id.ll_root, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsPhotoDetailActivity.startAction(mContext, getPhotoDetail(newsSummary));
            }
        });
    }

    private NewsPhotoDetail getPhotoDetail(NewsListData.NewsListBean newsSummary) {
        NewsPhotoDetail newsPhotoDetail = new NewsPhotoDetail();
        newsPhotoDetail.setTitle(newsSummary.getNews_title());
        setPictures(newsSummary, newsPhotoDetail);
        return newsPhotoDetail;
    }

    private void setPictures(NewsListData.NewsListBean newsSummary, NewsPhotoDetail newsPhotoDetail) {
        List<NewsPhotoDetail.Picture> pictureList = new ArrayList<>();

        setValuesAndAddToList(pictureList, null, newsSummary.getNews_cover());

        newsPhotoDetail.setPictures(pictureList);
    }

    private void setValuesAndAddToList(List<NewsPhotoDetail.Picture> pictureList, String title, String imgsrc) {
        NewsPhotoDetail.Picture picture = new NewsPhotoDetail.Picture();
        if (title != null) {
            picture.setTitle(title);
        }
        picture.setImgSrc(imgsrc);

        pictureList.add(picture);
    }

    private void setImageView(ViewHolderHelper holder, NewsListData.NewsListBean newsSummary) {
        int PhotoThreeHeight = (int) DisplayUtil.dip2px(90);
        int PhotoTwoHeight = (int) DisplayUtil.dip2px(120);
        int PhotoOneHeight = (int) DisplayUtil.dip2px(150);

        String imgSrcLeft = null;
        String imgSrcMiddle = null;
        String imgSrcRight = null;
        LinearLayout news_summary_photo_iv_group = holder.getView(R.id.news_summary_photo_iv_group);
        ViewGroup.LayoutParams layoutParams = news_summary_photo_iv_group.getLayoutParams();

        imgSrcLeft = newsSummary.getNews_cover();

        layoutParams.height = PhotoOneHeight;


        setPhotoImageView(holder, imgSrcLeft, imgSrcMiddle, imgSrcRight);
        news_summary_photo_iv_group.setLayoutParams(layoutParams);
    }

    private void setPhotoImageView(ViewHolderHelper holder, String imgSrcLeft, String imgSrcMiddle, String imgSrcRight) {
        if (imgSrcLeft != null) {
            holder.setVisible(R.id.news_summary_photo_iv_left, true);
            holder.setImageUrl(R.id.news_summary_photo_iv_left, imgSrcLeft);
        } else {
            holder.setVisible(R.id.news_summary_photo_iv_left, false);
        }
        if (imgSrcMiddle != null) {
            holder.setVisible(R.id.news_summary_photo_iv_middle, true);
            holder.setImageUrl(R.id.news_summary_photo_iv_middle, imgSrcMiddle);
        } else {
            holder.setVisible(R.id.news_summary_photo_iv_middle, false);
        }
        if (imgSrcRight != null) {
            holder.setVisible(R.id.news_summary_photo_iv_right, true);
            holder.setImageUrl(R.id.news_summary_photo_iv_right, imgSrcRight);
        } else {
            holder.setVisible(R.id.news_summary_photo_iv_right, false);
        }
    }
}
