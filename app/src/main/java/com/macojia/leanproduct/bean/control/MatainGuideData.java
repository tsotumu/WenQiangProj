package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by Administrator on 2018/8/8.
 */

public class MatainGuideData {

    private List<MaintainDataListBean> maintainDataList;

    public List<MaintainDataListBean> getMaintainDataList() {
        return maintainDataList;
    }

    public void setMaintainDataList(List<MaintainDataListBean> maintainDataList) {
        this.maintainDataList = maintainDataList;
    }

    public static class MaintainDataListBean {
        /**
         * data : [{"key":"tst3","value":15},{"key":"tst1","value":31},{"key":"tst2","value":12}]
         * machineName : 17号卷烟机
         */

        private String machineName;
        private List<DataBean> data;

        public String getMachineName() {
            return machineName;
        }

        public void setMachineName(String machineName) {
            this.machineName = machineName;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * key : tst3
             * value : 15
             */

            private String key;
            private int value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
