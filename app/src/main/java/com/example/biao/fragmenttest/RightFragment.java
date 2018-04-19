package com.example.biao.fragmenttest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RightFragment extends Fragment {

    private TextView tv_right_titel, tv_right_content;
    private List<Mes> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_layout, container, false);

        Bundle bundle = getArguments();
        list = (List<Mes>) bundle.getSerializable("Mes");

        tv_right_titel = view.findViewById(R.id.tv_mestitle);
        tv_right_content = view.findViewById(R.id.tv_right_titel);


        setRightText(0);

        return view;
    }

    public void setRightText(int position) {
        tv_right_titel.setText(list.get(position).getTitle());
        tv_right_content.setText(list.get(position).getContent());
    }
}
