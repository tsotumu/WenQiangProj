package com.macojia.leanproduct.ui.news.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.bean.GirlData;
import com.macojia.leanproduct.bean.PhotoGirl;
import com.macojia.leanproduct.ui.news.contract.PhotoListContract;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * des:图片
 * Created by xsf
 * on 2016.09.12:02
 */
public class PhotosListModel implements PhotoListContract.Model {
    @Override
    public Observable<List<PhotoGirl>> getPhotosListData(int size, int page) {
        return NetworkManager.getDefault(HostType.GANK_GIRL_PHOTO)
                .getPhotoList(NetworkManager.getCacheControl(), size, page)
                .map(new Func1<GirlData, List<PhotoGirl>>() {
                    @Override
                    public List<PhotoGirl> call(GirlData girlData) {
                        return girlData.getResults();
                    }
                })
                .compose(RxSchedulers.<List<PhotoGirl>>io_main());
    }
}
