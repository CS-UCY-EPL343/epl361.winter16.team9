package com.wa.hotline;

import com.wa.Utils.ViewUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HotlineFormController {

    public static Route servePage = (request, response) -> {
        Map<String,Object> model = new HashMap<>();
        return ViewUtil.render(request,model, ViewUtil.PATH.getTemplateInstance().getHOTLINEREPORT());

    };
}