package com.example.lol.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lol.utils.CommonUtil;

/**
 * Created by Administrator on 2016/3/13 0013.
 */
public abstract class BaseFragment extends Fragment {


    protected Activity mContext;
    protected ContentPage contentPage;//注意：不能是private

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        if(contentPage==null){
            contentPage = new ContentPage(getActivity()) {
                @Override
                public Object loadData() {
                    //方法自己调自己：StackOverflow
//				return BaseFragment.this.loadData();
                    return initData();
                }
                @Override
                public View createSuccessView() {
                    return initView();
                }
            };
        }else {
            //contentPage有爹了：NoSaveStateFrameLayout。需要先从爹中移除
//			LogUtil.e(this, "使用已经创建过的contentPage: 它的爹： "+contentPage.getParent().getClass().getSimpleName());
            //如果使用studio开发，会自动关联最新的v4和v7包，而v4中的FragmentManager最新的代码没有加NoSaveStateFrameLayout
            //所以这个时候，下面的移除操作已经不需要了
            CommonUtil.removeSelfFromParent(contentPage);
        }
        return contentPage;
        //return initView(inflater);
    }



    /**
     * 子类选择实现
     */
    protected abstract Object initData();

    /**
     * 子类实现
     *
     * @return
     */
    protected abstract View initView();


}
