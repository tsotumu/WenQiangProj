package com.macojia.leanproduct.bean.control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexData {
    public HashMap<Integer, Float> mMachineData;

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("");
        if (mMachineData != null) {
            Iterator<Map.Entry<Integer, Float>> iterator = mMachineData.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Float> entry = iterator.next();
                string.append(entry.getKey() + ", " + entry.getValue());
            }
        }
        return string.toString();
    }
}
