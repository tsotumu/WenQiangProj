package com.macojia.leanproduct.ui.video;

import com.macojia.common.baserx.RxSubscriber;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.bean.video.VideoListEntity;
import com.macojia.leanproduct.constant.AppConstant;

import java.util.List;

import rx.functions.Action1;

/**
 * des:
 * Created by xsf
 * on 2016.09.14:53
 */
public class VideoListPresenter extends VideosListContract.Presenter {

    @Override
    public void onStart() {
        super.onStart();
        //监听返回顶部动作
        mRxManage.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scrolltoTop();
            }
        });
    }

    /**
     * 获取视频列表请求
     *
     * @param type
     * @param startPage
     */
    @Override
    public void getVideosListDataRequest(String type, int startPage) {
        mRxManage.add(mModel.getVideosListData(type, startPage).subscribe(new RxSubscriber<List<VideoListEntity.VideoEntity>>(mContext, false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onNext(List<VideoListEntity.VideoEntity> videoDatas) {
                mView.returnVideosListData(videoDatas);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
