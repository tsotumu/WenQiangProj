package base.utils;

import android.app.Activity;
import android.content.Intent;

import com.macojia.leanproduct.R;
import com.macojia.leanproduct.activity.MainActivity;

/**
 * Created by LC on 2018/4/15.
 */

public class ActivityUtil {

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                com.macojia.common.R.anim.fade_out);
    }
}
