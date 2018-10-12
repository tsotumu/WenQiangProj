package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class YieldIndexData {

    /**
     * MonthlyIndexPerMachine : [{"indexList":[{"key":"2018-09-07","value":1347.2},{"key":"2018-09-06","value":1553.2},{"key":"2018-09-05","value":2094},{"key":"2018-09-04","value":1189.2},{"key":"2018-09-03","value":709.6},{"key":"2018-09-02","value":1219}],"machineName":"11号包装机"},{"indexList":[{"key":"2018-09-07","value":989.2},{"key":"2018-09-06","value":1494.2},{"key":"2018-09-05","value":265},{"key":"2018-09-04","value":279.8},{"key":"2018-09-01","value":3729.8}],"machineName":"12号包装机"},{"indexList":[{"key":"2018-09-07","value":3651.2},{"key":"2018-09-06","value":3866},{"key":"2018-09-05","value":3544.6},{"key":"2018-09-04","value":4031},{"key":"2018-09-03","value":3680.8},{"key":"2018-09-02","value":3650.6}],"machineName":"15号包装机"},{"indexList":[{"key":"2018-09-07","value":3622.8},{"key":"2018-09-06","value":4122.4},{"key":"2018-09-05","value":4805.6},{"key":"2018-09-04","value":4444.2},{"key":"2018-09-03","value":3894.6},{"key":"2018-09-02","value":3788.2}],"machineName":"16号包装机"},{"indexList":[{"key":"2018-09-07","value":3328},{"key":"2018-09-06","value":3781.4},{"key":"2018-09-05","value":4306.6},{"key":"2018-09-04","value":4254},{"key":"2018-09-03","value":948.2},{"key":"2018-09-01","value":3979.4}],"machineName":"17号包装机"},{"indexList":[{"key":"2018-09-07","value":2091},{"key":"2018-09-06","value":3347},{"key":"2018-09-05","value":3964.2},{"key":"2018-09-04","value":3120},{"key":"2018-09-03","value":3512.4},{"key":"2018-09-02","value":1444}],"machineName":"18号包装机"},{"indexList":[{"key":"2018-09-07","value":1037.2},{"key":"2018-09-05","value":3421.4},{"key":"2018-09-04","value":3074},{"key":"2018-09-03","value":1370},{"key":"2018-09-01","value":4192}],"machineName":"1号包装机"},{"indexList":[{"key":"2018-09-07","value":1049.6},{"key":"2018-09-05","value":3326},{"key":"2018-09-04","value":3102},{"key":"2018-09-03","value":1373.2},{"key":"2018-09-01","value":4123.8}],"machineName":"2号包装机"},{"indexList":[{"key":"2018-09-07","value":995.2},{"key":"2018-09-05","value":3181.8},{"key":"2018-09-04","value":2948.6},{"key":"2018-09-03","value":1453.2},{"key":"2018-09-01","value":3673}],"machineName":"3号包装机"},{"indexList":[{"key":"2018-09-07","value":659.8},{"key":"2018-09-05","value":3193.6},{"key":"2018-09-04","value":2749.8},{"key":"2018-09-02","value":604},{"key":"2018-09-01","value":3381}],"machineName":"4号包装机"},{"indexList":[{"key":"2018-09-07","value":1541.2},{"key":"2018-09-06","value":1489},{"key":"2018-09-05","value":3625.8},{"key":"2018-09-04","value":2883.6},{"key":"2018-09-03","value":2691},{"key":"2018-09-02","value":2071}],"machineName":"5号包装机"},{"indexList":[{"key":"2018-09-07","value":2202.8},{"key":"2018-09-06","value":1969},{"key":"2018-09-05","value":3083.6},{"key":"2018-09-04","value":2313.4},{"key":"2018-09-03","value":2838.6},{"key":"2018-09-02","value":3107.8}],"machineName":"6号包装机"},{"indexList":[{"key":"2018-09-07","value":1832.8},{"key":"2018-09-06","value":3006.6},{"key":"2018-09-05","value":3691.6},{"key":"2018-09-04","value":3422},{"key":"2018-09-03","value":1956.2},{"key":"2018-09-02","value":2967.4}],"machineName":"7号包装机"},{"indexList":[{"key":"2018-09-07","value":10},{"key":"2018-09-06","value":10},{"key":"2018-09-05","value":2013},{"key":"2018-09-04","value":2029.8},{"key":"2018-09-03","value":2042},{"key":"2018-09-02","value":2794.8}],"machineName":"8号包装机"}]
     * machineIndex : [{"key":"11号包装机","value":10908.6},{"key":"12号包装机","value":6758},{"key":"15号包装机","value":27723.2},{"key":"16号包装机","value":30419.8},{"key":"17号包装机","value":20597.6},{"key":"18号包装机","value":18883.6},{"key":"1号包装机","value":13094.6},{"key":"2号包装机","value":12974.6},{"key":"3号包装机","value":12251.8},{"key":"4号包装机","value":10588.2},{"key":"5号包装机","value":19127.2},{"key":"6号包装机","value":19970.6},{"key":"7号包装机","value":21454},{"key":"8号包装机","value":13006.2}]
     * machineTitle : 2018-09开动各机组产量累计图示
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
         * indexList : [{"key":"2018-09-07","value":1347.2},{"key":"2018-09-06","value":1553.2},{"key":"2018-09-05","value":2094},{"key":"2018-09-04","value":1189.2},{"key":"2018-09-03","value":709.6},{"key":"2018-09-02","value":1219}]
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
             * key : 2018-09-07
             * value : 1347.2
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
         * value : 10908.6
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
