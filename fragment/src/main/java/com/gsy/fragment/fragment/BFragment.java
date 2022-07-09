package com.gsy.fragment.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.gsy.fragment.R;

import java.util.List;

public class BFragment extends BaseFragment {
    private View root;
    private Button btn_add_A_Fragment_F;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_second, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_add_A_Fragment_F = (Button) view.findViewById(R.id.btn_add_A_Fragment_F);
        btn_add_A_Fragment_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addA();
            }
        });

    }

    private void addA() {
        // 如果处理后退栈，需要这个方法
        Fragment a = getFragmentManager().findFragmentByTag("a");

        // 如果处理正常fragment跳转
        List<Fragment> fragments = getFragmentManager().getFragments();
        if (a != null) {
            Log.i(TAG, "addA: AFragment存在");
            getTransaction()
                    .hide(BFragment.this)
                    .show(a)
                    .commit();
        } else {
//            AFragment fragmentA = new AFragment();
//           getTransaction().add(R.id.fl_shou_fragment_main, fragmentA).commit();
        }
    }
}