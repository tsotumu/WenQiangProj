package com.macojia.leanproduct.bean.control;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexData {
    public List<MonthlyData> indexData;

    public static class MonthlyData {
        public List<Integer> data;
    }
}