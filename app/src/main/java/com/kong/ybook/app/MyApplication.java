package com.kong.ybook.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.xutils.x;

/**
 * Created by konglingyu on 2017/2/10.
 */

public class MyApplication extends Application{
    private static MyApplication context;
    private static RequestQueue queue;

    public static RequestQueue getQueue() {
        return queue;
    }

    public static void setQueue(RequestQueue queue) {
        MyApplication.queue = queue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        queue= Volley.newRequestQueue(context);
        //初始化XUtils
        x.Ext.init(this);
    }

    public static MyApplication getContext() {
        return context;
    }

    public static void setContext(MyApplication context) {
        MyApplication.context = context;
    }

}
