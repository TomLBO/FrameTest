package com.bob.frescodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by bob on 2016/4/28.
 */
public class MApplication extends Application{

    @Override
    public void onCreate() {
        Fresco.initialize(this);
        super.onCreate();
    }

}
