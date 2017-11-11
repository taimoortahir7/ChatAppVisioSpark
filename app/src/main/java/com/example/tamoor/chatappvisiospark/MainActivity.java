package com.example.tamoor.chatappvisiospark;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    Context context;
    boolean doubleBackToExitPressedOnce = false;
    int[] imgs = {R.drawable.chat,R.drawable.chat_profile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        setupToolbar();
        initViews();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
//        setupListeners();
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            moveTaskToBack(true);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ChatSpark");
    }

    private void initViews(){
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),"");
        adapter.addFrag(new FragmentChatProfile(), "ONE");
        adapter.addFrag(new FragmentChatView(), "TWO");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(1).setIcon(imgs[0]);
        tabLayout.getTabAt(0).setIcon(imgs[1]);
    }
}
