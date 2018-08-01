package base.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.macojia.leanproduct.app.AppApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyd10892 on 2016/8/23.
 */

public class JsonUtils {

    public static <Type> Type analysisNewsJsonFile(Class<Type> EntityType, String fileName){
        String content = FileUtils.readJsonFile(AppApplication.getAppContext(), fileName);
        Gson gson = new Gson();
        Type entity = gson.fromJson(content, EntityType);
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
