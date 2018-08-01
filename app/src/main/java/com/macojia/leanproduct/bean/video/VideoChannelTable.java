package com.macojia.leanproduct.bean.video;

/**
 * des:视频分类
 * Created by xsf
 * on 2016.09.14:57
 */
public class VideoChannelTable {
    private String channelId;
    private String channelName;

    public VideoChannelTable(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelId() {
        return channelId;
    }
}
