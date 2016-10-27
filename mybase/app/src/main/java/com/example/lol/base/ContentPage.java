package com.example.lol.base;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.lol.R;
import com.example.lol.utils.CommonUtil;

/**
 * Created by Administrator on 2016/3/14 0014.
 */
public abstract class ContentPage extends FrameLayout {
    //alt+shift+s->c

    public ContentPage(Context context) {
        super(context);
        initContentPage();
    }

    public ContentPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContentPage();
    }

    public ContentPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initContentPage();
    }

    //定义3种加载状态常量
    public enum PageState{
        STATE_LOADING, //加载中的状态
        STATE_ERROR,  //加载失败的状态
        STATE_SUCCESS //加载成功的状态
    }


    /**更改状态值,用于测试,默认是加载状态*/
    private PageState mState = PageState.STATE_LOADING;//当前界面的状态，默认是加载中
    private View loadingView;//加载中的view
    private View errorView;//加载失败的view
    private View successView;//加载成功的view

    /**
     * 初始化ContentPage
     */
    private void initContentPage(){
        //天然地添加3种状态对应的View对象
        //1.添加loadingView
        if(loadingView==null){
            loadingView = View.inflate(getContext(),R.layout.page_loading,null);
        }
        addView(loadingView);
        //2.添加errorView
        if(errorView==null){
            errorView = View.inflate(getContext(),R.layout.page_error,null);
            Button btn_reload = (Button) errorView.findViewById(R.id.btn_reload);
            btn_reload.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //1.先显示加载进度条
                    mState = PageState.STATE_LOADING;
                    showPage();
                    //2.重新加载数据，然后刷新界面
                    loadDataAndRefreshPage();
                }
            });
        }
        addView(errorView);
        //3.添加successView
        if(successView==null){
            successView = createSuccessView();
        }
        if(successView!=null){
            addView(successView);
        }else {
            //抛出高大上的异常
            throw new IllegalArgumentException("The method createSuccessView() can not return null!");
        }

        //4.一开始显示loadingVIew
        showPage();

        //5.同时去加载数据，然后刷新界面
        loadDataAndRefreshPage();
    }
    /**
     * 根据不同的state显示对应的view对象
     */
    private void showPage(){
        //1.先隐藏所有的View
        loadingView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.INVISIBLE);
        successView.setVisibility(View.INVISIBLE);
        switch (mState) {
            case STATE_LOADING://加载中的状态
                loadingView.setVisibility(View.VISIBLE);
                break;
            case STATE_ERROR://加载失败的状态
                errorView.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS:
                successView.setVisibility(View.VISIBLE);
                break;
        }
    }
    /**
     * 加载数据，然后去刷新界面
     */
    public void loadDataAndRefreshPage(){
        new Thread(){
            public void run() {
                //模拟请求服务器的延时操作
                SystemClock.sleep(1500);

                //1.获取返回的数据
                Object data = loadData();
                //2.判断数据是否为空， 并且将新的状态赋值给mState
                mState = checkData(data);
                //3.根据最新的state刷新界面
                CommonUtil.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        showPage();
                    }
                });
            };
        }.start();
    }

    /**
     * 判断数据对应的状态
     * @param data
     * @return
     */
    private PageState checkData(Object data){
        return data==null?PageState.STATE_ERROR:PageState.STATE_SUCCESS;
    }

    /**
     * 由于每个界面的成功View不一样，所以只能抽象，然后由每个界面自己去实现
     * @return
     */
    public abstract View createSuccessView();

    /**
     * 由于每个界面的数据都不一样，而我们只需要判断返回的数据是否为空，具体加载数据的
     * 逻辑由每个界面自己去实现
     * @return
     */
    public abstract Object loadData();
}

