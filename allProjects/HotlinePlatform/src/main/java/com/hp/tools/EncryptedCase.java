package com.hp.tools;

import com.cmsl.db.entities.Operator;
import com.cmsl.entities.CaseDetails;

import java.io.*;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class EncryptedCase {
    private final String path;
    private final String id;
    private final long timestamp;

    public String getPath() {
        return path;
    }

    public EncryptedCase(String id, long timestamp, String path) {
        this.id = id;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return id;
    }


    /**
     *
     * @param operator
     * @return
     * @throws IOException
     */
    public CaseDetails decryptCase(Operator operator )throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(new File(path+"/base64-encrypted.data")));
        String line="";
        String case_id = id;
        String operator_id = operator.getOperator_id();
        String url_link = "Not provided";
        String time_created = timestamp+"";
        String comments = "";
        String topic = "";
        String name = operator.getName();
        String surname = operator.getSurname() ;
        String gender = "male";
        String age = "Not available";
        String address = "Organization Address";
        String city = "Nicosia";
        String country = "CY";
        String email = operator.getEmail();
        String telephone = operator.getTelephone();

        while( (line=bf.readLine())!=null){
            String toks[] = line.split("\t");
            if(toks.length!=2)
                continue;
            String key = toks[0];
            String value = toks[1];
            if(key.equals("topic")) {
                topic = value;
            }else if(key.equals("url")){
                url_link = value;
            }else if(key.equals("comments")){
                comments = value;
            }else if(key.equals("firstName")){
                name = value;
            }else if(key.equals("lastName")){
                surname = value;
            }else if(key.equals("email")){
                email = value;
            }else if(key.equals("age")){
                age = value;
            }else if(key.equals("address")){
                address = value;
            }else if(key.equals("city")){
                city = value;
            }else if(key.equals("country")) {
                country = value;
            }

        }
        return new CaseDetails(case_id,operator_id,url_link,time_created,comments,topic,name,surname,gender,age,address,city,country,email,telephone);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj instanceof EncryptedCase)
            if (((EncryptedCase) obj).getId().equals(id))
                return true;

        return false;
    }

    public boolean hasPersonalDetails() {
        return false;
    }
}
