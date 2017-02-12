package com.bwie.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] title={"推荐","热点","阳光","体育","北京","社会","娱乐","财经"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_title);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        initData();
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), this, title);
        adapter.setList(list);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            TitleFragment titleFragment = new TitleFragment();
            list.add(titleFragment);
        }
    }
}
