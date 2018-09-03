package com.macojia.leanproduct.ui.news.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.macojia.common.base.BaseFragment;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonwidget.LoadingTip;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.news.NewsListData;
import com.macojia.leanproduct.bean.news.NewsSummary;
import com.macojia.leanproduct.constant.AppConstant;
import com.macojia.leanproduct.ui.news.adapter.NewsListAdapter;
import com.macojia.leanproduct.ui.news.contract.NewsListContract;
import com.macojia.leanproduct.ui.news.model.NewsListModel;
import com.macojia.leanproduct.ui.news.presenter.NewsListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * des:新闻fragment
 * Created by xsf
 * on 2016.09.17:30
 */
public class NewsChildFragment extends BaseFragment<NewsListPresenter, NewsListModel> implements NewsListContract.View, OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.irc)
    IRecyclerView mRecylerView;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    private NewsListAdapter newListAdapter;
    private List<NewsListData.NewsListBean> mNewsDataList = new ArrayList<>();

    private String mNewsId;
    private String mNewsType;
    private int mStartPage = 0;

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    private boolean isVisible;

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
            mNewsId = getArguments().getString(AppConstant.NEWS_ID);
            mNewsType = getArguments().getString(AppConstant.NEWS_TYPE);
        }
        mRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsDataList.clear();
        newListAdapter = new NewsListAdapter(getContext(), mNewsDataList);
        newListAdapter.openLoadAnimation(new ScaleInAnimation());
        mRecylerView.setAdapter(newListAdapter);
        mRecylerView.setOnRefreshListener(this);
        mRecylerView.setOnLoadMoreListener(this);
        //数据为空才重新发起请求
        if (newListAdapter.getSize() <= 0) {
            mStartPage = 0;
            mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
        }
    }


    @Override
    public void OnNewsListDataReturned(NewsListData newsSummaries) {
        LogUtils.logd("OnNewsListDataReturned, newsId->" + mNewsId + " newsType->"+mNewsType + " newsSummary:\n" + newsSummaries.getNewsList());
        if (newsSummaries != null) {
            mStartPage += 20;
            if (newListAdapter.getPageBean().isRefresh()) {
                mRecylerView.setRefreshing(false);
                newListAdapter.replaceAll(newsSummaries.getNewsList());
            } else {
                if (newsSummaries.getNewsList().size() > 0) {
                    mRecylerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                    newListAdapter.addAll(newsSummaries.getNewsList());
                } else {
                    mRecylerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                }
            }
        }
    }

    /**
     * 返回顶部
     */
    @Override
    public void scrolltoTop() {
        mRecylerView.smoothScrollToPosition(0);
    }

    @Override
    public void onRefresh() {
        newListAdapter.getPageBean().setRefresh(true);
        mStartPage = 0;
        //发起请求
        mRecylerView.setRefreshing(true);
        mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        newListAdapter.getPageBean().setRefresh(false);
        //发起请求
        mRecylerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        mPresenter.getNewsListDataRequest(mNewsType, mNewsId, mStartPage);
    }

    @Override
    public void showLoading(String title) {
        if (newListAdapter.getPageBean().isRefresh()) {
            if (newListAdapter.getSize() <= 0) {
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
        if (newListAdapter.getPageBean().isRefresh()) {
            if (newListAdapter.getSize() <= 0) {
                loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
                loadedTip.setTips(msg);
            }
            mRecylerView.setRefreshing(false);
        } else {
            mRecylerView.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
        }
    }

}
