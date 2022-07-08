package com.gsy.fragment.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author gsuiy
 * @create 2022-07-08 12:27
 */
public class BaseFragment extends Fragment {
    private static final String name = "BaseFragment :";
    private Activity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", name+"--onCreate: 创建fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TAG", name+"--onCreateView: 返回需要显示的视图");
        //返回fragment的布局文件给Activity
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", name+"--onActivityCreated: 当所在的Activity启动完成");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TAG", name+"--onStart: fragment前台可见");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TAG", name+"--onResume: fragment得到焦点");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TAG", name+"--onPause: fragment失去焦点");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TAG", name+"--onStop: fragment后台可见");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("TAG", name+"--onDestroyView: 销毁fragment的视图");
    }

    @Override
    public void onDestroy() {//销毁Fragment
        super.onDestroy();
        //取消异步任务
        Log.i("TAG", name+"--onDestroy: 销毁fragment");
    }


    @Override
    public void onAttach(@NonNull Context context) {//此方法只调用一次
        super.onAttach(context);
        Log.i("TAG", name+"--onAttach: 与Activity绑定");
        mActivity= (Activity) context;
        //可以将Activity与Fragment绑定，也可以getActivity得到绑定的Activity
    }

    @Override
    public void onDetach() {//此方法只调用一次，与Activity解除关联
        super.onDetach();
        Log.i("TAG", name+"--onDetach: 与Activity解绑");
    }
}
