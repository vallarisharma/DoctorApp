package com.example.charvee.doctorapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Charvee on 6/26/2018.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitles = new String[]{"History", "Prescription", "Tab3"};

    int mNoOfTabs;
    public PagerAdapter(FragmentManager fm,int NoOfTabs)
    {
        super(fm);
        this.mNoOfTabs=NoOfTabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
    @Override
    public Fragment getItem(int position) {
        Log.e("my post", "" + position);

        switch(position){

            case 0:
                History tab1=new History();
                return tab1;
            case 1:
                Prescriptions tab2=new Prescriptions();
                return tab2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
