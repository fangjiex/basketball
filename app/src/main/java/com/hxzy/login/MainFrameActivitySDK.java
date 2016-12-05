package com.hxzy.login;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sam.utils.system.SystemBarTintManager;
import com.sam.widget.nav_bar.NavigationBar;

import fragment.DiscoveryFragment;
import fragment.MeFragment;
import fragment.MessageFragment;
import fragment.PactBallFragment;
import fragment.WonderFragment;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MainFrameActivitySDK extends FragmentActivity {;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.black);//通知栏所需颜色
        }
        setContentView(R.layout.activity_main_frame_sdk);

        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.nav_bar);
        NavigationBar.NavigationItemEntity[] items = new NavigationBar.NavigationItemEntity[]{
                new NavigationBar.NavigationItemEntity(this,R.string.nav_wonder,R.mipmap.nav_icon_wonder_normal,R.mipmap.nav_icon_wonder_checked),
                new NavigationBar.NavigationItemEntity(this,R.string.nav_discovery,R.mipmap.nav_icon_discovery_normal,R.mipmap.nav_icon_discovery_checked),
                new NavigationBar.NavigationItemEntity("",null,null),
                new NavigationBar.NavigationItemEntity(this,R.string.nav_message,R.mipmap.nav_icon_message_normal,R.mipmap.nav_icon_message_checked),
                new NavigationBar.NavigationItemEntity(this,R.string.nav_me,R.mipmap.nav_icon_me_normal,R.mipmap.nav_icon_me_checked),
        };

        final Fragment[] fragments = new Fragment[]{new WonderFragment(),new DiscoveryFragment(),new PactBallFragment(),new MessageFragment(),new MeFragment()};
        NavigationBar.OnNavItemCheckedChangeListener onNavItemCheckedChangeListener = new NavigationBar.OnNavItemCheckedChangeListener() {
            @Override
            public void onCheckedChanged(NavigationBar navigationBar, int i, View view) {
                showFragment(fragments[i]);
            }
        };
        navigationBar.setNavigationItems(items,0,onNavItemCheckedChangeListener);

    }

    private void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);
        fragmentTransaction.commit();
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
