package com.macojia.leanproduct.ui.news.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.http.HttpUtil;
import com.macojia.leanproduct.http.NetworkConstants;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.bean.news.NewsDetailEntity;
import com.macojia.leanproduct.ui.news.contract.NewsDetailContract;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.utils.JsonUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * des:新闻详情
 * Created by xsf
 * on 2016.09.17:09
 */
public class NewsDetailModel implements NewsDetailContract.Model {

    @Override
    public Observable<NewsDetailEntity> getOneNewsData(final String postId) {
        return NetworkManager.getDefault(0).getNewDetail(Integer.valueOf(postId).intValue());
    }

    private void changeNewsDetail(NewsDetailEntity newsDetail) {
        List<NewsDetailEntity.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getNews_content();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setNews_content(newsBody);
        }
    }

    private boolean isChange(List<NewsDetailEntity.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetailEntity.ImgBean> imgSrcs, String newsBody) {
        for (int i = 0; i < imgSrcs.size(); i++) {
            String oldChars = "<!--IMG#" + i + "-->";
            String newChars;
            if (i == 0) {
                newChars = "";
            } else {
                newChars = "<img src=\"" + imgSrcs.get(i).getSrc() + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}
