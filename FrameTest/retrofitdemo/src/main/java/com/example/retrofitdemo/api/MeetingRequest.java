package com.example.retrofitdemo.api;

import com.example.retrofitdemo.bean.MeetingBean;

import java.io.File;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by bob
 * on 17.3.6.
 */

public interface MeetingRequest {


//    @POST()
//    Call<File> downloadFile(@Field() String );

    String BASE_URL = "http://211.157.187.232/QMeetingInterface/api/";
    @FormUrlEncoded
    @POST("Meeting/GetNeedJoinMeetings")
//    Call<String> getMeeting(@Body String json);
//    Call<String> getMeeting(@Field("") String json);
    Call<String> getMeeting(@Field("LoginId") String loginId);

    @FormUrlEncoded
    @POST("File/DownloadDocument")
    Call<ResponseBody> downloadFile(@Field("LoginId") String loginId, @Field("FileId") String fileId);



    //"http://dldir1.qq.com/weixin/android/weixin654android1000.apk"
//https://dl.google.com/dl/android/studio/install/2.3.0.8/android-studio-bundle-162.3764568-windows.exe
    @GET
    Call<ResponseBody> downloadWeiXin();

}
