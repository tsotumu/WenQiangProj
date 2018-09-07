package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class YieldIndexData {
    private List<MonthlyIndexPerMachineBean> MonthlyIndexPerMachine;
    private List<MachineIndexBean> machineIndex;

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
         * indexList : [{"key":"2017-06","value":3656.8},{"key":"2017-05","value":3332.4},{"key":"2017-04","value":3086.8},{"key":"2017-03","value":4170.6},{"key":"2017-01","value":791.2},{"key":"2016-12","value":2948.6}]
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
             * key : 2017-06
             * value : 3656.8
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
         * value : 3656.8
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
