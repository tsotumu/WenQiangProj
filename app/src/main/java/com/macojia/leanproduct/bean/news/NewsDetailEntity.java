package com.macojia.leanproduct.bean.news;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/16.
 */

public class NewsDetailEntity {
    public String title;
    public String body;
    public String source;
    public String postTime;
    public ArrayList<ImgBean> img;

    public static class ImgBean {
        public String ref;
        public String src;
        public String alt;
        public String pixel;
    }
}