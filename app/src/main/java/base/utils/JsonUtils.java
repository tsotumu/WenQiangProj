package base.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.constant.LogFilterDef;
import com.macojia.leanproduct.pojo.HotelEntity;

/**
 * Created by lyd10892 on 2016/8/23.
 */

public class JsonUtils {

    public static HotelEntity analysisJsonFile(Context context, String fileName) {
        String content = FileUtils.readJsonFile(context, fileName);
        Gson gson = new Gson();
        HotelEntity entity = gson.fromJson(content, HotelEntity.class);
        if (BuildConfig.DEBUG) LogUtil.d(LogFilterDef.DATA_PARSE, content);
        if (BuildConfig.DEBUG) LogUtil.d(LogFilterDef.DATA_PARSE, entity.allTagsList.toString());
        return entity;
    }
}
