package com.gsy.storage.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.storage.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save_file_internal_file,
            btn_save_file_storage_android_file,
            btn_save_file_storage_file;
    private EditText et_file_name_file,
            et_file_content_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        findView();
        setClickListener();
    }

    private void setClickListener() {
        btn_save_file_internal_file.setOnClickListener(this);
        btn_save_file_storage_android_file.setOnClickListener(this);
        btn_save_file_storage_file.setOnClickListener(this);
    }

    private void findView() {
        btn_save_file_internal_file = (Button) findViewById(R.id.btn_save_file_internal_file);
        btn_save_file_storage_android_file = (Button) findViewById(R.id.btn_save_file_storage_android_file);
        btn_save_file_storage_file = (Button) findViewById(R.id.btn_save_file_storage_file);

        et_file_name_file = (EditText) findViewById(R.id.et_file_name_file);
        et_file_content_file = (EditText) findViewById(R.id.et_file_content_file);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = et_file_content_file.getText().toString().trim();
        save(inputText);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save_file_internal_file://????????????

                break;
            case R.id.btn_save_file_storage_android_file://??????SD???App??????????????????-Storage/android/packageName

                break;
            case R.id.btn_save_file_storage_file://??????SD?????????????????????-Storage/

                break;
        }
    }

    public void save(String inputText) {
        BufferedWriter writer = null;

        try {

            FileOutputStream fos = openFileOutput("data", Context.MODE_PRIVATE);//??????????????????????????????????????????
            OutputStreamWriter osw = new OutputStreamWriter(fos);//?????????????????????
            writer = new BufferedWriter(osw);//?????????????????????-???osw????????????????????????????????????????????????

            writer.write(inputText);//???????????????


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String load(){
        StringBuffer context = new StringBuffer();
        BufferedReader br = null;
        try {
            FileInputStream data = openFileInput("data");//???????????????
            InputStreamReader isr = new InputStreamReader(data);//??????????????????????????????
            br = new BufferedReader(isr);//??????????????????????????????
            String line = "";
            while ((line=br.readLine())!=null){//?????????????????????????????????????????????
                context.append(line);  //??????????????????????????????
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String text = context.toString();
        return text;  //?????????????????????????????????
    }

}