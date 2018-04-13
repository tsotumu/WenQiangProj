package com.macojia.leanproduct.app;

import com.macojia.leanproduct.BuildConfig;
import com.macojia.common.baseapp.BaseApplication;
import com.macojia.common.commonutils.LogUtils;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}
