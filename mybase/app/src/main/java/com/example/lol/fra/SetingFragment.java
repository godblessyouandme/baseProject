package com.example.lol.fra;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lol.base.BaseFragment;
import com.example.lol.base.ContentPage;

/**
 * Created by Administrator on 2016/3/13 0013.
 */
public class SetingFragment extends BaseFragment {

    @Override
    protected Object initData() {
        return null;
    }

    @Override
    protected View initView() {

        TextView view = new TextView(mContext);

        view.setText("我是设置");
        return view;
    }
}
