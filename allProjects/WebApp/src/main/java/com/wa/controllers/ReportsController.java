package com.wa.controllers;

import com.wa.controllers.Controller;
import spark.Request;
import spark.Response;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class ReportsController extends Controller {


    public ReportsController(String path, String templatePath, Logger logger) {
        super(path,templatePath,logger);
    }

    @Override
    protected void mainRoute(Request request, Map model, Response response) {

    }
}
