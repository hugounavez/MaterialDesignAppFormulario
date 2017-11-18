package com.example.macuser.materialdesignappformulario.Model;

/**
 * Created by macuser on 11/18/17.
 */

import com.google.gson.Gson;

public class User {
    private String fullname;
    private String birthDate;
    private String phone;
    private String email;
    private String contactDescription;

    public User(String fullname, String birthDate, String phone, String email, String contactDescription){
        // Constructor
        this.setFullname(fullname);
        this.setBirthDate(birthDate);
        this.setPhone(phone);
        this.setEmail(email);
        this.setContactDescription(contactDescription);

    }

    public String toJson(){
        return new Gson().toJson(this);
    }

    public static User fromJson(String json){
        return new Gson().fromJson(json, User.class);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }
}
