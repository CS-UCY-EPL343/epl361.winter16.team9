package com.wa.hotline;

import com.cmsl.security.Keys;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.wa.utils.Controller;
import spark.Request;
import spark.Response;
import spark.Route;

import java.security.PrivateKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HotlineFormController  extends Controller{


    private PrivateKey privateKey;


    public HotlineFormController(String mainPath, String mainTemplatePath, PrivateKey key, Logger logger) {
        super(mainPath, mainTemplatePath, logger);
        this.privateKey = key;
    }


    public  Route serveHotlineFormSubmission = (request, response) -> {
        String email = request.queryParams("email");
        if(email==null) {
            System.out.println(email);
            return "{\"msg\":\"error\"}";
        }
        System.out.println(email);
        String decrypted_email = Keys.decrypt(privateKey,Base64.getDecoder().decode(email));
        System.out.println("Decr: " + decrypted_email);


        String caseID = UUID.randomUUID().toString();

        JsonObject object =new JsonObject();
        object.addProperty("msg","ok");
        object.addProperty("case_id",caseID);
        return object;

    };
    @Override
    protected void mainRoute(Request request, Map model, Response response) {

    }
}
