package com.example.lol.fra;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lol.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/13 0013.
 */
public class AboutusFragment extends BaseFragment {


    @Override
    protected Object initData() {
        return null;
    }

    @Override
    protected View initView() {
        TextView view = new TextView(mContext);

        view.setText("关于我们");
        return view;
    }
}
