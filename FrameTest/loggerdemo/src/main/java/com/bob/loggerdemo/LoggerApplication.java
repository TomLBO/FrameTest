package com.bob.loggerdemo;

import android.app.Application;

import com.bob.loggerdemo.log.LogUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by bob on 2016/5/10.
 */
public class LoggerApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
//        Logger.init("haha");
//        Logger.i("hello logger");
        // TODO Logger使用前初始化 可以在application中初始化
        LogUtil.init("haha");
        LogUtil.d("haha", "hehe");

    }
}
