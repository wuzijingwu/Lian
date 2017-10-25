package com.example.john.viewpager.Fragment;

import android.support.annotation.InterpolatorRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by John on 2016/1/19.
 */
public class Adapter extends FragmentStatePagerAdapter {


    private ArrayList<String> list ;

    public Adapter(FragmentManager fm , ArrayList<String> list ) {
        super(fm);
        this.list = list;

    }

    @Override
    public Fragment getItem(int position) {

          int location = (position+100) % (list.size());
        return  ViewPagerDaohang.newInstance(list.get(location));
    }

    @Override
    public int getCount() {

        int len = 0;
        if(list != null){
            len = list.size()+Integer.MAX_VALUE/2;
        }
        return len;
    }

/*    @Override
    public CharSequence getPageTitle(int position) {
        int location = position % list.size();
        return list.get(location);
    }*/
}
