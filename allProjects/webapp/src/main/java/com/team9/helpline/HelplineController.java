package com.team9.helpline;

import com.team9.Utils.ViewUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HelplineController {

    public static Route serveIndexPage = (request, response) -> {
        Map<String,Object> model = new HashMap<>();
        return ViewUtil.render(request,model, ViewUtil.PATH.getTemplateInstance().getHELPLINE());

    };
}
