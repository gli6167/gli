package com.gsy.fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gsy.fragment.R;

public class FirstFragment extends BaseFragment {
    private View root;
    private Button btn_add_B_Fragment_F, btn_upData;
    private TextView tv_title_A_Fragment_F;

    public static FirstFragment newInstance(String title) {
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;

    }

    private IOnMessageClick iOnMessageClick;

    public interface IOnMessageClick {
        void click(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iOnMessageClick = (IOnMessageClick) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_first, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_title_A_Fragment_F = (TextView) view.findViewById(R.id.tv_title_A_Fragment_F);
        btn_add_B_Fragment_F = (Button) view.findViewById(R.id.btn_add_B_Fragment_F);
        btn_upData = (Button) view.findViewById(R.id.btn_upData);
        btn_upData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnMessageClick.click("更改数据");
            }
        });
        btn_add_B_Fragment_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragmentB = new SecondFragment();
                Fragment a = getFragmentManager().findFragmentByTag("a");
                if (a != null) {
                    getFragmentManager().beginTransaction()
                            .hide(a)//将Afragment视图隐藏那么回退之后就不会重新绘制视图
                            .addToBackStack(null)
                            .add(R.id.fl_shou_fragment_main, fragmentB)
                            .commit();

                } else {
                    getFragmentManager().beginTransaction().add(R.id.fl_shou_fragment_main, fragmentB).commit();
                }

            }
        });


    }
}