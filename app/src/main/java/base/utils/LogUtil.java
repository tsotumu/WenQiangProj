package base.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LogUtil {

    public static void pintArray(String tag, String prefix, String[] arg){
        List<String> a = new ArrayList<>();
        for (String b : arg){
            a.add(b);
        }
        Log.d(tag, prefix + " " + a.toString());
    }
}
