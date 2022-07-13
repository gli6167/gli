package com.gsy.animation.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.gsy.animation.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alpha,btn_2;
    private ImageView iv_xuanzhuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setClickListener();
    }

    private void setClickListener() {
        btn_alpha.setOnClickListener(this);
        btn_2.setOnClickListener(this);
    }

    private void findView() {
        btn_alpha = findViewById(R.id.btn_alpha);
        iv_xuanzhuan = findViewById(R.id.iv_xuanzhuan);
        btn_2=findViewById(R.id.btn_2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                //创建透明动画
                AlphaAnimation alphaanimation1 = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.aa);

                AlphaAnimation alphaanimation2 = new AlphaAnimation(0f, 1f);
                alphaanimation2.setDuration(5000);


                //创造旋转动画
                RotateAnimation rotateAnimation1 = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.xuanzhuan);

                RotateAnimation rotateAnimation2 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation2.setDuration(5000);
                rotateAnimation2.setFillAfter(true);


                //创造缩放动画
                ScaleAnimation scaleAnimation1 = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.suofang);

                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 0.5f, 2.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation2.setDuration(5000);
                scaleAnimation2.setFillAfter(true);


                //创造平移动画
                TranslateAnimation translateAnimation1 = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.pingyi);

                TranslateAnimation translateAnimation2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
                translateAnimation2.setDuration(5000);
                translateAnimation2.setFillAfter(true);


                //组合动画
                AnimationSet animationSet1 = new AnimationSet(false);
                animationSet1.addAnimation(alphaanimation1);
                animationSet1.addAnimation(rotateAnimation1);
                animationSet1.addAnimation(scaleAnimation1);
                animationSet1.addAnimation(translateAnimation1);

                AnimationSet animationSet2 = new AnimationSet(false);
                animationSet2.addAnimation(alphaanimation2);
                animationSet2.addAnimation(rotateAnimation2);
                animationSet2.addAnimation(scaleAnimation2);
                animationSet2.addAnimation(translateAnimation2);


                iv_xuanzhuan.startAnimation(animationSet1);
                break;
            case R.id.btn_2:
                //透明
                ObjectAnimator alpha = ObjectAnimator.ofFloat(iv_xuanzhuan,View.ALPHA,0f,1f);
                alpha.setDuration(4000);
                alpha.setInterpolator(new LinearInterpolator());
//                alpha.start();

                //缩放
                //得到缩放中心点
                iv_xuanzhuan.setPivotX(iv_xuanzhuan.getWidth()/2);
                iv_xuanzhuan.setPivotY(iv_xuanzhuan.getHeight()/2);

                //创建缩放属性动画
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv_xuanzhuan,View.SCALE_X,1,0.5f);
                scaleX.setDuration(4000);
                scaleX.setStartDelay(2000);


                ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv_xuanzhuan,View.SCALE_Y,1,0.5f);
                scaleY.setDuration(4000);
                scaleY.setStartDelay(2000);


                AnimatorSet animatorSetScale = new AnimatorSet();
                animatorSetScale.playTogether(scaleX,scaleY);
                animatorSetScale.start();

                break;
        }
    }
}