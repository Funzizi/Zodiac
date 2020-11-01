package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.zodiac.R;
import com.example.zodiac.controller.fragment.MoreFragment;
import com.example.zodiac.controller.fragment.ZodiacFragment;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {
    private ViewPager viewPager;

    ViewpagerAdapter viewpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mapping();
        viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewpagerAdapter.addFragment(new ZodiacFragment(), "12 Cung \nHoàng Đạo");
        viewpagerAdapter.addFragment(new MoreFragment(), "Mở Rộng");
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.setAdapter(viewpagerAdapter);
        // Chuyển sang Tablayout
        ((TabLayout) findViewById(R.id.tabLayout)).setupWithViewPager(viewPager);
    }

    private void mapping() {
        viewPager = findViewById(R.id.viewPager);
    }
}