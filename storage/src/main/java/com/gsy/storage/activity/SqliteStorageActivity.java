package com.gsy.storage.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.storage.R;
import com.gsy.storage.database.MyDataBase;

public class SqliteStorageActivity extends AppCompatActivity {
    private MyDataBase myDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_stroage);
        Log.i("TAG", "SqliteStorageActivity-->"+"onCreate: ");
    }

    public void createDb(View view) {
        myDataBase = new MyDataBase(SqliteStorageActivity.this);
        Log.i("TAG", "SqliteStorageActivity---->"+"createDb: ");
        myDataBase.getWritableDatabase();//将数据库写入硬盘

    }
}