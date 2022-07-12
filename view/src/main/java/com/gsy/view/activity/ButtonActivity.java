package com.gsy.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.gsy.view.R;

public class ButtonActivity extends AppCompatActivity {
    private Button btn_text_button,
            btn_shou_dialog,
            btn_text_image;
    private ImageButton btn_image_button;
    private SeekBar sb_1;
    private ProgressBar pb_1, pb_2;
    private AlertDialog.Builder dialog;
    private View view;


    private PopupMenu popupMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(ButtonActivity.this,"点击了添加菜单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.resume_item:
                Toast.makeText(ButtonActivity.this,"点击了移除菜单",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        findView();
        setChickListener();
    }


    private void shouPopupMenu(View v){
        popupMenu = new PopupMenu(this,v);
        popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(ButtonActivity.this);
                Intent intent =new Intent(ButtonActivity.this,MainActivity.class);
                switch (item.getItemId()){
                    case R.id.add_item:
                        dialog.setTitle("对话框一")
                                .setMessage("通过点击添加菜单添加一个界面并跳转")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                      startActivity(intent);

                                    }
                                })
                                .setNegativeButton("取消",null)
                        .show();
                        break;
                    case R.id.resume_item:
                        dialog.setTitle("对话框二")
                                .setMessage("通过点击移除菜单移除添加的界面")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .setNegativeButton("取消",null)
                                .show();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private void setChickListener() {
        btn_text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            shouPopupMenu(v);
            }
        });

        sb_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //得到sb_1的进度
                int progresss = sb_1.getProgress();
                //设置pb_2的进度为sb_1的进度
                pb_2.setProgress(progresss);
                //判断是否达到最大值
                if (progresss == sb_1.getMax()) {
                    pb_2.setVisibility(View.GONE);//设置pb隐藏
                } else {
                    pb_2.setVisibility(View.VISIBLE);//设置pb显示
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_shou_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog2().show();
            }
        });
    }

    public AlertDialog.Builder shouDialog() {
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("第一个对话框的标题")
                .setMessage("第一个对话框的内容")
                .setPositiveButton("肯定回答", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ButtonActivity.this, "跳转页面", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("否定回答", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ButtonActivity.this, "取消页面", Toast.LENGTH_SHORT).show();

                    }
                })
                .show();
        return dialog;
    }

    public AlertDialog.Builder createDialog2() {
        dialog = new AlertDialog.Builder(ButtonActivity.this);
        view = View.inflate(ButtonActivity.this, R.layout.dialog, null);
        Button btn_confirm = (Button) view.findViewById(R.id.btn_confirm);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
            }
        });

        dialog
                .setView(view)
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ButtonActivity.this, MainActivity.class));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
        ;
        return dialog;
    }

    private void findView() {
        btn_text_button = (Button) findViewById(R.id.btn_text_button);
        btn_image_button = (ImageButton) findViewById(R.id.btn_image_button);
        btn_text_image = (Button) findViewById(R.id.btn_text_image);
        sb_1 = (SeekBar) findViewById(R.id.sb_1);
        pb_2 = (ProgressBar) findViewById(R.id.pb_2);
        pb_1 = (ProgressBar) findViewById(R.id.pb_1);
        btn_shou_dialog = (Button) findViewById(R.id.btn_shou_dialog);
    }
}