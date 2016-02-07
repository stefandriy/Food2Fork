package com.teamvoy.cam.food2fork.service;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RestService {

    public static final String API_KEY = "444360c4cee4a89431df6c03e6ce3b83";
    public static final String BASE_URL = "http://food2fork.com";

    private static RestService restService;
    Food2ForkService f2fService;

    private RestService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        f2fService = retrofit.create(Food2ForkService.class);
    }

    public static Food2ForkService instance() {
        if (restService == null)
            restService = new RestService();
        return restService.f2fService;
    }
}
