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

import java.util.List;

public class NewsDetail {
    private String news_content;
    private String news_title;
    private String news_category;
    private String news_datetime;
    private List<ImgBean> img;

    @Override
    public String toString() {
        return "title->" + news_title + " source->" +news_category + " postTime->" + news_datetime + " body->" + news_content + " imgSrc->" + img;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_category() {
        return news_category;
    }

    public void setNews_category(String news_category) {
        this.news_category = news_category;
    }

    public String getNews_datetime() {
        return news_datetime;
    }

    public void setNews_datetime(String news_datetime) {
        this.news_datetime = news_datetime;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public static class ImgBean {
        private String ref;
        private String pixel;
        private String alt;
        private String src;

        @Override
        public String toString() {
            return "ref->" + ref + " pixel->" + pixel + " alt->" + alt + " src->" + src;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}