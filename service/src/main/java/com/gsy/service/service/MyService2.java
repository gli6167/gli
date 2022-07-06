package com.gsy.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.gsy.service.ISideService;

public class MyService2 extends Service {
   private MyService2Binder myService2Binder = new MyService2Binder();


   class  MyService2Binder extends Binder{
       public MyService2 getMyService2(){
           return MyService2.this;
       }

   }

    private String data = "默认数据";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG", "MyService2-->" + "onCreate: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i("TAG", "MyService2-->" + "onBind: ");
      return new ISideService.Stub() {
          @Override
          public void setData(String s) throws RemoteException {
              MyService2.this.data = s;
          }

          @Override
          public String getData() throws RemoteException {
              return data;
          }
      };


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("TAG", "MyService2-->" + "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "MyService2-->" + "onDestroy: ");
    }
}
