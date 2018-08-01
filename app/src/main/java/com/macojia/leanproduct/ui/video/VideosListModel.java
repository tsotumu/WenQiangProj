package com.macojia.leanproduct.ui.video;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.common.commonutils.TimeUtil;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.bean.video.VideoData;
import com.macojia.leanproduct.pojo.VideoListEntity;

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
    public Observable<List<VideoData>> getVideosListData(final String type, int startPage) {
        Observable<Map<String, List<VideoData>>> videoListMap = NetworkManager.getDefault(HostType.NETEASE_NEWS_VIDEO).getVideoList(NetworkManager.getCacheControl(), type, startPage);
        return videoListMap.flatMap(new Func1<Map<String, List<VideoData>>, Observable<VideoData>>() {
            @Override
            public Observable<VideoData> call(final Map<String, List<VideoData>> map) {
                        if (BuildConfig.DEBUG) {
                            VideoListEntity newsListEntity = base.utils.JsonUtils.analysisNewsJsonFile(VideoListEntity.class, "video_list_data");
                            if (BuildConfig.DEBUG)
                                LogUtils.logd("aasfasfdasfdasdfasdf" + newsListEntity.dataList.toString());
                            final List<VideoData> videoDataList = new ArrayList<>();
                            for (int i = 0; i < newsListEntity.dataList.size(); i++) {
                                VideoData videoData = new VideoData();
                                videoData.setCover(newsListEntity.dataList.get(i).cover);
                                videoData.setDescription(newsListEntity.dataList.get(i).des);
                                videoData.setPlayCount(newsListEntity.dataList.get(i).play_count);
                                videoData.setTitle(newsListEntity.dataList.get(i).title);
                                videoData.setTopicName(newsListEntity.dataList.get(i).topic_name);
                                videoData.setMp4_url(newsListEntity.dataList.get(i).url);
                                videoData.setPtime(newsListEntity.dataList.get(i).ptime);
                                videoDataList.add(videoData);
                            }

                            return Observable.from(videoDataList);
                        }else {
                            return Observable.create(new Observable.OnSubscribe<VideoData>() {
                                @Override
                                public void call(Subscriber<? super VideoData> subscriber) {
                                    subscriber.onCompleted();
                                }
                            });
                        }}

        })
                //转化时间
                .map(new Func1<VideoData, VideoData>() {
                    @Override
                    public VideoData call(VideoData videoData) {
                        String ptime = TimeUtil.formatDate(videoData.getPtime());
                        videoData.setPtime(ptime);
                        return videoData;
                    }
                })
                .distinct()//去重
                .toSortedList(new Func2<VideoData, VideoData, Integer>() {
                    @Override
                    public Integer call(VideoData videoData, VideoData videoData2) {
                        return videoData2.getPtime().compareTo(videoData.getPtime());
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<VideoData>>io_main());
    }
}
