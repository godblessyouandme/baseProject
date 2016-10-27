package com.example.lol.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/3/13 0013.
 */
public abstract class Basepage {


    public  View rootView;
    protected  Context mContext;

    public Basepage(Context context) {
        mContext=context;
        rootView = initView();

    }

    //子类实现,返回布局
    protected abstract View initView();

    //更新界面
    public void initData(){};

}
