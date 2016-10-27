package com.example.lol.fra.home_fra;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lol.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Fra_infomation extends BaseFragment {


    @Override
    protected Object initData() {
        return null;
    }

    @Override
    protected View initView() {

        TextView view = new TextView(mContext);

        view.setText("我是资讯");
        return view;
    }
}
