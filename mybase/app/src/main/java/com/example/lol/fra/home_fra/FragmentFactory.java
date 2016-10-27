package com.example.lol.fra.home_fra;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/3/14.
 */
public class FragmentFactory {

    //根据不同postion 生产不同的fra
    public static Fragment creat(int postion) {

        Fragment fragment = null;

        switch (postion) {

            case 0:
                fragment = new Fra_home();
                break;
            case 1:
                fragment = new Fra_infomation();
                break;
            case 2:
                fragment = new Fra_video();
                break;
            case 3:
                fragment = new Fra_hero();
                break;
            case 4:
                fragment = new Fra_special();
                break;
            case 5:
                fragment = new Fra_recommend();
                break;
            case 6:
                fragment = new Fra_games();
                break;


        }


        return fragment;
    }
}
