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
    private String body;
    private String shareLink;
    private String title;
    private String source;
    private String ptime;
    private List<ImgBean> img;

    @Override
    public String toString() {
        return "title->" + title + " source->" + getSource() + " postTime->" + ptime + " body->" + body + " imgSrc->" + img;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShareLink() {
        return shareLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
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