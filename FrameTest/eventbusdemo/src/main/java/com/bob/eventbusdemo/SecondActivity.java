package com.bob.eventbusdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bob.eventbusdemo.EventBus.FirstEvent;
import com.bob.eventbusdemo.EventBus.FourthEvent;
import com.bob.eventbusdemo.EventBus.SecondEvent;
import com.bob.eventbusdemo.EventBus.ThirdEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.content)
    TextView content;
    //    @BindView(R.id.sendMessage)
//    Button sendMessage;
    @BindView(R.id.first)
    Button first;
    @BindView(R.id.second)
    Button second;
    @BindView(R.id.third)
    Button third;
    @BindView(R.id.four)
    Button four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.first, R.id.second, R.id.third, R.id.four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first:
                Log.d("haha", "FirstEvent: ");
//                EventBus.getDefault().post(new FirstEvent("FirstEvent"));
                run(new FirstEvent("FirstEvent"));
                break;
            case R.id.second:
                Log.d("haha", "SecondEvent: ");
//                EventBus.getDefault().post(new SecondEvent("SecondEvent"));
                run(new SecondEvent("SecondEvent"));
                break;
            case R.id.third:
                Log.d("haha", "ThirdEvent: ");
//                EventBus.getDefault().post(new ThirdEvent("ThirdEvent"));
                run(new ThirdEvent("ThirdEvent"));
                break;
            case R.id.four:
                Log.d("haha", "FourthEvent: ");
//                EventBus.getDefault().post(new FourthEvent("FourthEvent"));
                run(new FourthEvent("FourthEvent"));
                break;
        }
    }

//    @OnClick(R.id.sendMessage)
//    public void onClick() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                EventBus.getDefault().post(new FirstEvent("from secondActivity"));
//            }
//        }).start();
//    }

//    @Subscribe
//    public void onEvent(MessageEvent event) {
//        Toast.makeText(SecondActivity.this, "SecondActivity has a message -->" + event.message, Toast.LENGTH_SHORT).show();
//
//    }
//    @Subscribe( threadMode = ThreadMode.MAIN)
//    public void onEvent(FirstEvent event) {
//        Toast.makeText(SecondActivity.this, "SecondActivity has a message -->" + event.message, Toast.LENGTH_SHORT).show();
//
//    }

    public Handler handler = new Handler();

    private void run(final Object event) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                EventBus.getDefault().post(event);
//            }
//        }).start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(event);
            }
        }, 5000);
    }
}
