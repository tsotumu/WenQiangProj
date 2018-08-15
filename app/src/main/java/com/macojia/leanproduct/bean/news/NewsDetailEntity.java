package com.macojia.leanproduct.bean.news;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/16.
 */

public class NewsDetailEntity {
    public String news_title;
    public String news_content;
    public String news_category;
    public String news_datetime;
    public ArrayList<ImgBean> img;

    public static class ImgBean {
        public String ref;
        public String src;
        public String alt;
        public String pixel;
    }
}
