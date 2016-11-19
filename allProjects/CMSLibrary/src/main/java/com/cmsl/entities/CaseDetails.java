package com.cmsl.entities;

/**
 * Created by zgeorg03 on 11/19/16.
 */
public class CaseDetails {
    private final String case_id;
    private final String operator_id;
    private final String url_link;
    private final String time_created;
    private final String comments;
    private final String topic;
    private final String name;
    private final String surname;
    private final String gender;
    private final String age;
    private final String address;
    private final String city;
    private final String country;
    private final String email;
    private final String telephone;

    public CaseDetails(String case_id, String operator_id, String url_link, String time_created, String comments, String topic, String name, String surname, String gender, String age, String address, String city, String country, String email, String telephone) {
        this.case_id = case_id;
        this.operator_id = operator_id;
        this.url_link = url_link;
        this.time_created = time_created;
        this.comments = comments;
        this.topic = topic;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }

    public String getCase_id() {
        return case_id;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public String getUrl_link() {
        return url_link;
    }

    public String getTime_created() {
        return time_created;
    }

    public String getComments() {
        return comments;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}
