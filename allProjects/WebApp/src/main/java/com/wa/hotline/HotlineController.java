package com.wa.hotline;

import com.wa.utils.Controller;
import com.wa.utils.Handlers;
import com.wa.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HotlineController extends Controller {


    public HotlineController(String path,String templatePath, Logger logger) {
        super(path,templatePath,logger);
    }

    @Override
    protected void mainRoute(Request request, Map model, Response response) {

    }
}
