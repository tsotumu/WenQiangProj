package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.control.contact.ForcastContact;

import rx.Observable;

public class ForcastModel implements ForcastContact.Model {
    @Override
    public Observable<ForcastData> getData() {
        return NetworkManager.getDefault(0).getForcastData();
    }
}
