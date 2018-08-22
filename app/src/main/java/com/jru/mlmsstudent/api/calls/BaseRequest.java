package com.jru.mlmsstudent.api.calls;

import com.jru.mlmsstudent.api.ApiClient;
import com.jru.mlmsstudent.api.ApiInterface;

public class BaseRequest {

    private static ApiInterface api = null;
    private static ApiInterface securedApi = null;

    public static ApiInterface getApi() {
        if (api == null)
            api = ApiClient.getApiInterface();
        return api;
    }

    public static ApiInterface getSecuredApi(String header) {
        if (securedApi == null)
            securedApi = ApiClient.getSecuredApiInterface(header);

        return securedApi;
    }

}
