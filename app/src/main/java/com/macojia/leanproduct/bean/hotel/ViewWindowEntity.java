package com.macojia.leanproduct.bean.hotel;

import java.util.List;

/**
 * Created by lyd10892 on 2016/8/23.
 */

public class ViewWindowEntity {

    private List<AllTagsListBean> allTagsList;

    public List<AllTagsListBean> getAllTagsList() {
        return allTagsList;
    }

    public void setAllTagsList(List<AllTagsListBean> allTagsList) {
        this.allTagsList = allTagsList;
    }

    public static class AllTagsListBean {
        /**
         * atiList : [{"tagId":11,"tagName":"车间概况"},{"tagId":12,"tagName":"车间荣誉"},{"tagId":13,"tagName":"车间布局"}]
         * tagsName : 车间简介
         */

        private String tagsName;
        private List<AtiListBean> atiList;

        public String getTagsName() {
            return tagsName;
        }

        public void setTagsName(String tagsName) {
            this.tagsName = tagsName;
        }

        public List<AtiListBean> getAtiList() {
            return atiList;
        }

        public void setAtiList(List<AtiListBean> atiList) {
            this.atiList = atiList;
        }

        public static class AtiListBean {
            /**
             * tagId : 11
             * tagName : 车间概况
             */

            private int tagId;
            private String tagName;

            public int getTagId() {
                return tagId;
            }

            public void setTagId(int tagId) {
                this.tagId = tagId;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }
        }
    }
}
