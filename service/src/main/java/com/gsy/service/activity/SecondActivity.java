package com.gsy.service.activity;

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

import com.gsy.service.ISideService;
import com.gsy.service.R;
import com.gsy.service.service.MyService2;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_service_second;
    private Button btn_stop_service_second,
            btn_bind_service_second,
            btn_unbind_service_second;
    private EditText et_result_second;
    public SecondActivity(){
        Log.i("TAG", "SecondActivity: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findView();
        setClickListeren();
        Log.i("TAG", "SecondActivity--"+"onCreate");
    }

    private void setClickListeren() {
        btn_stop_service_second.setOnClickListener(this);
        btn_start_service_second.setOnClickListener(this);
        et_result_second.setOnClickListener(this);
    }

    private void findView() {
        btn_start_service_second=findViewById(R.id.btn_start_service_second);
        btn_stop_service_second=findViewById(R.id.btn_stop_service_second);
        et_result_second=findViewById(R.id.et_result_second);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_service_second:
                startService(new Intent(SecondActivity.this, MyService2.class));
                break;
            case R.id.btn_stop_service_second:
               stopService(new Intent(SecondActivity.this, MyService2.class));
                break;

        }
    }
private ServiceConnection coon = new ServiceConnection() {

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        String serviceActivityRequest = et_result_second.getText().toString().trim();//得到et的数据
        ISideService myService = ISideService.Stub.asInterface(service);
        try {
            myService.setData(serviceActivityRequest);//将数据保存在Service中
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
};

    public void bindService(View view) {
        Intent intent = new Intent(SecondActivity.this,MyService2.class);


        bindService(intent,coon, Context.BIND_AUTO_CREATE);

    }

    public void ubBindService(View view) {
        unbindService(coon);
    }
}