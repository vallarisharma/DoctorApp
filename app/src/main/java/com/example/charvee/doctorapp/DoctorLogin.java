package com.example.charvee.doctorapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;


public class DoctorLogin extends AppCompatActivity implements Login.OnFragmentInteractionListener,SignUp.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TabLayout tablayout=(TabLayout)findViewById(R.id.tabLayout1);


        tablayout.addTab(tablayout.newTab().setText("Login"));
        tablayout.addTab(tablayout.newTab().setText("Signup"));

        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.Pager);
        final PagerAdapterSep pagerAdapter=new PagerAdapterSep(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));



        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
