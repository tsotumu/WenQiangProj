package com.macojia.leanproduct.bean.news;

import java.util.List;

public class NewsListData {

    private List<NewsListBean> newsList;

    public List<NewsListBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListBean> newsList) {
        this.newsList = newsList;
    }

    public static class NewsListBean {
        @Override
        public String toString() {
            return "id->" + id + " title->" +news_title + " digest->" +news_digest;
        }

        /**
         * id : 48
         * news_title : 生产1
         * news_digest : 生产1生产1生产1
         * news_content :
         * news_category : 生产
         * news_datetime : 2018-09-01 17:43:45
         * news_cover : http://118.190.153.47:8080/LPCMS/upload/image/1533364335957032220.png
         * img : null
         */

        private int id;
        private String news_title;
        private String news_digest;
        private String news_content;
        private String news_category;
        private String news_datetime;
        private String news_cover;
        private Object img;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_digest() {
            return news_digest;
        }

        public void setNews_digest(String news_digest) {
            this.news_digest = news_digest;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
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

        public String getNews_cover() {
            return news_cover;
        }

        public void setNews_cover(String news_cover) {
            this.news_cover = news_cover;
        }

        public Object getImg() {
            return img;
        }

        public void setImg(Object img) {
            this.img = img;
        }
    }
}
