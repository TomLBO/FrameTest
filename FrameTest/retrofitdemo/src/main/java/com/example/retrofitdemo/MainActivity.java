package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    }

    @OnClick(R.id.get)
    public void onClick() {
        get();
    }
}
