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
    public Observable<List<VideoListEntity.VideoEntity>> getVideosListData(final String type, int startPage) {
        Observable<Map<String, List<VideoListEntity.VideoEntity>>> videoListMap = NetworkManager.getDefault(0).getVideoList(NetworkManager.getCacheControl(), type, startPage);
        return videoListMap.flatMap(new Func1<Map<String, List<VideoListEntity.VideoEntity>>, Observable<VideoListEntity.VideoEntity>>() {
            @Override
            public Observable<VideoListEntity.VideoEntity> call(final Map<String, List<VideoListEntity.VideoEntity>> map) {
                        if (DebugUtil.DEBUG) {
                            VideoListEntity newsListEntity = base.utils.JsonUtils.analysisNewsJsonFile(VideoListEntity.class, "video_list_data");
                            if (DebugUtil.DEBUG)
                                LogUtils.logd("aasfasfdasfdasdfasdf" + newsListEntity.dataList.toString());
                            final List<VideoListEntity.VideoEntity> videoDataList = new ArrayList<>();
                            for (int i = 0; i < newsListEntity.dataList.size(); i++) {
                                VideoListEntity.VideoEntity videoData = new VideoListEntity.VideoEntity();
                                videoData.video_cover = newsListEntity.dataList.get(i).video_cover;
                                videoData.video_digest = (newsListEntity.dataList.get(i).video_digest);
                                videoData.play_count = (newsListEntity.dataList.get(i).play_count);
                                videoData.video_title = (newsListEntity.dataList.get(i).video_title);
                                videoData.video_topic = (newsListEntity.dataList.get(i).video_topic);
                                videoData.video_url = (newsListEntity.dataList.get(i).video_url);
                                videoData.video_ptime = (newsListEntity.dataList.get(i).video_ptime);
                                videoDataList.add(videoData);
                            }

                            return Observable.from(videoDataList);
                        }else {
                            return Observable.create(new Observable.OnSubscribe<VideoListEntity.VideoEntity>() {
                                @Override
                                public void call(Subscriber<? super VideoListEntity.VideoEntity> subscriber) {
                                    subscriber.onCompleted();
                                }
                            });
                        }}

        })
                //转化时间
                .map(new Func1<VideoListEntity.VideoEntity, VideoListEntity.VideoEntity>() {
                    @Override
                    public VideoListEntity.VideoEntity call(VideoListEntity.VideoEntity videoData) {
                        String ptime = TimeUtil.formatDate(videoData.video_ptime);
                        videoData.video_ptime = ptime;
                        return videoData;
                    }
                })
                .distinct()//去重
                .toSortedList(new Func2<VideoListEntity.VideoEntity, VideoListEntity.VideoEntity, Integer>() {
                    @Override
                    public Integer call(VideoListEntity.VideoEntity videoData, VideoListEntity.VideoEntity videoData2) {
                        return videoData2.video_ptime.compareTo(videoData.video_ptime);
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<VideoListEntity.VideoEntity>>io_main());
    }
}
