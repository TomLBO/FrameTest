package com.bob.frescodemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mIcon;

    private String path = "http://h.hiphotos.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=334c29fd34a85edfee81f671283d6246/1f178a82b9014a90797e0610a9773912b21beedf.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Fresco初始化,必须在setContentView之前,可以放在Application的onCreate中
//        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        Uri uri = Uri.parse(path);
        mIcon.setImageURI(uri);

    }

    private void initData() {

    }

    private void initView() {
        mIcon = (SimpleDraweeView) findViewById(R.id.icon_image);
    }
}
