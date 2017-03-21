package com.example.retrofitdemo.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

/**
 * Created by bob
 * on 17.3.6.
 */

public interface DownloadAPI {
//https://dl.google.com/dl/android/studio/install/2.3.0.8/android-studio-bundle-162.3764568-windows.exe

    String BASE_URL = "https://dl.google.com/dl/android/studio/";

    @Streaming
    @GET("install/2.3.0.8/android-studio-bundle-162.3764568-windows.exe")
    Call<ResponseBody> downloadAS();


    @GET("install/2.3.0.8/android-studio-bundle-162.3764568-windows.exe")
    Call<ResponseBody> downloadWeiXin();
}
