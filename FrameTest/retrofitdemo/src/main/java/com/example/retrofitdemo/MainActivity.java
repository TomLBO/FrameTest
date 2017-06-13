package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofitdemo.api.Api;
import com.example.retrofitdemo.api.DownloadAPI;
import com.example.retrofitdemo.api.HttpManager;
import com.example.retrofitdemo.api.MeetingRequest;
import com.example.retrofitdemo.bean.Login;
import com.google.gson.Gson;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadLargeFileListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.connection.FileDownloadConnection;
import com.liulishuo.filedownloader.services.DownloadMgrInitialParams;
import com.liulishuo.filedownloader.util.FileDownloadHelper;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.dreamtobe.filedownloader.OkHttp3Connection;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "haha";
    @BindView(R.id.get)
    Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Logger.init("haha");


    }

    public void test(View v) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl("http://10.100.23.12/QXZ.EMM.InterfaceSvc/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = build.create(Api.class);
        Call<String> test = api.test("");
        test.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpManager httpManager = retrofit.create(HttpManager.class);
        Call<GitHubPerson> model = httpManager.getFeed("TomLBO");
        model.enqueue(new Callback<GitHubPerson>() {
            @Override
            public void onResponse(Call<GitHubPerson> call, Response<GitHubPerson> response) {
                GitHubPerson body = response.body();
//                Log.d(TAG, "body.login = " + response.toString());
//                log.d(TAG, "body.login = " + body.login);
                Logger.d(body.login);
            }

            @Override
            public void onFailure(Call<GitHubPerson> call, Throwable t) {
                t.printStackTrace();
            }
        });


        Retrofit rxRetrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(HttpManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        rxRetrofit.create(HttpManager.class)
                .getInfo("TomLBO")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitHubPerson>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e, "onError");
                    }

                    @Override
                    public void onNext(GitHubPerson person) {
                        Logger.d(person.id);
                        Logger.d(person.login);
                    }
                });


    }

    @OnClick(R.id.get)
    public void onClick() {
//        get();
//        post();
//        meetingRequest();
        download();
    }

    private void download() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DownloadAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DownloadAPI api = retrofit.create(DownloadAPI.class);

//        Call<ResponseBody> download = api.downloadAS();
//        download.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    byte[] bytes = response.body().bytes();
//                    int a = bytes.length;
//                    Log.d(TAG, "onResponse: length " + a);
////                    File file = new File("/sdcard/as.exe");
////                    FileOutputStream stream = new FileOutputStream(file);
////                    stream.write(bytes);
////                    stream.flush();
////                    stream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
        String url = "https://dl.google.com/dl/android/studio/install/2.3.0.8/android-studio-bundle-162.3764568-windows.exe";


        PostFileDownloadConnection connection = new PostFileDownloadConnection();
        new OkHttp3Connection.Creator();

//        new FileDownloader();
        FileDownloader.init(this, new DownloadMgrInitialParams.InitCustomMaker()
                .connectionCreator(new FileDownloadHelper.ConnectionCreator() {
                    @Override
                    public FileDownloadConnection create(String url) throws IOException {

                        return null;
                    }
                }));
        FileDownloader.getImpl().create(url).setPath("/sdcard/as.exe").setListener(new FileDownloadLargeFileListener() {
            @Override
            protected void pending(BaseDownloadTask task, long soFarBytes, long totalBytes) {
                Log.d(TAG, "pending soFarBytes: " + soFarBytes);
                Log.d(TAG, "pending totalBytes: " + totalBytes);
            }

            @Override
            protected void progress(BaseDownloadTask task, long soFarBytes, long totalBytes) {
                Log.d(TAG, "progress soFarBytes: " + soFarBytes);
                Log.d(TAG, "progress totalBytes: " + totalBytes);
            }

            @Override
            protected void paused(BaseDownloadTask task, long soFarBytes, long totalBytes) {
                Log.d(TAG, "paused soFarBytes: " + soFarBytes);
                Log.d(TAG, "paused totalBytes: " + totalBytes);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                Log.d(TAG, "completed: ");
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                e.printStackTrace();
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                Log.d(TAG, "warn: ");
            }
        }).start();
    }

    void post() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);

//        String data = "\"{BundleIds:P_YDSP,SCGL,cn.com.petrochina.mOA,cn.com.petrochina.mEXP,cn.com.petrochina.mCMS,}\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("BundleIds", "P_YDSP,SCGL,cn.com.petrochina.mOA,cn.com.petrochina.mEXP,cn.com.petrochina.mCMS,");
        Gson gson = new Gson();
        String content = gson.toJson(map);
        Call<String> safe = api.getCheckAppsIsSafe(content);
        safe.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Call<Result<List<AppIsSafe>>> isSafe = api.getAppsIsSafe(content);
        isSafe.enqueue(new Callback<Result<List<AppIsSafe>>>() {
            @Override
            public void onResponse(Call<Result<List<AppIsSafe>>> call, Response<Result<List<AppIsSafe>>> response) {
                Result<List<AppIsSafe>> body = response.body();
                List<AppIsSafe> a = body.getData();
                Log.d(TAG, "onResponse: getResult " + body.getResult());
                Log.d(TAG, "onResponse: getMessage " + body.getMessage());
                Log.d(TAG, "onResponse: getError_code " + body.getError_code());
                Log.d(TAG, "onResponse: a.size" + a.size());
                for (AppIsSafe app : a) {
                    Log.d(TAG, "getBundleId: " + app.getAppbundleid() + "  IsSafe:" + app.getHaskey());
                }

            }

            @Override
            public void onFailure(Call<Result<List<AppIsSafe>>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    void meetingRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MeetingRequest.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MeetingRequest request = retrofit.create(MeetingRequest.class);

        HashMap<String, String> map = new HashMap<>();
        String s = "zhangsan";
        Call<String> meeting = request.getMeeting(s);
        meeting.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Call<ResponseBody> downloadFile = request.downloadFile("张三", "f3233a91-3aec-4770-bc94-62553e1f57ef");
        downloadFile.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();

//                InputStream stream = body.byteStream();
                File file = new File("/sdcard/typescript-handbook.pdf");
                try {
                    FileOutputStream stream1 = new FileOutputStream(file);

                    stream1.write(body.bytes());

                    stream1.flush();
                    stream1.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


    public void download(View view) {

    }

    public void pause(View view) {

    }

    public void cancel(View view) {

    }

    public void put(View view) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        String loginId = "周希瑞";
        String password = "aaa";
        Api api = build.create(Api.class);
        //put 1 json
        Login login = new Login();

        login.setAccount(loginId);
        login.setPassword(password);
        Call<ResponseBody> call = api.login(login);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "login: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        //put 2  json
        Map<String, String> body = new HashMap<>();

        body.put("LoginId", loginId);
        body.put("Password", password);

        Call<ResponseBody> call2 = api.login2(body);
        call2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "login2: " + response.body().toString());

//                String header = response.raw().headers()
                Map<String, List<String>> map = response.headers().toMultimap();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    Log.d(TAG, entry.getKey() + ": " + entry.getValue());
                }
                int code = response.code();
                Log.d(TAG, "code: " + code);

                String message = response.message();
                Log.d(TAG, "message: " + message);

                try {
                    String bodyStr = response.body().string();
                    Log.d(TAG, "bodyString: " + bodyStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                long contentLength = response.body().contentLength();

                Log.d(TAG, "contentLength: " + contentLength);

                boolean successful = response.isSuccessful();
                Log.d(TAG, "isSuccessful: " + successful);

                MediaType type = response.body().contentType();
                Log.d(TAG, "type : " + type.type());
                Log.d(TAG, "subtype : " + type.subtype());
                Log.d(TAG, "charset : " + type.charset());
                Log.d(TAG, "type.toString : " + type.toString());


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        //put 3 key value
        Call<ResponseBody> call3 = api.login3(loginId, password);
        call3.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "login3: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        Call<ResponseBody> call4 = api.login4(body);
        call4.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "login4: " + response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
