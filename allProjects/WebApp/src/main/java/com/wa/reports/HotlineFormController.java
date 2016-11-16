package com.wa.reports;

import com.google.gson.JsonObject;
import com.wa.controllers.Controller;
import spark.Request;
import spark.Response;
import spark.Route;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zgeorg03 on 11/6/16.
 */
public class HotlineFormController  extends Controller{
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


    private PrivateKey privateKey;
    private HotlineCaseHandler caseHandler;


    public HotlineFormController(String mainPath, String mainTemplatePath, PrivateKey key,HotlineCaseHandler caseHandler, Logger logger) {
        super(mainPath, mainTemplatePath, logger);
        this.privateKey = key;
        this.caseHandler = caseHandler;
    }


    public  Route serveHotlineFormSubmission = (request, response) -> {
        StringBuilder sb = new StringBuilder();

        String email = request.queryParams("email");
        if(email==null) {
            return "{\"msg\":\"error\"}";
        }
        sb.append("email\t"+email +"\n");
        //String decrypted_email = Keys.decrypt(privateKey,Base64.getDecoder().decode(email));
        //System.out.println("Decr: " + decrypted_email);


        String file = request.queryParams("files");
        sb.append(file+"\t" + file+"\n");


        //Generate a unique Identifier
        String caseID = UUID.randomUUID().toString();


        if(!caseHandler.newCase(caseID, sb.toString().getBytes("UTF-8"))){
            return "{\"msg\":\"Case already exists!\"}";
        }

        JsonObject object =new JsonObject();
        object.addProperty("msg","ok");
        object.addProperty("case_id",caseID);
        return object;

    };
    @Override
    protected void mainRoute(Request request, Map model, Response response) {
        model.put("topics",topics);

    }
}
