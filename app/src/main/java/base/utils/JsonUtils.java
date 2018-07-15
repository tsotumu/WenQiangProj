package base.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.macojia.leanproduct.BuildConfig;
import com.macojia.leanproduct.app.AppApplication;
import com.macojia.leanproduct.bean.NewsDetail;
import com.macojia.leanproduct.constant.LogFilterDef;
import com.macojia.leanproduct.pojo.HotelEntity;
import com.macojia.leanproduct.pojo.NewsDetailEntity;
import com.macojia.leanproduct.pojo.NewsListEntity;
import com.yuyh.library.imgsel.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by lyd10892 on 2016/8/23.
 */

public class JsonUtils {

    public static HotelEntity analysisHotelJsonFile(Context context, String fileName) {
        String content = FileUtils.readJsonFile(context, fileName);
        Gson gson = new Gson();
        HotelEntity entity = gson.fromJson(content, HotelEntity.class);
        if (BuildConfig.DEBUG) LogUtils.d(LogFilterDef.DATA_PARSE, content);
        if (BuildConfig.DEBUG) LogUtils.d(LogFilterDef.DATA_PARSE, entity.allTagsList.toString());
        return entity;
    }

    public static NewsListEntity analysisNewsListJsonFile(String fileName) {
        String content = FileUtils.readJsonFile(AppApplication.getAppContext(), fileName);
        Gson gson = new Gson();
        NewsListEntity entity = gson.fromJson(content, NewsListEntity.class);
        if (BuildConfig.DEBUG) LogUtils.d(LogFilterDef.DATA_PARSE, content);
        return entity;
    }

    public static NewsDetailEntity analysisNewsDetailJsonFile(String fileName) {
        String content = FileUtils.readJsonFile(AppApplication.getAppContext(), fileName);
        Gson gson = new Gson();
        NewsDetailEntity entity = gson.fromJson(content, NewsDetailEntity.class);
        if (BuildConfig.DEBUG) LogUtils.d(LogFilterDef.DATA_PARSE, content);
        return entity;
    }

    public static <T> List<T> parseJsonArrayWithGson(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        Gson gson = new Gson();
        JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
        for (JsonElement jsonElement : arry) {
            list.add(gson.fromJson(jsonElement, cls));
        }
        return list;
    }
}
