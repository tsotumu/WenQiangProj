package base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.macojia.leanproduct.R;
import com.macojia.leanproduct.activity.MainActivity;

/**
 * Created by LC on 2018/4/15.
 */

public class ActivityUtil {

    public static void startActivity(Activity context, Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.fade_in,
                com.macojia.common.R.anim.fade_out);
    }
}
