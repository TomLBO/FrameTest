package com.bob.butterknifedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 不知道为啥 8.0.1版本的ButterKnife需要加上 "com.neenbedankt.gradle.plugins:android-apt:1.8"
 */
public class MainActivity extends Activity {
    private static final String TAG = "haha";


//    @Bind({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4})
//    List<TextView> tvs;


    @BindString(R.string.test)
    String test;
    @BindString(R.string.test2)
    String test2;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.bt4)
    Button bt4;
    @BindView(R.id.bt5)
    Button bt5;
    @BindView(R.id.bt6)
    Button bt6;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.toggleButton)
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO ButterKnife 使用前需要绑定
        //TODO Activity中绑定: 在onCreate要使用 : ButterKnife.bind(this)
        //TODO  fragment中中绑定: 在onCreateView中 : ButterKnife.bind(this, view);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: test = " + test);
        Log.d(TAG, "onCreate: test2 = ");

//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: bt111");
//            }
//        });
//        ButterKnife.apply(tvs,);

    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6, R.id.toggleButton})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                Log.d(TAG, "onClick: bt1");
                tv1.setText(test);
                break;
            case R.id.bt2:
                Log.d(TAG, "onClick: bt2");
                tv2.setText(test2);
                break;
            case R.id.bt3:
                Log.d(TAG, "onClick: bt3");
                break;
            case R.id.bt4:
                Log.d(TAG, "onClick: bt4");
                break;
            case R.id.bt5:
                Log.d(TAG, "onClick: bt5");
                break;
            case R.id.bt6:
                Log.d(TAG, "onClick: bt6");
                break;
            case R.id.toggleButton:
                break;
        }
    }


//    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.bt1:
//                Log.d(TAG, "onClick: bt1");
//                tv1.setText(test);
//                break;
//            case R.id.bt2:
//                Log.d(TAG, "onClick: bt2");
//                break;
//            case R.id.bt3:
//                Log.d(TAG, "onClick: bt3");
//                break;
//            case R.id.bt4:
//                Log.d(TAG, "onClick: bt4");
//                break;
//            case R.id.bt5:
//                Log.d(TAG, "onClick: bt5");
//                break;
//            case R.id.bt6:
//                Log.d(TAG, "onClick: bt6");
//                break;
//        }
//    }
}
