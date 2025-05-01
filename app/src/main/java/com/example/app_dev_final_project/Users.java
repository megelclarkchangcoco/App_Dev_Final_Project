package com.example.app_dev_final_project;

public class Users {

    private  String id;
    private  String fullname;
    private   String phonenumbers;
    private   String username;
    private   String password;

    // Constructor
    public Users(String id, String fullname, String phonenumbers, String username, String password) {
        this.id = id;
        this.fullname = fullname;
        this.phonenumbers = phonenumbers;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }


    public String getPhonenumbers() {
        return phonenumbers;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

}
