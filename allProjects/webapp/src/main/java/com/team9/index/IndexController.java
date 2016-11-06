package com.team9.index;

import com.team9.Utils.Path;
import com.team9.Utils.ViewUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zgeorg03 on 11/5/16.
 */
public class IndexController {

    public static Route serveIndexPage = (request, response) -> {
        Map<String,Object> model = new HashMap<>();
        model.put("title","WebSite");
        return ViewUtil.render(request,model, ViewUtil.PATH.getTemplateInstance().getINDEX());

    };
}
