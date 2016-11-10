package com.wa.chat;

import com.wa.utils.ViewUtil;
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
