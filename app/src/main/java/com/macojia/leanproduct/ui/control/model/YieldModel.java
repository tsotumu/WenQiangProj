package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;

import base.utils.JsonUtils;

/**
 * Created by Administrator on 2018/7/24.
 */

public class YieldModel implements YieldListContact.Model {
    @Override
    public YieldIndexData geListData() {
        return JsonUtils.analysisNewsJsonFile(YieldIndexData.class, "yield_index.json");
    }
}
