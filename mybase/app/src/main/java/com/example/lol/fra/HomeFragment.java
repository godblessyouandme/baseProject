package com.example.lol.fra;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lol.R;
import com.example.lol.adapter.MainAdapter;
import com.example.lol.base.BaseFragment;
import com.example.lol.lib.PagerSlidingTab;

/**
 * Created by Administrator on 2016/3/13 0013.
 */
public class HomeFragment extends BaseFragment {




    @Override
    protected Object initData() {
        return "哈哈";
    }

    @Override
    protected View initView() {

        LinearLayout fra_home = (LinearLayout) View.inflate(mContext,R.layout.fra_home,null);
        PagerSlidingTab pagerIndcator = (PagerSlidingTab) fra_home.findViewById(R.id.pagerIndcator);
        ViewPager viewpager = (ViewPager) fra_home.findViewById(R.id.viewpager);


        //填充适配viewpager
        viewpager.setAdapter(new MainAdapter(getChildFragmentManager()));

        //绑定indcator
        pagerIndcator.setViewPager(viewpager);

        return fra_home;

    }
}
