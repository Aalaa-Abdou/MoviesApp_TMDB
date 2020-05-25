package com.example.moviesapp.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();

        return retrofit;
    }

}
