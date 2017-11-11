package com.example.tamoor.chatappvisiospark;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private String activityName;

    public MyPagerAdapter(FragmentManager manager, String activityName) {
        super(manager);
        this.activityName = activityName;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(activityName.equalsIgnoreCase("ambassadordetails")){
            return mFragmentTitleList.get(position);
        }
        return null;
    }
}
