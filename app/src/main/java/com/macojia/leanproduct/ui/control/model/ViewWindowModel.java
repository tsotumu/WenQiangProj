package com.macojia.leanproduct.ui.control.model;

import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.control.contact.ViewWindowContact;

import rx.Observable;

public class ViewWindowModel implements ViewWindowContact.Model {
    @Override
    public Observable<ViewWindowEntity> getData() {
        return NetworkManager.getDefault(0).getWindowList();
    }
}
