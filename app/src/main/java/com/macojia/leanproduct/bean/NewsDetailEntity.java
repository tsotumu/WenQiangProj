package com.macojia.leanproduct.bean;

import java.util.ArrayList;

/**
 * Created by LC on 2018/7/16.
 */

public class NewsDetailEntity {
    public String title;
    public String body;
    public String source;
    public String postTime;
    public ArrayList<ImgData> img;

    public static class ImgData{
        public String ref;
        public String src;
        public String alt;
        public String pixel;
    }
}
