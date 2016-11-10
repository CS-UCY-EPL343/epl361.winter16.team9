package com.wa.index;

import com.wa.utils.Controller;
import com.wa.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by zgeorg03 on 11/5/16.
 */
public class IndexController extends Controller {


    public  Route serveIndexPage = (request, response) -> {
        Map<String,Object> model = new HashMap<>();

        getLogger().info("Request from: " +request.ip());


        model.put("title","WebSite");
        return ViewUtil.render(request,model, ViewUtil.PATH.getTemplateInstance().getINDEX());

    };

    public IndexController(String path,String templatePath,Logger logger) {
        super(path,templatePath,logger);
    }

    @Override
    protected void mainRoute(Request request,Map model,Response response) {
        model.put("title","WebSite");
    }


}
