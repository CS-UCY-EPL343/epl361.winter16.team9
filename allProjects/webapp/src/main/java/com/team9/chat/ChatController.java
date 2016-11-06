package com.team9.chat;

import com.team9.Utils.ViewUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class ChatController {

    public static Route serveIndexPage = (request, response) -> {
        Map<String,Object> model = new HashMap<>();
        return ViewUtil.render(request,model, ViewUtil.PATH.getTemplateInstance().getCHAT());

    };
}
