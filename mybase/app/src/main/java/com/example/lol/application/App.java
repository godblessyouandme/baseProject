package com.example.lol.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2016/3/10.
 */
public class App extends Application {

    private static Context context;//全局的上下文
    private static Handler mainHandler;//全局的handler
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Context
        context = this;

        //初始化mainHandler
        mainHandler = new Handler();
    }

    public static Context getContext(){
        return context;
    }
    public static Handler getMainHandler(){
        return mainHandler;
    }


}
