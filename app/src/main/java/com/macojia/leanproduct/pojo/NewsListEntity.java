package com.macojia.leanproduct.pojo;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/16.
 * 消息列表类，用于解析Json数据。
 */

public class NewsListEntity {
    public ArrayList<NewsDigest> newsList;

    public static class NewsDigest {
        public String title;
        public String digest;
        public String imgSrc;
        public String postId;
        public String postTime;
    }

}
