package com.wa.utils;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
