package com.cmsl.db.entities;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class Operator {

    private final String operator_id;
    private final String name;
    private final String surname;
    private final String telephone;
    private final String email;
    private final String username;
    private final String password;
    private final String salt;

    public String getOperator_id() {
        return operator_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public Operator(String operator_id, String name, String surname, String telephone, String email, String username, String password, String salt) {
        this.operator_id = operator_id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
