package com.example.biao.fragmenttest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Mes> list = new ArrayList<>();
    private LeftFragment leftFragment;
    private RightFragment rightFragment;
    private FragmentAdapter fragmentAdapter;
    private  ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager myviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMes();
        myviewpager = findViewById(R.id.myviewpager);
        leftFragment = new LeftFragment();
        rightFragment = new RightFragment();
        Bundle bundle = new Bundle();
        Bundle bundle1 = new Bundle();
        bundle.putSerializable("Mes", (Serializable) list);
        bundle1.putSerializable("Mes", (Serializable) list);
        leftFragment.setArguments(bundle);
        rightFragment.setArguments(bundle1);

        fragments.add(leftFragment);
        fragments.add(rightFragment);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        myviewpager.setAdapter(fragmentAdapter);
    }

//    @Override
//    public void onClick(View v) {
//        if (findViewById(R.id.right_layout) != null) {
//
//            AnotheRightFragment fragment = new AnotheRightFragment();
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.right_layout, fragment);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        }else{
//            Toast.makeText(this,"错误。。。",Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
//
    private void initMes(){
        Mes mes1 = new Mes("FirstMessage","This is FirstMessage!");
        Mes mes2 = new Mes("SecondMessage","This is SecondMessage!");
        list.add(mes1);
        list.add(mes2);
    }

}

