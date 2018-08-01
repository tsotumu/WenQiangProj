package com.macojia.leanproduct.ui.news.model;

import com.macojia.common.baserx.RxSchedulers;
import com.macojia.common.commonutils.TimeUtil;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.api.NetworkConstants;
import com.macojia.leanproduct.api.HostType;
import com.macojia.leanproduct.api.NetworkManager;
import com.macojia.leanproduct.bean.news.NewsSummary;
import com.macojia.leanproduct.pojo.NewsListEntity;
import com.macojia.leanproduct.ui.news.contract.NewsListContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * des:获取新闻列表
 * Created by xsf
 * on 2016.09.14:54
 */
public class NewsListModel implements NewsListContract.Model {
    /**
     * 获取新闻列表
     *
     * @param type
     * @param id
     * @param startPage
     * @return
     */
    @Override
    public Observable<List<NewsSummary>> getNewsListData(final String type, final String id, final int startPage) {
        Observable<Map<String, List<NewsSummary>>> listObserver = NetworkManager.getDefault(HostType.NETEASE_NEWS_VIDEO).getNewsList(NetworkManager.getCacheControl(), type, id, startPage);
        if (BuildConfig.DEBUG){ // 测试数据。
//            listObserver.map.clear();
            return Observable.create(new Observable.OnSubscribe<List<NewsSummary>>() {
                @Override
                public void call(Subscriber<? super List<NewsSummary>> subscriber) {
                    List<NewsSummary> newsSummaryList = new ArrayList<>();
                    NewsListEntity newsListEntity = base.utils.JsonUtils.analysisNewsJsonFile(NewsListEntity.class, "news_list_data");
                    ArrayList<NewsListEntity.NewsDigest> digests = newsListEntity.newsList;
                    for (int i = 0; i < digests.size(); i++) {
                        NewsSummary newsSummary = new NewsSummary();
                        newsSummary.setDigest(digests.get(i).digest);
                        newsSummary.setTitle(digests.get(i).title);
                        newsSummary.setPostid(digests.get(i).postId);
                        newsSummary.setImgsrc(digests.get(i).imgSrc);
                        newsSummary.setPtime(digests.get(i).postTime);
                        newsSummaryList.add(newsSummary);
                        subscriber.onNext(newsSummaryList);
                        subscriber.onCompleted();
                    }
                }
            }).compose(RxSchedulers.<List<NewsSummary>>io_main());
        }


        Observable<NewsSummary> newsSummaryObservable = listObserver.flatMap(new Func1<Map<String, List<NewsSummary>>, Observable<NewsSummary>>() {
            @Override
            public Observable<NewsSummary> call(Map<String, List<NewsSummary>> map) {
                if (id.endsWith(NetworkConstants.HOUSE_ID)) {
                    // 房产实际上针对地区的它的id与返回key不同
                    return Observable.from(map.get("北京"));
                }
                return Observable.from(map.get(id));
            }
        });
        return newsSummaryObservable.map(new Func1<NewsSummary, NewsSummary>() {
            @Override
            public NewsSummary call(NewsSummary newsSummary) {
                String ptime = TimeUtil.formatDate(newsSummary.getPtime());
                newsSummary.setPtime(ptime);
                return newsSummary;
            }
        }).distinct()//去重
                .toSortedList(new Func2<NewsSummary, NewsSummary, Integer>() {
                    @Override
                    public Integer call(NewsSummary newsSummary, NewsSummary newsSummary2) {
                        return newsSummary2.getPtime().compareTo(newsSummary.getPtime());
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<NewsSummary>>io_main());
    }
}
