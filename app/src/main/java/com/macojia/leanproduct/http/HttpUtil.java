package com.macojia.leanproduct.http;

import com.alipay.security.mobile.module.commonutils.LOG;
import com.yuyh.library.imgsel.utils.LogUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import base.utils.DebugUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static Call makeLionHttpRequest(OkHttpClient client, String url, Map<String, Object> params, Callback callback) {

        FormBody.Builder formBuilder = new FormBody.Builder();

        Iterator<String> keySet = params.keySet().iterator();
        String key;
        while (keySet.hasNext()) {
            key = keySet.next();
            formBuilder.add(key, params.get(key).toString());
        }

        if (DebugUtil.DEBUG) {
            LogUtils.d("", "\n{\nurl: " + url + "\nparams: " + params.toString() + "\n}\n");
        }

        Request request = new Request.Builder()
                .url(url)
                .post(formBuilder.build())
                .build();

        Call requestInternal = client.newCall(request);
        requestInternal.enqueue(callback);

        return requestInternal;
    }
}
