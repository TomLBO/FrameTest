package com.example.retrofitdemo;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by bob
 * on 17.3.6.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.init(getApplicationContext());
    }
}
