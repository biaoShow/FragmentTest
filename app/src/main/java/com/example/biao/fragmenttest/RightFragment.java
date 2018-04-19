package com.example.biao.fragmenttest;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RightFragment extends Fragment {

    private TextView tv_right_titel, tv_right_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_layout, null, false);
        tv_right_titel = view.findViewById(R.id.tv_right_titel);
        tv_right_content =view.findViewById(R.id.tv_right_content);
        Bundle bundle = getArguments();
        tv_right_titel.setText(bundle.getString("titel"));
        tv_right_content.setText(bundle.getString("content"));
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        tv_right_titel = getView().findViewById(R.id.tv_right_titel);
        tv_right_content =getView().findViewById(R.id.tv_right_content);
        Bundle bundle = getArguments();
        tv_right_titel.setText(bundle.getString("titel"));
        tv_right_content.setText(bundle.getString("content"));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
