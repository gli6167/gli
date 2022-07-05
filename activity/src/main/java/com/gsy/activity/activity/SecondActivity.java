package com.gsy.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.activity.R;
import com.orhanobut.logger.Logger;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_three_activity, btn_bind_start_three_activity,btn_start_main_from_second_activity,btn_start_second_from_second_activity;
    private EditText et_second_data;
    private Intent intent;

    public SecondActivity(){
        Logger.d("SecondActivity"+"-->"+"创建SecondActivity对象");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_start_three_activity = findViewById(R.id.btn_start_three_activity);
        btn_bind_start_three_activity = findViewById(R.id.btn_bind_start_three_activity);

        btn_start_main_from_second_activity = findViewById(R.id.btn_start_main_from_second_activity);

        btn_start_second_from_second_activity=findViewById(R.id.btn_start_second_from_second_activity);



        et_second_data=(EditText) findViewById(R.id.et_second_data);

        Logger.d("1-->Activity" + "---->" + "onCreate:第一个activity创建");
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_start_three_activity.setOnClickListener(this);
        btn_bind_start_three_activity.setOnClickListener(this);
        btn_start_main_from_second_activity.setOnClickListener(this);
        btn_start_second_from_second_activity.setOnClickListener(this);
        Logger.d("1-->Activity" + "---->" + "onStart:第一个activity进入前台");
    }

    @Override
    protected void onResume() {
        super.onResume();


        Logger.d("1-->Activity" + "---->" + "onResume:第一个activity获得焦点");

    }

    @Override
    protected void onPause() {
        super.onPause();


        Logger.d("1-->Activity" + "---->" + "onPause:第一个activity失去焦点");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("1-->Activity" + "---->" + "onStop:第一个activity进入后台");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d("1-->Activity" + "---->" + "onRestart:第一个activity从后天再次准备进入前台");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("1-->Activity" + "---->" + "onDestroy:第一个activity销毁");

    }

    @Override
    public void onClick(View v) {
       String data = et_second_data.getText().toString().trim();
        switch (v.getId()) {
            case R.id.btn_start_three_activity:
                startActivity(new Intent(this, ThreeActivity.class));
                break;
            case R.id.btn_bind_start_three_activity://携带数据启动
                intent = new Intent(this,ThreeActivity.class);
                intent.putExtra("data",data);
                int requestCode = 1;
                startActivityForResult(intent,requestCode);
                break;
            case R.id.btn_start_main_from_second_activity:
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                break;
            case R.id.btn_start_second_from_second_activity:
                startActivity(new Intent(SecondActivity.this,SecondActivity.class));
                break;

        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==1&&resultCode==2){
//            String result =data.getStringExtra("result");
//            et_second_data.setText(result);
//        }
//    }
}