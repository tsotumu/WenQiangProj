package com.macojia.leanproduct.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.macojia.common.base.BaseFragment;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonwidget.LoadingTip;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.video.VideoListEntity;
import com.macojia.leanproduct.constant.AppConstant;

import java.util.List;

import base.utils.DebugUtil;
import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * des:视频fragment
 * Created by xsf
 * on 2016.09.17:30
 */
public class VideoChildFragment extends BaseFragment<VideoListPresenter, VideosListModel> implements VideosListContract.View, OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    private CommonRecycleViewAdapter<VideoListEntity.DataListBean> videoListAdapter;
    public final static String EXTRA_TYPE = "type";
    private String extra_type;

    private String mVideoType;
    private int mStartPage = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.child_fragment;
    }

    @Override
    public void initPresenter() {
        mPresenter.setView_Model(this, mModel);
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            mVideoType = getArguments().getString(AppConstant.VIDEO_TYPE);
            extra_type = getArguments().getString(EXTRA_TYPE);
        }
        irc.setLayoutManager(new LinearLayoutManager(getContext()));
        videoListAdapter = new CommonRecycleViewAdapter<VideoListEntity.DataListBean>(getContext(), R.layout.item_video_list) {
            @Override
            public void convert(ViewHolderHelper helper, VideoListEntity.DataListBean videoData) {
//                helper.setImageRoundUrl(R.id.iv_logo, videoData.getTopicImg());
                helper.setText(R.id.tv_from, videoData.getVideo_topic());
                helper.setText(R.id.tv_play_time, String.format(getResources().getString(R.string.video_play_times), String.valueOf(videoData.getPlay_count())));
                JCVideoPlayerStandard jcVideoPlayerStandard = helper.getView(R.id.videoplayer);
                boolean setUp = jcVideoPlayerStandard.setUp(
                        videoData.getVideo_url(), JCVideoPlayer.SCREEN_LAYOUT_LIST,
                        TextUtils.isEmpty(videoData.getVideo_digest()) ? videoData.getVideo_title() + "" : videoData.getVideo_digest());
                if (setUp) {
                    Glide.with(mContext).load(videoData.getVideo_cover())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                            .error(com.macojia.common.R.drawable.ic_empty_picture)
                            .crossFade().into(jcVideoPlayerStandard.thumbImageView);
                }
            }
        };
        irc.setAdapter(videoListAdapter);
        irc.setOnRefreshListener(this);
        irc.setOnLoadMoreListener(this);
        //视频监听
        irc.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if (JCVideoPlayerManager.listener() != null) {
                    JCVideoPlayer videoPlayer = (JCVideoPlayer) JCVideoPlayerManager.listener();
                    if (((ViewGroup) view).indexOfChild(videoPlayer) != -1 && videoPlayer.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING) {
                        JCVideoPlayer.releaseAllVideos();
                    }
                }
            }
        });
        //数据为空才重新发起请求
        if (DebugUtil.DEBUG || videoListAdapter.getSize() <= 0) {
            //发起请求
            mStartPage = 0;
            mPresenter.getVideosListDataRequest(mVideoType, mStartPage);
            LogUtils.logd(extra_type + "->getVideosListDataRequest" );
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void returnVideosListData(VideoListEntity videoDatas) {
        if (videoDatas != null) {
            mStartPage += 1;
            if (videoListAdapter.getPageBean().isRefresh()) {
                irc.setRefreshing(false);
                videoListAdapter.replaceAll(videoDatas.getDataList());
            } else {
                if (videoDatas.getDataList().size() > 0) {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                    videoListAdapter.addAll(videoDatas.getDataList());
                } else {
                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                }
            }
        }
    }

    /**
     * 返回顶部
     */
    @Override
    public void scrolltoTop() {
        irc.smoothScrollToPosition(0);
    }

    @Override
    public void onRefresh() {
        videoListAdapter.getPageBean().setRefresh(true);
        mStartPage = 0;
        //发起请求
        irc.setRefreshing(true);
        mPresenter.getVideosListDataRequest(mVideoType, mStartPage);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        videoListAdapter.getPageBean().setRefresh(false);
        //发起请求
        irc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        mPresenter.getVideosListDataRequest(mVideoType, mStartPage);
    }

    @Override
    public void showLoading(String title) {
        if (videoListAdapter.getPageBean().isRefresh()) {
            if (videoListAdapter.getSize() <= 0) {
                loadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            }
        }
    }

    @Override
    public void stopLoading() {
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override
    public void showErrorTip(String msg) {
        if (videoListAdapter.getPageBean().isRefresh()) {
            if (videoListAdapter.getSize() <= 0) {
                loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
                loadedTip.setTips(msg);
                irc.setRefreshing(false);
            }
        } else {
            irc.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
        }
    }


}
