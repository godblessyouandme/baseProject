package com.example.lol.utils;

import android.widget.Toast;

import com.example.lol.application.App;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ToastUtil {
    private static Toast toast;//单例的吐司
    public static void showToast(String text){
        if(toast==null){
            toast = Toast.makeText(App.getContext(), text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);//将文本设置给吐司
        toast.show();
    }
}
