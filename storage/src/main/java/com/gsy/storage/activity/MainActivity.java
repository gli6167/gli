package com.gsy.storage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.storage.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_sp_storage_main,
            btn_start_file_storage_main,
            btn_start_sqlite_storage_main;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setClickListener();
    }

    private void setClickListener() {
        btn_start_sp_storage_main.setOnClickListener(this);
        btn_start_file_storage_main.setOnClickListener(this);
        btn_start_sqlite_storage_main.setOnClickListener(this);
    }

    private void findView() {
        btn_start_sp_storage_main = (Button) findViewById(R.id.btn_start_sp_storage_main);
        btn_start_file_storage_main = (Button) findViewById(R.id.btn_start_file_storage_main);
        btn_start_sqlite_storage_main = (Button) findViewById(R.id.btn_start_sqlite_storage_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_sp_storage_main:
                intent = new Intent(MainActivity.this, SpStorageActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_start_file_storage_main:
                intent = new Intent(MainActivity.this,FileStorageActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_start_sqlite_storage_main:
                intent = new Intent(MainActivity.this, SqliteStorageActivity.class);
                startActivity(intent);
                break;
        }

    }
}