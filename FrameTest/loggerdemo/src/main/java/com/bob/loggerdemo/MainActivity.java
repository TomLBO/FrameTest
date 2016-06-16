package com.bob.loggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bob.loggerdemo.log.LogUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Logger.init("haha");
//        Logger.v("hello world");
//        Logger.d("hello world");
//        Logger.i("hello world");
//        Logger.e("hello world");
//        LogUtil.d("haha", "hehe");
//        LogUtil.d("haha", "hehe");
        LogUtil.d("haha", "hehe");

    }
}
