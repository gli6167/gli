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
import com.gsy.fragment.fragment.AFragment;
import com.gsy.fragment.fragment.BFragment;

// hide
// remove 移除对应的 如果添加后退站，影响生命周期
// show
// replace 把所有都remove,替换成添加的fragment
// 后退栈影响 remove replace 和返回逻辑
public class MainActivity extends AppCompatActivity implements com.gsy.fragment.fragment.AFragment.IOnMessageClick {
    private Button btn_add_Fragment_main;
    private com.gsy.fragment.fragment.BFragment BFragment;
    private com.gsy.fragment.fragment.AFragment AFragment;
    private TextView tv_data;

    public static final String NAME_BACK_STACK = "main";
    public static final boolean needBackStack = true;

    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, TAG + "-onCreate: " + " Activity创建");
        setContentView(R.layout.activity_main);
        btn_add_Fragment_main = findViewById(R.id.btn_add_Fragment_main);
        tv_data = (TextView) findViewById(R.id.tv_data);

        addA();
        btn_add_Fragment_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addB();
            }
        });
    }

    private void addB() {
        BFragment = new BFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (needBackStack) {
            transaction.addToBackStack(NAME_BACK_STACK);
        }
        transaction.add(R.id.fl_shou_fragment_main, BFragment).commit();
    }

    private void addA() {
        AFragment = new AFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (needBackStack) {
            fragmentTransaction.addToBackStack(NAME_BACK_STACK);
        }
        fragmentTransaction.add(R.id.fl_shou_fragment_main, AFragment, "a");

        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, TAG + "-onStart: " + " Activity前台可见");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, TAG + "-onResume: " + " Activity获取焦点");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, TAG + "-onPause: " + " Activity失去焦点");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, TAG + "-onRestart: " + " Activity准被进入前台");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, TAG + "-onStop: " + " Activity后台可见");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, TAG + "-onDestroy: activity 销毁");
    }

    @Override
    public void click(String text) {
        tv_data.setText(text);
    }
}