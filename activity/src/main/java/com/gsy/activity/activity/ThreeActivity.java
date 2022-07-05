package com.gsy.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.activity.R;
import com.orhanobut.logger.Logger;

public class ThreeActivity extends AppCompatActivity {
    private Button btn_return_data_second,btn_return_second,btn_start_second_from_three_activity,btn_start_main_from_three_activity;
    private EditText et_three_data;

    public ThreeActivity(){
        Logger.d("ThreeActivity"+"-->"+"创建ThreeActivity对象");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        et_three_data = (EditText) findViewById(R.id.et_three_data);
        btn_return_data_second = (Button) findViewById(R.id.btn_return_data_second);
        btn_return_second=(Button)findViewById(R.id.btn_return_second) ;

        btn_start_main_from_three_activity = findViewById(R.id.btn_start_main_from_three_activity);
        btn_start_second_from_three_activity=findViewById(R.id.btn_start_second_from_three_activity);

        Logger.d("2---->Activity" + "---->" + "onCreate:第二个activity创建");

    }

    public String getRequestData(){
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        return data;
    }
    public void setResultData() {
        String data = et_three_data.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("result", data);
        int resultCode = 2;
        setResult(resultCode, intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        btn_return_data_second.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setResultData();
                finish();
            }
        });

        btn_return_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_start_second_from_three_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreeActivity.this,SecondActivity.class));
            }
        });

        btn_start_main_from_three_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreeActivity.this,MainActivity.class));
            }
        });
        Logger.d("2---->Activity" + "---->" + "onStart:第二个activity进入前台");
    }

    @Override
    protected void onResume() {
        super.onResume();

        et_three_data.setText(getRequestData());
        Logger.d("2---->Activity" + "---->" + "onResume:第二个activity获得焦点");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("2---->Activity" + "---->" + "onPause:第二个activity失去焦点");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d("2---->Activity" + "---->" + "onRestart:第二个activity准备从后台再次进入前台");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("2---->Activity" + "---->" + "onStop:第二个activity进入后台");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("2---->Activity" + "---->" + "onDestroy:第二个activity销毁");

    }
}