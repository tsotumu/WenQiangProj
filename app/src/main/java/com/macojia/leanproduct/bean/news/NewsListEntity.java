package com.macojia.leanproduct.bean.news;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/16.
 * 消息列表类，用于解析Json数据。
 */

public class NewsListEntity {
    public ArrayList<NewsDigest> newsList;

    public static class NewsDigest {
        public String news_title;
        public String news_digest;
        public String news_cover;
        public int id;
        public String news_datetime;
    }

}
