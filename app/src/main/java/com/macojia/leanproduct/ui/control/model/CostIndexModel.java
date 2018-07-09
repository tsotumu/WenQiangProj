package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.control.CostIndexData;
import com.macojia.leanproduct.ui.control.contact.CostListContact;

import java.util.List;

import rx.Observable;

/**
 * Created by LC on 2018/7/9.
 */

public class CostIndexModel implements CostListContact.Model {
    @Override
    public Observable<List<CostIndexData>> getNewsListData(String type, String id, int startPage) {
        return null;
    }
}
