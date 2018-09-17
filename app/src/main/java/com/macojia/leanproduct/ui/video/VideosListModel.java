package com.macojia.leanproduct.ui.video;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonutils.TimeUtil;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.bean.video.VideoListEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.utils.DebugUtil;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * des:视频列表model
 * Created by xsf
 * on 2016.09.14:54
 */
public class VideosListModel implements VideosListContract.Model {

    @Override
    public Observable<VideoListEntity> getVideosListData(final String type, int startPage) {
        return NetworkManager.getDefault(0).getVideoList(startPage, type);
    }
}
