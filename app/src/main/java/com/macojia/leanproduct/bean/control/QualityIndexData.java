package com.macojia.leanproduct.bean.control;

import java.util.List;

public class QualityIndexData {
    /**
     * MonthlyIndexPerMachine : [{"indexList":[{"key":"2018-09-08","value":98.27},{"key":"2018-09-07","value":98.03},{"key":"2018-09-06","value":97.87},{"key":"2018-09-05","value":97.38},{"key":"2018-09-04","value":97.21},{"key":"2018-09-03","value":98.08}],"machineName":"11号包装机"},{"indexList":[{"key":"2018-09-08","value":98.5},{"key":"2018-09-07","value":98.47},{"key":"2018-09-06","value":97.58},{"key":"2018-09-04","value":97.95},{"key":"2018-09-01","value":97.33}],"machineName":"12号包装机"},{"indexList":[{"key":"2018-09-08","value":93.2},{"key":"2018-09-07","value":95.89},{"key":"2018-09-06","value":96.44},{"key":"2018-09-05","value":96.39},{"key":"2018-09-04","value":96.72},{"key":"2018-09-03","value":96.18}],"machineName":"15号包装机"},{"indexList":[{"key":"2018-09-08","value":96.57},{"key":"2018-09-07","value":96.3},{"key":"2018-09-06","value":97.24},{"key":"2018-09-05","value":96.71},{"key":"2018-09-04","value":97.19},{"key":"2018-09-03","value":95.98}],"machineName":"16号包装机"},{"indexList":[{"key":"2018-09-08","value":96.63},{"key":"2018-09-07","value":97.05},{"key":"2018-09-06","value":97.43},{"key":"2018-09-05","value":95},{"key":"2018-09-04","value":96.98},{"key":"2018-09-03","value":95.86}],"machineName":"17号包装机"},{"indexList":[{"key":"2018-09-08","value":96.36},{"key":"2018-09-07","value":97.24},{"key":"2018-09-06","value":97.35},{"key":"2018-09-05","value":97.57},{"key":"2018-09-04","value":96.38},{"key":"2018-09-03","value":96.65}],"machineName":"18号包装机"},{"indexList":[{"key":"2018-09-08","value":98.11},{"key":"2018-09-07","value":98.85},{"key":"2018-09-06","value":98.81},{"key":"2018-09-05","value":97.24},{"key":"2018-09-03","value":97.06}],"machineName":"1号包装机"},{"indexList":[{"key":"2018-09-08","value":97.93},{"key":"2018-09-07","value":97.75},{"key":"2018-09-06","value":97.38},{"key":"2018-09-05","value":97.38},{"key":"2018-09-03","value":97.5}],"machineName":"2号包装机"},{"indexList":[{"key":"2018-09-08","value":98.35},{"key":"2018-09-07","value":97.85},{"key":"2018-09-06","value":97.88},{"key":"2018-09-05","value":97.52},{"key":"2018-09-03","value":98.63}],"machineName":"3号包装机"},{"indexList":[{"key":"2018-09-08","value":98.18},{"key":"2018-09-07","value":97.39},{"key":"2018-09-06","value":97.6},{"key":"2018-09-03","value":98.33},{"key":"2018-09-02","value":98.77},{"key":"2018-09-01","value":97.81}],"machineName":"4号包装机"},{"indexList":[{"key":"2018-09-08","value":97.17},{"key":"2018-09-07","value":97.3},{"key":"2018-09-06","value":96.47},{"key":"2018-09-05","value":98.19},{"key":"2018-09-04","value":96.88},{"key":"2018-09-03","value":95.6}],"machineName":"5号包装机"},{"indexList":[{"key":"2018-09-08","value":98.3},{"key":"2018-09-07","value":97.11},{"key":"2018-09-06","value":97.52},{"key":"2018-09-05","value":97.73},{"key":"2018-09-04","value":98.11},{"key":"2018-09-03","value":98.03}],"machineName":"6号包装机"},{"indexList":[{"key":"2018-09-08","value":96.52},{"key":"2018-09-07","value":97.82},{"key":"2018-09-06","value":97.62},{"key":"2018-09-05","value":97.36},{"key":"2018-09-04","value":97.8},{"key":"2018-09-03","value":97.3}],"machineName":"7号包装机"},{"indexList":[{"key":"2018-09-08","value":97.1},{"key":"2018-09-07","value":97.66},{"key":"2018-09-05","value":96.85},{"key":"2018-09-04","value":98.8},{"key":"2018-09-03","value":97.13},{"key":"2018-09-02","value":96.99}],"machineName":"8号包装机"}]
     * machineIndex : [{"key":"11号包装机","value":97.8375},{"key":"12号包装机","value":97.966},{"key":"15号包装机","value":95.91375},{"key":"16号包装机","value":96.65},{"key":"17号包装机","value":96.57},{"key":"18号包装机","value":96.83375},{"key":"1号包装机","value":98.014},{"key":"2号包装机","value":97.588},{"key":"3号包装机","value":98.046},{"key":"4号包装机","value":98.013333},{"key":"5号包装机","value":96.98375},{"key":"6号包装机","value":97.78},{"key":"7号包装机","value":97.2425},{"key":"8号包装机","value":97.145714}]
     * machineTitle : 2018-09开动各机组质量平均得分图示
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
         * indexList : [{"key":"2018-09-08","value":98.27},{"key":"2018-09-07","value":98.03},{"key":"2018-09-06","value":97.87},{"key":"2018-09-05","value":97.38},{"key":"2018-09-04","value":97.21},{"key":"2018-09-03","value":98.08}]
         * machineName : 11号包装机
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
             * key : 2018-09-08
             * value : 98.27
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
         * key : 11号包装机
         * value : 97.8375
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
