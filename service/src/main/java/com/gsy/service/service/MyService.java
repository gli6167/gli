package com.gsy.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MyServiceBinder myServiceBinder =new MyServiceBinder();//实例化MyServiceBinder

    public MyService(){
        Log.d("TAG", "MyService: ");
    }

    public class MyServiceBinder extends Binder{//一个携带MyService数据的bind基类，这个bind基类返回的是这个MyService
        public MyService getMyService(){
            return MyService.this;
        }
    }

    public void shou(){
        Log.i("TAG", "MyService-->shou: ");
    }

    @Nullable
    @Override
    //绑定服务
    public IBinder onBind(Intent intent) {
        Log.i("TAG", "MyService--"+"onBind: ");
        return myServiceBinder;//返回这个MyService实例
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "MyService--"+"onCreate: "+Thread.currentThread().getName());

    }
//启动服务


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG", "MyService--"+"onStartCommand: ");

        return super.onStartCommand(intent, flags, startId);
    }

    //解绑服务
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TAG", "MyService--"+"onUnbind: ");
        return super.onUnbind(intent);
    }
//销毁服务
    @Override
    public void onDestroy() {
        Log.d("TAG", "MyService--"+"onDestroy: ");
        super.onDestroy();
    }
}
