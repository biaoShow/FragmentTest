package com.example.biao.fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MesParticularsActivity extends AppCompatActivity {

    private RightFragment rightFragment;
    private ViewPager viewPager;
    private FragmentAdapter adapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();


    public static void actionStart(Context context, String titel, String content){
        Intent intent = new Intent(context,MesParticularsActivity.class);
        intent.putExtra("titel",titel);
        intent.putExtra("content",content);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);
        viewPager = findViewById(R.id.viewPager);

        rightFragment = new RightFragment();

        Intent intent = getIntent();
        String titel = intent.getStringExtra("titel");
        String content = intent.getStringExtra("content");
        Bundle bundle = new Bundle();
        bundle.putString("titel",titel);
        bundle.putString("content",content);
        rightFragment.setArguments(bundle);

        adapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }

}
