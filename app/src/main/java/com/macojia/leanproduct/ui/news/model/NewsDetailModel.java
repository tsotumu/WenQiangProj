package com.macojia.leanproduct.ui.news.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.bean.news.NewsDetailEntity;
import com.macojia.leanproduct.ui.news.contract.NewsDetailContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.utils.JsonUtils;
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
        return NetworkManager.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewDetail(NetworkManager.getCacheControl(), postId)
                .map(new Func1<Map<String, NewsDetailEntity>, NewsDetailEntity>() {
                    @Override
                    public NewsDetailEntity call(Map<String, NewsDetailEntity> map) {
                        if (true) { // 测试本地数据。
                            NewsDetailEntity newsDetailEntity = JsonUtils.analysisNewsJsonFile(NewsDetailEntity.class, "news_detail_data");
                            return newsDetailEntity;
                        }
                        NewsDetailEntity newsDetail = map.get(postId);
                        changeNewsDetail(newsDetail);
                        return newsDetail;
                    }
                })
                .compose(RxSchedulers.<NewsDetailEntity>io_main());
    }

    private void changeNewsDetail(NewsDetailEntity newsDetail) {
        List<NewsDetailEntity.ImgBean> imgSrcs = newsDetail.img;
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.news_content;
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.news_content = newsBody;
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
                newChars = "<img src=\"" + imgSrcs.get(i).src + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}
