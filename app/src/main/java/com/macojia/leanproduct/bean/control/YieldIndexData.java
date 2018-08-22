package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class YieldIndexData {
    private List<Integer> machineIndex;
    private List<MonthlyIndexPerMachineBean> monthlyIndexPerMachine;

    public List<Integer> getMachineIndex() {
        return machineIndex;
    }

    public void setMachineIndex(List<Integer> machineIndex) {
        this.machineIndex = machineIndex;
    }

    public List<MonthlyIndexPerMachineBean> getMonthlyIndexPerMachine() {
        return monthlyIndexPerMachine;
    }

    public void setMonthlyIndexPerMachine(List<MonthlyIndexPerMachineBean> monthlyIndexPerMachine) {
        this.monthlyIndexPerMachine = monthlyIndexPerMachine;
    }

    public static class MonthlyIndexPerMachineBean {
        private List<MonthlyIndexBean> monthlyIndex;

        public List<MonthlyIndexBean> getMonthlyIndex() {
            return monthlyIndex;
        }

        public void setMonthlyIndex(List<MonthlyIndexBean> monthlyIndex) {
            this.monthlyIndex = monthlyIndex;
        }

        public static class MonthlyIndexBean {
            /**
             * month : 2017.9
             * index : 55
             */

            private String month;
            private int index;

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
        }
    }
}
