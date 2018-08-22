package com.jru.mlmsstudent.apioriginal;

import com.jru.mlmsstudent.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager mInstance;

    private RetrofitManager() {}

    public static RetrofitManager getInstance() {
        return mInstance == null ? new RetrofitManager() : mInstance;
    }

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


}
