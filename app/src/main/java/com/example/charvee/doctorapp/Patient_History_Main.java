package com.example.charvee.doctorapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class Patient_History_Main extends AppCompatActivity implements History.OnFragmentInteractionListener,Prescriptions.OnFragmentInteractionListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__history__main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        tabLayout.bringToFront();
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.addTab(tabLayout.newTab().setText("Prescriptions"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        final PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setupWithViewPager(viewPager);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            int i=bundle.getInt("tabNo");

            /*Bundle bundle1 = new Bundle();
            bundle1.putInt("visitNo", 1);
            Fragment frag=new Prescriptions();
            frag.setArguments(bundle1);*/
            viewPager.setCurrentItem(i);

        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               Log.e("My projection",""+tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                Log.e("My projection 222",""+tab.getPosition());

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
