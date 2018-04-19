package com.example.biao.fragmenttest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


public class LeftFragment extends Fragment {

    private List<Mes> list;
    private RecyclerviewAdapter adapter;
    private RecyclerView left_recyclerview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_layout, container, false);

        Bundle bundle = getArguments();
        list = (List<Mes>) bundle.getSerializable("Mes");

        adapter = new RecyclerviewAdapter(getActivity(), list);
        left_recyclerview = view.findViewById(R.id.left_recyclerview);
        left_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        left_recyclerview.setAdapter(adapter);

        adapter.setOnClickItemListener(new OnClickItemListener() {
            @Override
            public void onClickItem(int position) {
                Toast.makeText(getActivity(), "你点击了" + position, Toast.LENGTH_SHORT).show();
                if (getActivity().findViewById(R.id.right_layout) != null) {

                } else {
                    MesParticularsActivity.actionStart(getActivity(), list.get(position).getTitle(),
                            list.get(position).getContent());
                }
            }
        });


        return view;
    }

}
