package com.macojia.leanproduct.ui.video;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonutils.TimeUtil;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.bean.video.VideoListEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Observable<Map<String, List<VideoListEntity.VideoEntity>>> videoListMap = NetworkManager.getDefault(HostType.NETEASE_NEWS_VIDEO).getVideoList(NetworkManager.getCacheControl(), type, startPage);
        return videoListMap.flatMap(new Func1<Map<String, List<VideoListEntity.VideoEntity>>, Observable<VideoListEntity.VideoEntity>>() {
            @Override
            public Observable<VideoListEntity.VideoEntity> call(final Map<String, List<VideoListEntity.VideoEntity>> map) {
                        if (BuildConfig.DEBUG) {
                            VideoListEntity newsListEntity = base.utils.JsonUtils.analysisNewsJsonFile(VideoListEntity.class, "video_list_data");
                            if (BuildConfig.DEBUG)
                                LogUtils.logd("aasfasfdasfdasdfasdf" + newsListEntity.dataList.toString());
                            final List<VideoListEntity.VideoEntity> videoDataList = new ArrayList<>();
                            for (int i = 0; i < newsListEntity.dataList.size(); i++) {
                                VideoListEntity.VideoEntity videoData = new VideoListEntity.VideoEntity();
                                videoData.cover = newsListEntity.dataList.get(i).cover;
                                videoData.des = (newsListEntity.dataList.get(i).des);
                                videoData.play_count = (newsListEntity.dataList.get(i).play_count);
                                videoData.title = (newsListEntity.dataList.get(i).title);
                                videoData.topic_name = (newsListEntity.dataList.get(i).topic_name);
                                videoData.url = (newsListEntity.dataList.get(i).url);
                                videoData.ptime = (newsListEntity.dataList.get(i).ptime);
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
                        String ptime = TimeUtil.formatDate(videoData.ptime);
                        videoData.ptime = ptime;
                        return videoData;
                    }
                })
                .distinct()//去重
                .toSortedList(new Func2<VideoListEntity.VideoEntity, VideoListEntity.VideoEntity, Integer>() {
                    @Override
                    public Integer call(VideoListEntity.VideoEntity videoData, VideoListEntity.VideoEntity videoData2) {
                        return videoData2.ptime.compareTo(videoData.ptime);
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<VideoListEntity.VideoEntity>>io_main());
    }
}
