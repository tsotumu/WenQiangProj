package com.macojia.leanproduct;

import com.macojia.common.baseapp.BaseApplication;
import com.macojia.common.commonutils.LogUtils;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    private static AppApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        mInstance = this;
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }

    public static AppApplication getInstance(){
        return mInstance;
    }
}
