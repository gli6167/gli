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
import androidx.fragment.app.FragmentTransaction;

import com.gsy.fragment.activity.MainActivity;

/**
 * @author gsuiy
 * @create 2022-07-08 12:27
 */
public class BaseFragment extends Fragment {
    String TAG = "MainActivity";
    private String TAG_FRAGMENT = getClass().getSimpleName() + "-";
    private Activity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, TAG_FRAGMENT + "onAttach: ");
        mActivity = (Activity) context;
        //可以将Activity与Fragment绑定，也可以getActivity得到绑定的Activity
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, TAG_FRAGMENT + "onCreate: ");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, TAG_FRAGMENT + "onStart: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(TAG, TAG_FRAGMENT + "onHiddenChanged: ");
    }

    // 返回fragment的布局文件给Activity
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, TAG_FRAGMENT + "onCreateView: ");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, TAG_FRAGMENT + "onActivityCreated: ");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, TAG_FRAGMENT + "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, TAG_FRAGMENT + "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, TAG_FRAGMENT + "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, TAG_FRAGMENT + "onDestroyView: ");
    }

    @Override
    public void onDestroy() {//销毁Fragment
        super.onDestroy();
        Log.i(TAG, TAG_FRAGMENT + "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, TAG_FRAGMENT + "onDetach: ");
    }

    public FragmentTransaction getTransaction() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (MainActivity.needBackStack) {
            transaction.addToBackStack(MainActivity.NAME_BACK_STACK);
        }
        return transaction;
    }
}
