package com.macojia.leanproduct.bean.video;

import java.util.List;

/**
 * Created by LC on 2018/7/26.
 */

public class VideoListEntity {
    private List<DataListBean> dataList;

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * id : 33
         * video_title : 安全12
         * video_digest : 安全12安全12
         * video_topic : 安全
         * video_cover : http://118.190.153.47:8080/LPCMS/upload/image/1533364335957032220.png
         * video_ptime : 2018-09-08 21:19:18
         * video_url : http://118.190.153.47:8080/LPCMS/upload/file/1533383961324040948.mp4
         * play_count : 0
         */

        private int id;
        private String video_title;
        private String video_digest;
        private String video_topic;
        private String video_cover;
        private String video_ptime;
        private String video_url;
        private int play_count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVideo_title() {
            return video_title;
        }

        public void setVideo_title(String video_title) {
            this.video_title = video_title;
        }

        public String getVideo_digest() {
            return video_digest;
        }

        public void setVideo_digest(String video_digest) {
            this.video_digest = video_digest;
        }

        public String getVideo_topic() {
            return video_topic;
        }

        public void setVideo_topic(String video_topic) {
            this.video_topic = video_topic;
        }

        public String getVideo_cover() {
            return video_cover;
        }

        public void setVideo_cover(String video_cover) {
            this.video_cover = video_cover;
        }

        public String getVideo_ptime() {
            return video_ptime;
        }

        public void setVideo_ptime(String video_ptime) {
            this.video_ptime = video_ptime;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }
    }

}
