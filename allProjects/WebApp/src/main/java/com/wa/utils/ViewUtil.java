package com.wa.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

/**
 * Created by zgeorg03 on 11/5/16.
 */
public class ViewUtil {

    private static final FreeMarkerEngine engine = new FreeMarkerEngine();
    private static final Configuration freeMakerConfiguration = new Configuration();
    public static final Path PATH = new Path();
    static{
        freeMakerConfiguration.setTemplateLoader(new ClassTemplateLoader(ViewUtil.class,"/templates/"));
        engine.setConfiguration(freeMakerConfiguration);
    }

    public ViewUtil() throws TemplateModelException {
    }

    public static String render(Request request, Map<String, Object> model, String templatePath) {
        //model.put("currentUser", getSessionCurrentUser(request));
        model.put("WebPath", PATH.getWebInstance()); // Access application URLs from templates.
        return engine.render(new ModelAndView(model, templatePath));
    }
}
