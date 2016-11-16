package com.wa.controllers;

import com.wa.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by zgeorg03 on 11/9/16.
 */
public abstract class Controller {

    private Logger logger;


    private String mainPath;
    private String mainTemplatePath;

    private final Route mainRoute = ((request, response) -> {
        logger.info("Request for " + mainPath + " from " + request.ip());
        Map<String,Object> model = new HashMap<>();
        mainRoute(request,model,response);
        return ViewUtil.render(request,model,mainTemplatePath);
    });

    protected Controller(String mainPath,String mainTemplatePath, Logger logger) {
        this.mainTemplatePath = mainTemplatePath;
        this.mainPath = mainPath;
        this.logger = logger;
    }

    public Logger getLogger() { return logger; }

    /**
     *
     * @param request Http request
     * @param model Map objects
     * @param response Response
     */
    protected  abstract void mainRoute(Request request,Map model,Response response);

    public String getMainPath() {
        return mainPath;
    }

    public Route getMainRoute() {
        return mainRoute;
    }
}
