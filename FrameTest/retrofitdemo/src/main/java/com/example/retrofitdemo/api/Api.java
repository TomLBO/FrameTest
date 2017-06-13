package com.example.retrofitdemo.api;

import com.example.retrofitdemo.AppIsSafe;
import com.example.retrofitdemo.Result;
import com.example.retrofitdemo.bean.Login;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by bob
 * on 17.2.24.
 */

public interface Api {

    public static final String BASE_URL = "http://www.baidu.com/api/";
    public static String token = "eyJBY2NvdW50IjoiUFRSL3lxZmVuZyIsIkRldmljZVNOIjoiODY4MTkyMDIwNTc2NDMxIiwiSGFzS2V5IjowfQ==";

    @FormUrlEncoded
    @Headers("Token: " + token)
    @POST("App/CheckAppsIsSafe")
    Call<String> getCheckAppsIsSafe(@Field("") String data);


//    http://10.100.23.12/QXZ.EMM.InterfaceSvc/api/OU/test

    @FormUrlEncoded
    @POST("api/OU/test")
    Call<String> test(@Field("") String data);

    @FormUrlEncoded
    @Headers("Token: " + token)
    @POST("App/CheckAppsIsSafe")
    Call<Result<List<AppIsSafe>>> getAppsIsSafe(@Field("") String data);

    @FormUrlEncoded
    @Headers("Token: " + token)
    @POST("App/CheckAppsIsSafe")
    Call<Result<AppIsSafe>> getIsSafe(@FieldMap Map<String, String> map);


    @POST("api/Login")
    Call<ResponseBody> login(@Body Login login);

    @POST("api/Login")
    Call<ResponseBody> login2(@Body Map<String, String> body);

    @FormUrlEncoded
    @POST("api/Login")
    Call<ResponseBody> login3(@Field("LoginId") String loginId,
                              @Field("Password") String password);

    @FormUrlEncoded
    @POST("api/Login")
    Call<ResponseBody> login4(@FieldMap Map<String, String> body);
}
