package com.macojia.leanproduct.ui.hotel.model;

import com.macojia.leanproduct.bean.hotel.VWDetailEntity;
import com.macojia.leanproduct.bean.hotel.ViewWindowEntity;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.control.contact.ViewWindowContact;
import com.macojia.leanproduct.ui.hotel.contact.ViewWindowDetailContact;

import rx.Observable;

/**
 * Created by LC on 2018/10/6.
 */

public class VMDetailModel implements ViewWindowDetailContact.Model {
    @Override
    public Observable<VWDetailEntity> getData(int postId) {
        return NetworkManager.getDefault(0).getWindowData(Integer.valueOf(postId).intValue());
    }
}
