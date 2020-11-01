package com.example.zodiac.controller.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleTabList = new ArrayList<>();

    public ViewpagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Fragment sẽ hiện ra
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    // Số Fragment hiển thị trên ViewPager
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    // Tiêu đề của Tab
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleTabList.get(position);
    }

    public void addFragment(Fragment fragment, String titleTab){
        fragmentList.add(fragment);
        titleTabList.add(titleTab);
    }
}
