package com.macojia.leanproduct.bean.news;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NewsType {
    @StringDef({NewsType.NEWS_TYPE.dangjian, NewsType.NEWS_TYPE.shengchan, NewsType.NEWS_TYPE.xianchang})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NEWS_TYPE{
        String dangjian = "dangjian";
        String shengchan = "shengchan";
        String xianchang = "xianchang";
    }
}
