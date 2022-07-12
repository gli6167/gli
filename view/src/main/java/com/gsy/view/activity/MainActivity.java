package com.gsy.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.view.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_button_activity,
            btn_start_text_activity,
            btn_start_progressbar_activity,
            btn_start_imager_activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setClickListener();

    }

    private void setClickListener() {
        btn_start_button_activity.setOnClickListener(this);
        btn_start_text_activity.setOnClickListener(this);
        btn_start_progressbar_activity.setOnClickListener(this);
        btn_start_imager_activity.setOnClickListener(this);
    }

    private void findView() {
        btn_start_button_activity = (Button) findViewById(R.id.btn_start_button_activity);
        btn_start_text_activity = (Button) findViewById(R.id.btn_start_text_activity);
        btn_start_progressbar_activity = (Button) findViewById(R.id.btn_start_progressbar_activity);
        btn_start_imager_activity = (Button) findViewById(R.id.btn_start_imager_activity);
    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.btn_start_button_activity:
                intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(intent);
                break;

        }

    }
}