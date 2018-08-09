package com.macojia.leanproduct.ui.video;

import com.macojia.common.base.BaseModel;
import com.macojia.common.base.BasePresenter;
import com.macojia.common.base.BaseView;
import com.macojia.leanproduct.bean.video.VideoListEntity;

import java.util.List;

import rx.Observable;

/**
 * des:视频列表contract
 * Created by xsf
 * on 2016.09.14:38
 */
public interface VideosListContract {
    interface Model extends BaseModel {
        //请求获取视频
        Observable<List<VideoListEntity.VideoEntity>> getVideosListData(String type, int startPage);
    }

    interface View extends BaseView {
        //返回获取的视频
        void returnVideosListData(List<VideoListEntity.VideoEntity> newsSummaries);

        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取视频请求
        public abstract void getVideosListDataRequest(String type, int startPage);
    }
}
