package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

public class SendRegistration {

    private String name;

    private String email;

    private String password;

    @SerializedName("user_type")
    private String userType;

    public SendRegistration(String name, String email, String password, String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}
