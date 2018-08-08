package com.macojia.leanproduct.bean.control;

import java.util.List;

/**
 * Created by Administrator on 2018/8/8.
 */

public class MatainGuideData {
    public List<MatainDataPerMachine> maintainDataList;

    public static class MatainDataPerMachine {
        public List<MatainData> data;
    }

    public static class MatainData {
        public String name;
        public int frequency;
    }

}
