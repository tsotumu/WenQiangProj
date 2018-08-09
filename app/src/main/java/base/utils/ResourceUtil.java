package base.utils;

import android.graphics.drawable.Drawable;

import com.macojia.leanproduct.AppApplication;

/**
 * Created by luowp on 2016/7/19.
 */
public class ResourceUtil {
    //private static Typeface FONT_PRODUCTSCANS_REGULAR = Typeface.createFromAsset(ApplicationEx.getInstance().getAssets(), "fonts/ProductSans-Regular.ttf");

    public static String getString(int resId) {
        return AppApplication.getInstance().getString(resId);
    }

    public static int getColor(int colorId) {
        return AppApplication.getInstance().getResources().getColor(colorId);
    }

    public static Drawable getDrawable(int drawableId) {
        return AppApplication.getInstance().getResources().getDrawable(drawableId);
    }

    public static int getDefaultIcon() {
        return android.R.drawable.sym_def_app_icon;
    }

    public static float getDimensionDp(int dimensId) {
        return AppApplication.getInstance().getResources().getDimension(dimensId);
    }

//    public static Typeface getFontProductScansRegular() {
//        return FONT_PRODUCTSCANS_REGULAR;
//    }
}
