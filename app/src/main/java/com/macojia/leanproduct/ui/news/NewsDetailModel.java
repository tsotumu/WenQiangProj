package com.macojia.leanproduct.ui.news;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.bean.NewsDetail;
import com.macojia.leanproduct.pojo.NewsDetailEntity;

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
    public Observable<NewsDetail> getOneNewsData(final String postId) {
        return NetworkManager.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewDetail(NetworkManager.getCacheControl(), postId)
                .map(new Func1<Map<String, NewsDetail>, NewsDetail>() {
                    @Override
                    public NewsDetail call(Map<String, NewsDetail> map) {
                        if (true) { // 测试本地数据。
                            NewsDetailEntity newsDetailEntity = JsonUtils.analysisNewsJsonFile(NewsDetailEntity.class, "news_detail_data");
                            NewsDetail newsDetail = new NewsDetail();
                            newsDetail.setBody(newsDetailEntity.body);
                            newsDetail.setTitle(newsDetailEntity.title);
                            newsDetail.setSource(newsDetailEntity.source);
                            newsDetail.setPtime(newsDetailEntity.postTime);
                            ArrayList<NewsDetail.ImgBean> imgBeans = new ArrayList<>();
                            for (int i = 0; i < newsDetailEntity.img.size(); i++){
                                NewsDetail.ImgBean imgBean = new NewsDetail.ImgBean();
                                imgBean.setSrc(newsDetailEntity.img.get(i).src);
                                imgBean.setRef(newsDetailEntity.img.get(i).ref);
                                imgBean.setAlt(newsDetailEntity.img.get(i).alt);
                                imgBean.setPixel(newsDetailEntity.img.get(i).pixel);
                                imgBeans.add(imgBean);
                            }
                            newsDetail.setImg(imgBeans);
                            return newsDetail;
                        }
                        NewsDetail newsDetail = map.get(postId);
                        changeNewsDetail(newsDetail);
                        return newsDetail;
                    }
                })
                .compose(RxSchedulers.<NewsDetail>io_main());
    }

    private void changeNewsDetail(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getBody();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setBody(newsBody);
        }
    }

    private boolean isChange(List<NewsDetail.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetail.ImgBean> imgSrcs, String newsBody) {
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
