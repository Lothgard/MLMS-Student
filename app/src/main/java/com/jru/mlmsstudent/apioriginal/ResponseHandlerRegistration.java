package com.jru.mlmsstudent.apioriginal;

public class ResponseHandlerRegistration {

    private RegistrationData data;

    private String message;

    public ResponseHandlerRegistration(RegistrationData data, String message) {
        this.data = data;
        this.message = message;
    }

    public RegistrationData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
