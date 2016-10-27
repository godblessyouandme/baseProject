package com.example.lol.fra.home_fra;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lol.R;
import com.example.lol.adapter.HomePagerAdapter;
import com.example.lol.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Fra_home extends BaseFragment {


    @Override
    protected Object initData() {
        return "请求网络在此处填写";
    }

    @Override
    protected View initView() {
        View homeview = View.inflate(mContext,R.layout.fra_home_home, null);
        LinearLayout home_header = (LinearLayout) View.inflate(mContext, R.layout.home_header, null);

        ViewPager homeViewPager= (ViewPager) home_header.findViewById(R.id.homeviewpager);
        ListView lv_home = (ListView) homeview.findViewById(R.id.lv_home);

        //准备数据

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.lol);
        list.add(R.drawable.background);
        list.add(R.drawable.teemo);
        list.add(R.drawable.ic_about);

        //适配数据
        homeViewPager.setAdapter(new HomePagerAdapter(list));

        lv_home.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(mContext);
                textView.setText("哈哈"+i);
                return textView;
            }
        });


        lv_home.addHeaderView(home_header);

        return homeview;
    }
}
