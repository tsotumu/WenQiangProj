package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexData {
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
         * indexList : [{"key":"2018-09","value":11},{"key":"2018-08","value":13},{"key":"2018-07","value":8},{"key":"2018-06","value":-5},{"key":"2018-05","value":-12},{"key":"2018-04","value":20}]
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
             * value : 11
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

            @Override
            public String toString() {
                return "key->" + key + " value->" + value;
            }
        }
    }

    public static class MachineIndexBean {
        /**
         * key : 2号包装机
         * value : 11
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