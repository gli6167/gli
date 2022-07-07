package com.gsy.storage.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.storage.R;

public class SpStorageActivity extends AppCompatActivity {

    private Button btn_save_file_internal_sp,
            btn_save_file_storage_android_sp,
            btn_save_file_storage_sp,
            btn_reader_file_sp;
    private EditText et_file_name_sp,
            et_file_content_sp;

    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_storage_acctivity);


        btn_save_file_internal_sp=findViewById(R.id.btn_save_file_internal_sp);
        btn_reader_file_sp=findViewById(R.id.btn_reader_file_sp);
        btn_save_file_internal_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor data = sp.edit();
                data.putString("name","小明");
                data.putInt("age",15);
                data.putLong("nameID",612728199801143016l);
                data.apply();//自动异步的写入文件
//                data.commit()//同步写入文件，所以再使用此方法写入文件时，应避免在ui线程进行，在ui界面进行可能会导致ANO异常
            }
        });

        btn_reader_file_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp =getSharedPreferences("data",Context.MODE_PRIVATE);
                String name = sp.getString("name","");
                long nameID = sp.getLong("nameID", 0);
                int age = sp.getInt("age", 0);
                Log.d("TAG", "name: "+name);
                Log.d("TAG", "nameID: "+nameID);
                Log.d("TAG", "age: "+age);
                StringBuffer sb = new StringBuffer();
                sb.append("姓名：").append(name).append("-->").append("身份证：").append(nameID).append("-->").append("年龄：").append(age);
                Toast.makeText(SpStorageActivity.this,sb.toString(),Toast.LENGTH_LONG).show();



            }
        });

    }
}