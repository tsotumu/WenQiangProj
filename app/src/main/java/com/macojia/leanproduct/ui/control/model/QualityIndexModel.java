package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.control.QualityIndexData;
import com.macojia.leanproduct.ui.control.contact.QualityIndexContract;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2018/7/17.
 */

public class QualityIndexModel implements QualityIndexContract.Model {
    @Override
    public Observable<List<QualityIndexData>> getListData() {
        return null;
    }
}
