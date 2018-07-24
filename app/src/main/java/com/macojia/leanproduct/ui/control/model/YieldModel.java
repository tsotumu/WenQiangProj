package com.macojia.leanproduct.ui.control.model;

import android.database.Observable;

import com.macojia.leanproduct.bean.control.YieldIndexData;
import com.macojia.leanproduct.ui.control.contact.YieldListContact;

import java.util.List;

/**
 * Created by Administrator on 2018/7/24.
 */

public class YieldModel implements YieldListContact.Model {
    @Override
    public Observable<List<YieldIndexData>> geListData() {
        return null;
    }
}
