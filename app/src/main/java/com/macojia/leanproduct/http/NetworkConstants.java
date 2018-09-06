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
package com.macojia.leanproduct.http;

public class NetworkConstants {
    public static final String NETEAST_HOST = "http://118.190.153.47:8080/";
    public static final String NEWS_LIST_TEST = "http://118.190.153.47:8080/lpcms/getNewsList?startPage=1&type=党建";
    public static final String NEWS_LIST_TEST2 =     "http://118.190.153.47:8080/lpcms/getNewDetail?id=78";
    // http://118.190.153.47:8080/lpcms/getNewDetail?id=78
    // http://118.190.153.47:8080/lpcms/getMarkIndexData?markindex=qualityindex
    // http://118.190.153.47:8080/lpcms/getMarkIndexData?markindex=efficiencyindex
    // http://118.190.153.47:8080/lpcms/getMarkIndexData?markindex=costindex
    // http://118.190.153.47:8080/lpcms/getMarkIndexData?markindex=yieldindex

    // 其他TYPE
    public static final String OTHER_TYPE = "list";

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        return NETEAST_HOST;
    }

}
