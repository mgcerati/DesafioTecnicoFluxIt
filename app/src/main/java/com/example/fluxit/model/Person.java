package com.example.fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person implements Serializable {

    private static final String IMAGE_URL = "https://randomuser.me/api/portraits/";

    @SerializedName("name")
    private Name name;
    @SerializedName("login")
    private Login login;
    @SerializedName("dob")
    private Dob dob;
    @SerializedName("email")
    private String email;
    @SerializedName("picture")
    private Photo photo;
    @SerializedName("location")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }

    public Login getLogin() {
        return login;
    }

    public Dob getDob() {
        return dob;
    }

    public Photo getPhoto() {
        return photo;
    }


    public Person(String email) {
        this.email = email;
            }

    public static String getImageUrl() { return IMAGE_URL; }

    public String getEmail() { return email; }

}
