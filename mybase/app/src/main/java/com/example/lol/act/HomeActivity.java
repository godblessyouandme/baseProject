package com.example.lol.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.lol.R;
import com.example.lol.fra.AboutusFragment;
import com.example.lol.fra.ExitFragment;
import com.example.lol.fra.FeedbackFragment;
import com.example.lol.fra.FindlolFragment;
import com.example.lol.fra.HomeFragment;
import com.example.lol.fra.MyInfoFragment;
import com.example.lol.fra.SetingFragment;
import com.example.lol.fra.UpdateFragment;
import com.example.lol.view.CircleImageView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private final String HOME_TAG = "home_tag";
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setActionBaral();
        //inithomepager
        initHomePage();

    }

    private void initHomePage() {
        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fr_commont, new HomeFragment(), HOME_TAG);
        transaction.commit();

    }


    private void setActionBaral() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //头像登录监听
        CircleImageView view = (CircleImageView) findViewById(R.id.iv_potologin);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });

        //fragment碎片管理化
        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();

        int id = item.getItemId();

        if (id==R.id.nav_home){

           // tv_navInfo.setText("首页");
            transaction.replace(R.id.fr_commont, new HomeFragment(), HOME_TAG);

        }else if(id==R.id.nav_setting){
           // tv_navInfo.setText("设置");
            transaction.replace(R.id.fr_commont, new SetingFragment(), HOME_TAG);

        }else if (id==R.id.nav_myinfo){
           // tv_navInfo.setText("个人中心");
            transaction.replace(R.id.fr_commont, new MyInfoFragment(), HOME_TAG);

        }else if (id==R.id.nav_findlol){
            //tv_navInfo.setText("寻找撸友");
            transaction.replace(R.id.fr_commont, new FindlolFragment(), HOME_TAG);

        }else if (id==R.id.nav_feedback){
            //tv_navInfo.setText("我要反馈");
            transaction.replace(R.id.fr_commont, new FeedbackFragment(), HOME_TAG);

        }else if (id==R.id.nav_updata){
           // tv_navInfo.setText("检查更新");
            transaction.replace(R.id.fr_commont, new UpdateFragment(), HOME_TAG);

        }else if (id==R.id.nav_aboutus){
            //tv_navInfo.setText("关于我们");
            transaction.replace(R.id.fr_commont, new AboutusFragment(), HOME_TAG);

        }else if (id==R.id.nav_exitlol){
           // tv_navInfo.setText("退出登录");
            transaction.replace(R.id.fr_commont, new ExitFragment(), HOME_TAG);

        }


        // 提交事务
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
