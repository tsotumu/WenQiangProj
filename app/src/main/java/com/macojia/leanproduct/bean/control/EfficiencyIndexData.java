package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class EfficiencyIndexData {
    /**
     * MonthlyIndexPerMachine : [{"indexList":[{"key":"2018-09","value":98.87},{"key":"2018-08","value":97.95},{"key":"2018-07","value":97.34},{"key":"2018-06","value":98.35},{"key":"2018-05","value":98.62},{"key":"2018-04","value":98.1}],"machineName":"2号包装机"},{"indexList":[{"key":"2018-09","value":89.75},{"key":"2018-08","value":91.08},{"key":"2018-07","value":93.81},{"key":"2018-06","value":94.29},{"key":"2018-05","value":98.05},{"key":"2018-04","value":97.29}],"machineName":"3号包装机"},{"indexList":[{"key":"2018-09","value":97.99},{"key":"2018-08","value":97.82},{"key":"2018-07","value":97.19},{"key":"2018-06","value":98.45},{"key":"2018-05","value":97.89},{"key":"2018-04","value":98.59}],"machineName":"1号包装机"},{"indexList":[{"key":"2018-09","value":97.99},{"key":"2018-08","value":98.7},{"key":"2018-07","value":96.97},{"key":"2018-06","value":90.55},{"key":"2018-05","value":89.21},{"key":"2018-04","value":91.49}],"machineName":"5号包装机"},{"indexList":[{"key":"2018-09","value":98.18},{"key":"2018-08","value":98.49},{"key":"2018-07","value":98.54},{"key":"2018-06","value":98.79},{"key":"2018-05","value":98.58},{"key":"2018-04","value":97.64}],"machineName":"4号包装机"}]
     * machineIndex : [{"key":"2号包装机","value":98.87},{"key":"3号包装机","value":89.75},{"key":"1号包装机","value":97.99},{"key":"5号包装机","value":97.99},{"key":"4号包装机","value":98.18}]
     * machineTitle : 2018-09开动各机组效率指标图示
     */

    private String machineTitle;
    private List<MonthlyIndexPerMachineBean> MonthlyIndexPerMachine;
    private List<MachineIndexBean> machineIndex;

    public String getMachineTitle() {
        return machineTitle;
    }

    public void setMachineTitle(String machineTitle) {
        this.machineTitle = machineTitle;
    }

    public List<MonthlyIndexPerMachineBean> getMonthlyIndexPerMachine() {
        return MonthlyIndexPerMachine;
    }

    public void setMonthlyIndexPerMachine(List<MonthlyIndexPerMachineBean> MonthlyIndexPerMachine) {
        this.MonthlyIndexPerMachine = MonthlyIndexPerMachine;
    }

    public List<MachineIndexBean> getMachineIndex() {
        return machineIndex;
    }

    public void setMachineIndex(List<MachineIndexBean> machineIndex) {
        this.machineIndex = machineIndex;
    }

    public static class MonthlyIndexPerMachineBean {
        /**
         * indexList : [{"key":"2018-09","value":98.87},{"key":"2018-08","value":97.95},{"key":"2018-07","value":97.34},{"key":"2018-06","value":98.35},{"key":"2018-05","value":98.62},{"key":"2018-04","value":98.1}]
         * machineName : 2号包装机
         */

        private String machineName;
        private List<IndexListBean> indexList;

        public String getMachineName() {
            return machineName;
        }

        public void setMachineName(String machineName) {
            this.machineName = machineName;
        }

        public List<IndexListBean> getIndexList() {
            return indexList;
        }

        public void setIndexList(List<IndexListBean> indexList) {
            this.indexList = indexList;
        }

        public static class IndexListBean {
            /**
             * key : 2018-09
             * value : 98.87
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

    public static class MachineIndexBean {
        /**
         * key : 2号包装机
         * value : 98.87
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
