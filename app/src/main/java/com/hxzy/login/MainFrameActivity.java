package com.hxzy.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import fragment.DiscoveryFragment;
import fragment.MeFragment;
import fragment.MessageFragment;
import fragment.WonderFragment;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MainFrameActivity extends FragmentActivity{
    private RadioGroup navMenu;
    private ImageView ball;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);
        findView();
        initView();
    }
    private void showFragment(Fragment fragment){
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.fragment_container,fragment);
        fragmentManager.commit();
    }
    private void findView(){
        navMenu = (RadioGroup) findViewById(R.id.nav_menu);
        ball = (ImageView) findViewById(R.id.nav_ball);
    }
    private void initView(){
        navMenu.setOnCheckedChangeListener(checkedChangeListener);
        ball.setOnClickListener(onClickListener);
        showFragment(new WonderFragment());
    }

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.item_wonder:
                    showFragment(new WonderFragment());
                    break;
                case R.id.item_discovery:
                    showFragment(new DiscoveryFragment());
                    break;
                case R.id.item_message:
                    showFragment(new MessageFragment());
                    break;
                case R.id.item_me:
                    showFragment(new MeFragment());
                    break;
            }
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainFrameActivity.this,"点了个球", Toast.LENGTH_SHORT).show();
        }
    };

}
