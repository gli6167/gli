package com.gsy.service.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.service.R;
import com.gsy.service.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_start_local_service_main,
            btn_stop_local_service_main,
            btn_start_second_activity,
            btn_bind_service_main,
            btn_unbind_service_main;

    public MainActivity(){
        Log.i("TAG", "MainActivity: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        setClickListener();
        getServiceCoonection();
        Log.i("TAG", "MainActivity--"+"onCreate: "+Thread.currentThread().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "MainActivity--"+"onStart: ");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "MainActivity--"+"onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "MainActivity--"+"onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "MainActivity--"+"onStop: ");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("TAG", "MainActivity--"+"onDestroy: ");
        if (coon!=null){
            unbindService(coon);
            Log.i("TAG", "MainActivity--"+"onDestroy: -"+"unbindService"+"生命周期与Activity关联解绑服务");
            coon=null;
        }else {
            Log.i("TAG", "MainActivity--"+"onDestroy: "+"unbindService"+"生命周期与Activity关联服务未注册");
        }
    }

    private void setClickListener() {
        btn_stop_local_service_main.setOnClickListener(this);
        btn_start_local_service_main.setOnClickListener(this);
        btn_start_second_activity.setOnClickListener(this);
        btn_bind_service_main.setOnClickListener(this);
        btn_unbind_service_main.setOnClickListener(this);
    }

    private void findView() {
        btn_start_local_service_main = findViewById(R.id.btn_start_local_service_main);
        btn_stop_local_service_main=findViewById(R.id.btn_stop_local_service_main);
        btn_start_second_activity=findViewById(R.id.btn_start_second_activity);
        btn_bind_service_main=findViewById(R.id.btn_bind_service_main);
        btn_unbind_service_main=findViewById(R.id.btn_unbind_service_main);
    }
    private ServiceConnection coon  ;

    private ServiceConnection getServiceCoonection(){
        coon = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {//建立连接的时候才回调此方法，且只调用一次
                        MyService.MyServiceBinder myServiceBinder = (MyService.MyServiceBinder) service;//获取到MyServiceBinder
                        MyService myService = myServiceBinder.getMyService();//获取到MyService
                        myService.shou();//执行shou方法
                        Log.i("TAG", "onServiceConnected: "+"与服务连接");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {//unBindService不会调用此方法，
                        Log.i("TAG", "onServiceDisconnected: "+"与服务非正常断开断开");
                    }
                };
        return coon;
    }



    @Override
    public void onClick(View v) {
        Intent intent  =new Intent(MainActivity.this, MyService.class);;
        switch (v.getId()){
            case R.id.btn_start_local_service_main://启动服务
                startService(intent);
                Log.i("TAG", "MainActivity--"+"onClick: "+"启动服务");
                break;
            case R.id.btn_stop_local_service_main://停止服务
                stopService(intent);
                Log.i("TAG", "MainActivity--"+"onClick: "+"停止服务");
                break;

            case R.id.btn_bind_service_main://绑定服务

                    bindService(intent,coon, Context.BIND_AUTO_CREATE);
                    Log.i("TAG", "MainActivity--"+"onClick: "+"绑定服务");
                break;

            case R.id.btn_unbind_service_main://解绑服务
                if(coon!=null){
                    unbindService(coon);
                    coon=null;
                }else {
                    Log.i("TAG", "MainActivity--"+"onClick: "+"解绑-服务未注册");
                }

                Log.i("TAG", "MainActivity--"+"onClick: "+"解绑服务");
                break;
            case R.id.btn_start_second_activity://进入第二界面
               startActivity(new Intent(MainActivity.this,SecondActivity.class));
                Log.i("TAG", "MainActivity--"+"onClick: "+"进入第二界面");

                break;
        }
    }
}