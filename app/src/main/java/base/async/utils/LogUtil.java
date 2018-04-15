package base.async.utils;

import android.util.Log;

import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.constant.LogFilterDef;

import base.async.utils.LogHelper;

/**
 * Created by LC on 2018/4/15.
 */

public class LogUtil {

    private static boolean LogEnabled = BuildConfig.DEBUG;

    public static void d(String TAG, String msg) {
        if (LogEnabled)
            Log.d(TAG, msg);
    }

    public static void e(String TAG, String msg) {
        if (LogEnabled)
            Log.e(TAG, msg);
    }

    public static void error(Exception e) {
        if (LogEnabled) {
            if (BuildConfig.DEBUG)
                if (e != null) {
                    LogUtil.e(LogFilterDef.ERROR, LogHelper.getFileLineMethod(2) + e.getMessage());
                } else {
                    LogUtil.e(LogFilterDef.ERROR, "");
                }
        }
    }

    public static void i(String TAG, String msg) {
        if (LogEnabled)
            Log.i(TAG, msg);
    }

    public static void v(String TAG, String msg) {
        if (LogEnabled)
            Log.v(TAG, msg);
    }
}
