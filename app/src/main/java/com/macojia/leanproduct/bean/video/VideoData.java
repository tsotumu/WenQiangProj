package com.macojia.leanproduct.bean.video;

/**
 * des:视频
 */
public class VideoData {

    private String topicImg;
    private String cover;
    private String title;
    private int playCount;
    private String description;
    private String mp4_url;
    private String ptime;
    private String topicName;

    @Override
    public String toString() {
        return "title->" + getTitle() + " playCount->" + getPlayCount() + " des->" + getDescription() + " url->" + getMp4_url() + " topicName->" + getTopicName() + " cover->" + getCover();
    }

    public String getTopicImg() {
        return topicImg;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
