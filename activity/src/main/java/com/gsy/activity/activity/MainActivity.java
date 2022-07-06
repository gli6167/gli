package com.gsy.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.activity.R;
import com.orhanobut.logger.Logger;

/**
 * Activity的生命周期
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button  btn_start_second_activity,
                    btn_start_three_activity,
                    btn_start_main_activity,
                    btn_start_BindService_from_main_activity;


    public MainActivity(){

        Logger.d("MainActivity"+"-->"+"创建MainActivity对象:");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start_second_activity = findViewById(R.id.btn_start_second_activity);
        btn_start_main_activity=findViewById(R.id.btn_start_main_activity);
        btn_start_three_activity=findViewById(R.id.btn_start_three_from_main_activity);
        btn_start_BindService_from_main_activity=findViewById(R.id.btn_start_BindService_from_main_activity);

        btn_start_second_activity.setOnClickListener(this);
        btn_start_main_activity.setOnClickListener(this);
        btn_start_three_activity.setOnClickListener(this);
        btn_start_BindService_from_main_activity.setOnClickListener(this);
        Logger.d("3---->Activity" + "---->" + "onCreate:第三个activity创建");




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_second_activity:
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;

            case R.id.btn_start_main_activity:
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                break;

            case R.id.btn_start_three_from_main_activity:
                startActivity(new Intent(MainActivity.this,ThreeActivity.class));
                break;
            case R.id.btn_start_BindService_from_main_activity:
                startActivity(new Intent(MainActivity.this,BindServiceActivity.class));
                break;
        }
    }
}