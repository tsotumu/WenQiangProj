package com.macojia.leanproduct.chart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by LC on 2018/8/22.
 */

public class LabelFormatter implements IAxisValueFormatter {
    private final String[] mLabels;

    public LabelFormatter(String[] labels) {
        mLabels = labels;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        try {
            return mLabels[(int) value];
        } catch (Exception e) {
            e.printStackTrace();
            return mLabels[0];
        }
    }
}
