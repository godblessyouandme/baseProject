package com.example.lol.adapter;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lol.R;
import com.example.lol.application.App;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/14.
 */
public class HomePagerAdapter extends BasePagerAdapter<Integer> {


    public HomePagerAdapter(ArrayList <Integer>list) {
        super(list);


    }


   //只需要添加布局
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(App.getContext());

        imageView.setBackgroundResource(list.get(position));


        //注意不要忘记添加进来
        container.addView(imageView);
        return imageView;
    }
}
