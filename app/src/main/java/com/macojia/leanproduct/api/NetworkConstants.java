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
package com.macojia.leanproduct.api;

public class NetworkConstants {
    public static final String NETEAST_HOST = "http://c.m.163.com/";
    // 头条TYPE
    public static final String HEADLINE_TYPE = "headline";
    // 房产TYPE
    public static final String HOUSE_TYPE = "house";
    // 其他TYPE
    public static final String OTHER_TYPE = "list";

    //    // 北京
    //    public static final String LOCAL_TYPE = "local";
    //    // 北京的Id
    //    public static final String BEIJING_ID = "5YyX5Lqs";
    //example：http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
    // 头条id
    public static final String HEADLINE_ID = "T1348647909107";
    // 房产id
    public static final String HOUSE_ID = "5YyX5Lqs";

    /**
     * 新浪图片新闻
     * http://gank.io/api/data/福利/{size}/{page}
     */
    public static final String SINA_PHOTO_HOST = "http://gank.io/api/";

    /**
     * 新闻id获取类型
     *
     * @param id 新闻id
     * @return 新闻类型
     */
    public static String getType(String id) {
        switch (id) {
            case HEADLINE_ID:
                return HEADLINE_TYPE;
            case HOUSE_ID:
                return HOUSE_TYPE;
            default:
                break;
        }
        return OTHER_TYPE;
    }

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.NETEASE_NEWS_VIDEO:
                host = NETEAST_HOST;
                break;
            case HostType.GANK_GIRL_PHOTO:
                host = SINA_PHOTO_HOST;
                break;
            case HostType.NEWS_DETAIL_HTML_PHOTO:
                host = "http://kaku.com/";
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
