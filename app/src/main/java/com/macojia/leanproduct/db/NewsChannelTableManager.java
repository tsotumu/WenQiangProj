/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.macojia.leanproduct.db;


import com.macojia.leanproduct.R;
import com.macojia.leanproduct.http.NetworkConstants;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.bean.news.NewsChannelTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsChannelTableManager {
    private final static int CHANNEL_AMOUNT = 5;

    /**
     * 加载固定新闻类型
     *
     * @return
     */
    public static List<NewsChannelTable> loadNewsChannelsStatic() {
        // title 作为新闻自页面的标题
        List<String> channelTitleList = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_name_static));
        List<String> channelIdList = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_name_static));
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        String title;
        String type;
        for (int i = 0; i < channelTitleList.size(); i++) {
            title = channelTitleList.get(i);
            type = channelIdList.get(i);
            NewsChannelTable entity = new NewsChannelTable(title, type, i <= CHANNEL_AMOUNT, i, true);
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }
}
