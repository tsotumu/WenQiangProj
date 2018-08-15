package com.macojia.leanproduct.bean.video;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/26.
 */

public class VideoListEntity {
    public ArrayList<VideoEntity> dataList;

    public static class VideoEntity {
        public String video_url;;
        public String video_title;;
        public String video_cover;;
        public int play_count;
        public String video_topic;;
        public String video_digest;;
        public String video_ptime;;

        @Override
        public String toString() {
            return video_url + video_title;
        }
    }
}
