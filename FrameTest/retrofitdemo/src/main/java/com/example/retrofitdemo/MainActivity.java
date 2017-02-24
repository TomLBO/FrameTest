package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Mac;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
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
//                Log.d(TAG, "body.login = " + body.login);
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
        post();
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
}
