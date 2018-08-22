package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class EfficiencyIndexData {
    public List<Integer> machineIndex;
    public List<MonthlyIndex> monthlyIndexPerMachine;

    public static class MonthlyIndex {
        public List<Integer> monthlyIndex;
    }
}
