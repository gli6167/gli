package com.gsy.activity.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.activity.R;
import com.gsy.service.ISideService;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_serviceApp,
            btn_stop_serviceApp,
            btn_bind__serviceApp,
            btn_unBind_serviceApp;
    private EditText et_bindService_data;
    private Intent intent;
    private ServiceConnection coon;
    private final String start_packageName = "com.gsy.service";
    private final String start_className = "com.gsy.service.service.MyService2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        intent = new Intent();
        intent.setComponent(new ComponentName(start_packageName,start_className));//设置启动的service的包名及类名
        intent.setAction("com.gsy.service.MyService2");
        findView();
        setClickListener();
        getServiceConnection();
    }

    private ServiceConnection getServiceConnection() {
        coon = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {//当服务绑定时
                ISideService iSideService = ISideService.Stub.asInterface(service);

                try {
                    String data = iSideService.getData();//得到Service中被修改过的另一个App的Activity的数据
                    et_bindService_data.setText(data);//将结果设置进去
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Log.i("TAG", "BindServiceActivity--->" + "onServiceConnected: ");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {//当服务因系统断开时
            }
        };
        return coon;
    }

    private void findView() {
        btn_start_serviceApp = findViewById(R.id.btn_start_serviceApp);
        btn_stop_serviceApp = findViewById(R.id.btn_stop_serviceApp);
        btn_bind__serviceApp = findViewById(R.id.btn_bind__serviceApp);
        btn_unBind_serviceApp = findViewById(R.id.btn_unBind_serviceApp);
        et_bindService_data = findViewById(R.id.et_bindService_data);
    }

    private void setClickListener() {
        btn_start_serviceApp.setOnClickListener(this);
        btn_stop_serviceApp.setOnClickListener(this);
        btn_bind__serviceApp.setOnClickListener(this);
        btn_unBind_serviceApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_serviceApp:
                startService(intent);
                Log.i("TAG", "BindServiceActivity--->" + "onClick: startService");
                break;
            case R.id.btn_stop_serviceApp:
                stopService(intent);
                Log.i("TAG", "BindServiceActivity--->" + "onClick: stopService");
                break;
            case R.id.btn_bind__serviceApp:
                bindService(intent, coon, Context.BIND_ABOVE_CLIENT);
                Log.i("TAG", "BindServiceActivity--->" + "onClick: bindService");

                break;
            case R.id.btn_unBind_serviceApp:
                unbindService(coon);
                Log.i("TAG", "BindServiceActivity--->" + "onClick: unbindService");
                break;
        }

    }
}