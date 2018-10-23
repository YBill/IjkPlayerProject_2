package com.bill.ijkplayerproject_2;

import android.app.Application;

/**
 * Created by Bill on 2018/10/23.
 * Application
 */

public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static MyApplication getApplication() {
        return application;
    }
}
