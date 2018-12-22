package com.example.charvee.doctorapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by Charvee on 7/3/2018.
 */
public class PagerAdapterSep extends FragmentPagerAdapter {
    private String[] tabTitles = new String[]{"Login", "SignUp", "Tab3"};
    int mnoTabs;
    public PagerAdapterSep(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mnoTabs= NumberOfTabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Login login=new Login();
                return login;
            case 1:
                SignUp signup=new SignUp();
                return signup;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mnoTabs;
    }
}
