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

public class AFragment extends BaseFragment {
    private View root;
    private Button btn_add_B_Fragment_F, btn_upData;
    private TextView tv_title_A_Fragment_F;

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
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
        super.onCreateView(inflater, container, savedInstanceState);
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
                addB();
            }
        });
    }



    private void addB() {
        BFragment fragmentB = new BFragment();

        getChildFragmentManager();
        getParentFragmentManager();
        Fragment a = getFragmentManager().findFragmentByTag("a"); // addList ->map
        getFragmentManager().getFragments(); // addList
        if (a != null) {
            getTransaction()
                    .remove(a)
                    .add(R.id.fl_shou_fragment_main, fragmentB)
                    .commit();
        } else {
            getTransaction().add(R.id.fl_shou_fragment_main, fragmentB).commit();
        }
    }
}