package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */

public class ComprehensiveIndexData {
    public List<MonthlyData> indexData;

    public static class MonthlyData {
        public List<Integer> data;
    }
}
