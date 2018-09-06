package com.macojia.leanproduct.bean.control;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({ControlType.COMPRE_INDEX, ControlType.QUALITY_INDEX, ControlType.COST_INDEX, ControlType.EFFICIENCY_INDEX, ControlType.YIELD_INDEX})
@Retention(RetentionPolicy.SOURCE)
public @interface ControlType {
    String QUALITY_INDEX = "qualityindex";
    String COMPRE_INDEX = "";
    String EFFICIENCY_INDEX = "efficiencyindex";
    String YIELD_INDEX = "yieldindex";
    String COST_INDEX = "costindex";
}
