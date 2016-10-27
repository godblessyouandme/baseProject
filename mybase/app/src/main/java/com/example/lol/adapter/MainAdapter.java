package com.example.lol.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.lol.R;
import com.example.lol.fra.home_fra.FragmentFactory;
import com.example.lol.utils.CommonUtil;

/**
 * Created by Administrator on 2016/3/14.
 */
public class MainAdapter extends FragmentPagerAdapter {


    private String[] tabs;

    public MainAdapter(FragmentManager fm) {
        super(fm);
        tabs= CommonUtil.getStringArray(R.array.tab_names);
    }




    /**根据对应的位置返回不同的fragment对象*/
    @Override
    public Fragment getItem(int position) {

        return FragmentFactory.creat(position);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }



    /**必须重写否则报null*/
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);

        return tabs[position];
    }
}
