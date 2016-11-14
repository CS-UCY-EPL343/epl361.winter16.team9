package com.cmsl.entities;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class PersonalDetails {
    private final String name;
    private final String surname;
    private final int age;
    private final String email;
    private final String address;
    private final String city;
    private final String country;

    public PersonalDetails(String name, String surname, int age, String email, String address, String city, String country) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
