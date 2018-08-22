package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

public class RegistrationData {

    private String email;

    private String name;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    private int id;

    public RegistrationData(String email, String name, String updatedAt, String createdAt, int id) {
        this.email = email;
        this.name = name;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }
}
