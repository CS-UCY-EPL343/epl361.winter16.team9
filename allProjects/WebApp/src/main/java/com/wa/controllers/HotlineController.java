package com.wa.controllers;

import com.google.gson.JsonObject;
import com.wa.controllers.Controller;
import com.wa.reports.HotlineCaseHandler;
import com.wa.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.PrivateKey;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HotlineController extends Controller{

    private Map<String,Long> ips;

    private final List<String> topics = Stream.of(
    "Παιδική πορνογραφία",
    "Ρατσισμός/ξενοφοβία",
    "Κλοπή προσωπικών δεδομένων(π.χ. ψεύτικο προφίλ)",
    "Παραβίαση του απορρήτου των επικοινωνιών",
    "Διαδικτυακός εκφοβισμός",
    "Σεξουαλική παρενόχληση",
    "Παρατεταμένη χρήση",
    "Ηλεκτρονική αποπλάνηση",
    "Μηνύματα σεξουαλικού περιεχομένου(sexting)",
    "Ανεπιθύμητη επαφή από αγνώστους",
    "Ανεπιθύμητη αλληλογραφία",
    "Εμπορικοί κίνδυνοι/απειλές (π.χ. phishing)",
    "Site Suggestions",
    "Product Support"
    ).collect(Collectors.toList());


    //private PrivateKey privateKey;
    private HotlineCaseHandler caseHandler;


    public HotlineController(String mainPath, String mainTemplatePath, PrivateKey key, HotlineCaseHandler caseHandler, Logger logger) {
        super(mainPath, mainTemplatePath, logger);
        //this.privateKey = key;
        this.caseHandler = caseHandler;

        this.ips = new HashMap<>();
    }


    public  Route serveHotlineFormSubmission = (request, response) -> {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        String ip = request.ip();
        if(ips.containsKey(ip)){
            long value = ips.get(ip);
            long diff = System.currentTimeMillis() - value;
            if( diff < 1000 * 15){
                JsonObject object =new JsonObject();
                object.addProperty("msg","You made a request before "+(diff/1000) + " seconds");
                return object;
            }
        }

        ips.put(ip,System.currentTimeMillis());

        StringBuilder sb = new StringBuilder();
        String age = request.queryParams("age");
        String url = request.queryParams("url");
        String firstName = request.queryParams("firstName");
        String lastName = request.queryParams("lastName");
        String country = request.queryParams("country");
        String comments = request.queryParams("comments");
        String email = request.queryParams("email");
        String topic = request.queryParams("topic");
        String personalDetails = request.queryParams("personalDetails");
        String address = request.queryParams("address");
        String city = request.queryParams("city");

        sb.append("topic\t" + topic + "\n");
        if(url.isEmpty())
            url="Not provided";
        sb.append("url\t" + url + "\n");
        sb.append("comments\t" + comments + "\n");
        if(personalDetails!= null && personalDetails.equalsIgnoreCase("true")) {
            sb.append("firstName\t" + firstName + "\n");
            sb.append("lastName\t" + lastName + "\n");
            sb.append("email\t" + email + "\n");
            sb.append("age\t" + age + "\n");
            sb.append("address\t" + address + "\n");
            sb.append("city\t" + city + "\n");
            sb.append("country\t" + country + "\n");
        }

        Part part =  request.raw().getPart("file");
        InputStream fileStream = part.getInputStream();

        String caseID = UUID.randomUUID().toString();
        boolean succeeded = caseHandler.newCase(caseID,sb.toString().getBytes("UTF-8"),fileStream,part.getSize()!=0);
        if(succeeded)
            getLogger().info("New Case: " + caseID);


        Map model = new HashMap();
        model.put("case_id",caseID);
        return ViewUtil.render(request,model,"/reports/successfullSubmission.ftl");

    };
    @Override
    protected void mainRoute(Request request, Map model, Response response) {
        model.put("topics",topics);

    }
}
