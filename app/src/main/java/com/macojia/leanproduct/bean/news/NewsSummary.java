/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.macojia.leanproduct.bean.news;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * des:新闻消息实体类
 * Created by xsf
 * on 2016.06.13:05
 */
public class NewsSummary implements Parcelable {
    public static final Parcelable.Creator<NewsSummary> CREATOR = new Parcelable.Creator<NewsSummary>() {
        @Override
        public NewsSummary createFromParcel(Parcel source) {
            return new NewsSummary(source);
        }

        @Override
        public NewsSummary[] newArray(int size) {
            return new NewsSummary[size];
        }
    };
    private int id;
    private String news_digest;
    private String news_title;
    private String news_cover;
    private String news_datetime;

    /**
     * title : "悬崖村" 孩子上学需爬800米悬崖
     * tag : photoset
     * imgsrc : http://img1.cache.netease.com/3g/2016/5/24/2016052421435478ea5.jpg
     * subtitle :
     * url : 00AP0001|119327
     */

    private List<AdsBean> ads;
    /**
     * imgsrc : http://img3.cache.netease.com/3g/2016/5/24/2016052416484243560.jpg
     */

    private List<ImgextraBean> imgextra;

    public NewsSummary() {
    }

    protected NewsSummary(Parcel in) {
        this.id = in.readInt();
        this.news_digest=in.readString();
        this.news_title=in.readString();
        this.news_cover=in.readString();
        this.news_datetime=in.readString();
        this.ads = new ArrayList<AdsBean>();
        in.readList(this.ads, AdsBean.class.getClassLoader());
        this.imgextra = new ArrayList<ImgextraBean>();
        in.readList(this.imgextra, ImgextraBean.class.getClassLoader());
    }

    @Override
    public String toString() {
        return "news: title->" + news_title + " digest->" + news_digest + " imgSrc->" + news_cover + " postId->" + id + " postTime->" + news_datetime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews_digest() {
        return news_digest;
    }

    public void setNews_digest(String news_digest) {
        this.news_digest = news_digest;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_cover() {
        return news_cover;
    }

    public void setNews_cover(String news_cover) {
        this.news_cover = news_cover;
    }

    public String getNews_datetime() {
        return news_datetime;
    }

    public void setNews_datetime(String news_datetime) {
        this.news_datetime = news_datetime;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.news_cover);
        dest.writeString(this.news_datetime);
        dest.writeString(this.news_digest);
        dest.writeString(this.news_title);
        dest.writeList(this.ads);
        dest.writeList(this.imgextra);
    }

    public static class AdsBean {
        private String title;
        private String tag;
        private String imgsrc;
        private String subtitle;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImgextraBean {
        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
