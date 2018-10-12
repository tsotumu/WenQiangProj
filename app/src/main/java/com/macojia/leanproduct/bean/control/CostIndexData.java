package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexData {
    /**
     * MonthlyIndexPerMachine : [{"indexList":[{"key":"2018-09-04","value":23},{"key":"2018-09-03","value":-5},{"key":"2018-09-02","value":20},{"key":"2018-09-01","value":11}],"machineName":"15号包装机"},{"indexList":[{"key":"2018-09-06","value":11},{"key":"2018-09-05","value":13},{"key":"2018-09-04","value":8},{"key":"2018-09-03","value":-5},{"key":"2018-09-02","value":-12},{"key":"2018-09-01","value":11}],"machineName":"1号包装机"},{"indexList":[{"key":"2018-09-06","value":20},{"key":"2018-09-05","value":-12},{"key":"2018-09-04","value":-5},{"key":"2018-09-03","value":8},{"key":"2018-09-02","value":13},{"key":"2018-09-01","value":11}],"machineName":"2号包装机"},{"indexList":[{"key":"2018-09-08","value":-17},{"key":"2018-09-07","value":8},{"key":"2018-09-06","value":-5},{"key":"2018-09-05","value":20},{"key":"2018-09-04","value":-12},{"key":"2018-09-02","value":8}],"machineName":"3号包装机"},{"indexList":[{"key":"2018-09-03","value":11}],"machineName":"4号包装机"},{"indexList":[{"key":"2018-09-05","value":12},{"key":"2018-09-04","value":-3},{"key":"2018-09-03","value":14},{"key":"2018-09-02","value":-5},{"key":"2018-09-01","value":11},{"key":"2018-09-01","value":8}],"machineName":"5号包装机"},{"indexList":[{"key":"2018-09-03","value":-12},{"key":"2018-09-02","value":-5},{"key":"2018-09-01","value":21}],"machineName":"8号包装机"}]
     * machineIndex : [{"key":"15号包装机","value":49},{"key":"1号包装机","value":26},{"key":"2号包装机","value":35},{"key":"3号包装机","value":2},{"key":"4号包装机","value":11},{"key":"5号包装机","value":37},{"key":"8号包装机","value":4}]
     * machineTitle : 2018-09开动各机组消耗累计图示
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
         * indexList : [{"key":"2018-09-04","value":23},{"key":"2018-09-03","value":-5},{"key":"2018-09-02","value":20},{"key":"2018-09-01","value":11}]
         * machineName : 15号包装机
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
             * key : 2018-09-04
             * value : 23
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

    public static class MachineIndexBean {
        /**
         * key : 15号包装机
         * value : 49
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