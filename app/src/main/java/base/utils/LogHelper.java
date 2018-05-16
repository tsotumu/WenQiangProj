package base.utils;

import com.macojia.leanproduct.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luowp on 2016/7/12.
 */
public abstract class LogHelper {
    /*
    stackIndex default is 1
     */
    public static String getFileLineMethod(int stackIndex) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[stackIndex];
        StringBuffer toStringBuffer = new StringBuffer("[").append(
                traceElement.getFileName()).append(" | ").append(
                traceElement.getLineNumber()).append(" | ").append(
                traceElement.getMethodName()).append("]");
        return android.os.Process.myPid() + toStringBuffer.toString() + " ";
    }

    public static void printStack() {
        if (BuildConfig.DEBUG) {
            StackTraceElement traceElement[] = ((new Exception()).getStackTrace());
            for (StackTraceElement stackTraceElement : traceElement) {
                if (BuildConfig.DEBUG) LogUtil.d("luowp", stackTraceElement.toString());
            }
        }
    }

    // 当前文件名
    public static String _FILE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getFileName();
    }

    // 当前方法名
    public static String _FUNC_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getMethodName();
    }

    // 当前行号
    public static int _LINE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getLineNumber();
    }

    // 当前时间
    public static String _TIME_() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(now);
    }
}
