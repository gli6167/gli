package com.gsy.fragment.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gsy.fragment.R;
import com.gsy.fragment.fragment.FirstFragment;
import com.gsy.fragment.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.IOnMessageClick {
private Button btn_add_Fragment_main;
private SecondFragment BFragment;
private FirstFragment AFragment;
private TextView tv_data;
private static final String name = "MainActivity :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_Fragment_main=findViewById(R.id.btn_add_Fragment_main);
        tv_data=(TextView) findViewById(R.id.tv_data);

        AFragment = new FirstFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fl_shou_fragment_main,AFragment,"a");
        fragmentTransaction.commitAllowingStateLoss();
        btn_add_Fragment_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BFragment = new SecondFragment();
                getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.fl_shou_fragment_main,BFragment).commit();
            }
        });
        Log.i("TAG", name+"onCreate: "+" Activity创建");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", name+"onStart: "+" Activity前台可见");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", name+"onResume: "+" Activity获取焦点");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", name+"onPause: "+" Activity失去焦点");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", name+"onRestart: " + " Activity准被进入前台");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", name+"onStop: " + " Activity后台可见");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", name+"onDestroy: ");

    }

    @Override
    public void click(String text) {
        tv_data.setText(text);
    }
}