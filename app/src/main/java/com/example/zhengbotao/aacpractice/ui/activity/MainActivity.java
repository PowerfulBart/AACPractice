package com.example.zhengbotao.aacpractice.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhengbotao.aacpractice.R;
import com.example.zhengbotao.aacpractice.ui.fragment.GirlFragment;
import com.example.zhengbotao.aacpractice.ui.fragment.ZhihuFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mainToolbar;
    private ViewPager viewPager;
    private GirlFragment girlFragment;
    private ZhihuFragment zhihuFragment;
    private BottomNavigationBar bottomNavigationBar;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }



    private void initView() {

        mainToolbar = findViewById(R.id.main_toolbar);

        viewPager = findViewById(R.id.main_viewpager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new GirlFragment());
        fragmentList.add(new ZhihuFragment());

        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));

        bottomNavigationBar = findViewById(R.id.main_bottom_navigation_bar);

        initToolbar();
        initBNB();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initToolbar() {

        mainToolbar.inflateMenu(R.menu.toolbar_menu);
        mainToolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.menu_about){
                    startActivity(new Intent(getApplicationContext(),AboutActivity.class));
                }
                return true;
            }
        });
    }

    private void initBNB() {

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite, "Girl"))
                .addItem(new BottomNavigationItem(R.drawable.ic_grade, "Zhihu"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private class MainFragmentPagerAdapter extends FragmentPagerAdapter{


        public MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        /**
         *
         * 返回指定　position的Fragment
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        /**
         * getCount():获得viewpager中有多少个view
         * @return
         */
        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}
