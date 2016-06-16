package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by bob on 16.6.12.
 */
public interface HttpManager {
    String BASE_URL = "https://api.github.com";

    @GET("users/{user}")
    Call<GitHubPerson> getFeed(@Path("user") String user);

}
