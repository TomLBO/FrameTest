package com.bob.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.eventbusdemo.EventBus.FirstEvent;
import com.bob.eventbusdemo.EventBus.FourthEvent;
import com.bob.eventbusdemo.EventBus.MessageEvent;
import com.bob.eventbusdemo.EventBus.SecondEvent;
import com.bob.eventbusdemo.EventBus.ThirdEvent;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.sendMessage)
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Logger.init("haha");
        //TODO EventBus使用前要初始化 注册订阅者
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {

//        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        //TODO 结束时要取消注册 在onStop取消时,activity被覆盖时就接收不到信息,在onDestroy取消可以接受到
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @OnClick({R.id.next, R.id.sendMessage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.sendMessage:
                Intent i = new Intent(this, FragmentActivity.class);
                startActivity(i);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        EventBus.getDefault().post(new FirstEvent("from MainActivity"));
//                    }
//                }).start();
                break;
        }
    }
    @Subscribe
    public void onEvent(MessageEvent event) {
        Toast.makeText(MainActivity.this, "MainActivity has a message -->" +event.message, Toast.LENGTH_SHORT).show();

    }
//
//    @Subscribe( threadMode = ThreadMode.MAIN)
//    public void onMessage(FirstEvent event) {
////        Toast.makeText(SecondActivity.this, "SecondActivity has a message -->" + event.message, Toast.LENGTH_SHORT).show();
//        content.setText(event.message);
//        Log.d("haha", "onMessage: event.message" + event.message);
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FirstEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.i(event.message);
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(SecondEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.i(event.getMessage());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(ThirdEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.i(event.getMessage());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent(FourthEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.i(event.getMessage());
    }
}
