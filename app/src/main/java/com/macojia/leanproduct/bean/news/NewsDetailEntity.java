package com.macojia.leanproduct.bean.news;

import java.util.List;

/**
 * Created by LC on 2018/7/16.
 */

public class NewsDetailEntity {


    /**
     * id : 111
     * news_title : 设备7
     * news_digest : 设备7设备7设备7
     * news_content :  我认为热无若翁任务我认为热无若温柔我然而让热啊爱人啊啊  1533364746837092968.png
     * news_category : 设备
     * news_datetime : 2018-09-17 16:07:24
     * news_cover : http://118.190.153.47:8080/LPCMS/upload/image/1533364754029041053.png
     * img : [{"ref":null,"src":"http://118.190.153.47:8080/LPCMS/upload/image/1533364746837092968.png","alt":null,"pixel":null}]
     */

    private int id;
    private String news_title;
    private String news_digest;
    private String news_content;
    private String news_category;
    private String news_datetime;
    private String news_cover;
    private List<ImgBean> img;

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

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public static class ImgBean {
        /**
         * ref : null
         * src : http://118.190.153.47:8080/LPCMS/upload/image/1533364746837092968.png
         * alt : null
         * pixel : null
         */

        private Object ref;
        private String src;
        private Object alt;
        private Object pixel;

        public Object getRef() {
            return ref;
        }

        public void setRef(Object ref) {
            this.ref = ref;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Object getAlt() {
            return alt;
        }

        public void setAlt(Object alt) {
            this.alt = alt;
        }

        public Object getPixel() {
            return pixel;
        }

        public void setPixel(Object pixel) {
            this.pixel = pixel;
        }
    }
}
