package com.macojia.leanproduct.bean.video;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/26.
 */

public class VideoListEntity {
    public ArrayList<VideoEntity> dataList;

    public static class VideoEntity {
        public String url;
        public String title;
        public String cover;
        public int play_count;
        public String topic_name;
        public String des;
        public String ptime;

        @Override
        public String toString() {
            return url + title;
        }
    }
}
