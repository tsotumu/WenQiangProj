package com.macojia.leanproduct.bean.control;

import java.util.List;

public class ForcastData {

    /**
     * ProgressTitle : 2018年10月产品进度预测图示
     * dataList : [{"key":"泰山（八喜）","value":98.8},{"key":"泰山（望岳）","value":37.43},{"key":"泰山（硬红）","value":50},{"key":"泰山（东方）","value":25},{"key":"哈德门（金典）","value":0},{"key":"哈德门（壹）号","value":57.5},{"key":"南京（红）","value":0}]
     */

    private String ProgressTitle;
    private List<DataListBean> dataList;

    public String getProgressTitle() {
        return ProgressTitle;
    }

    public void setProgressTitle(String ProgressTitle) {
        this.ProgressTitle = ProgressTitle;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * key : 泰山（八喜）
         * value : 98.8
         */

        private String key;
        private double value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
