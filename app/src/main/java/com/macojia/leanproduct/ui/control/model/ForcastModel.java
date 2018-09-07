package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.ui.control.contact.ForcastContact;

import rx.Observable;

public class ForcastModel implements ForcastContact.Model {
    @Override
    public Observable<ForcastData> getData() {
        return null;
    }
}
