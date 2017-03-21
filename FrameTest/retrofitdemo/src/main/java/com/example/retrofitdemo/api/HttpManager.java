package com.example.retrofitdemo.api;

import com.example.retrofitdemo.GitHubPerson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by bob on 16.6.12.
 */
public interface HttpManager {
    String BASE_URL = "https://api.github.com";

    @GET("users/{user}")
    Call<GitHubPerson> getFeed(@Path("user") String user);

    @GET("users/{user}")
    Observable<GitHubPerson> getInfo(@Path("user") String user);

}
