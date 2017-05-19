package com.kong.ybook.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kong.ybook.R;
import com.kong.ybook.adapter.ViewPagerAdapter;
import com.kong.ybook.fragment.SearchFragment;
import com.kong.ybook.fragment.BookshelfFragment;
import com.kong.ybook.fragment.BookstoreFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.drawer_layout)
    private DrawerLayout mDrawerLayout;

    @ViewInject(R.id.viewPager)
    private ViewPager mViewPager;
    @ViewInject(R.id.nav)
    private RadioGroup mRadioGroup;
    @ViewInject(R.id.radioBookshelf)
    private RadioButton tabBookshelf;
    @ViewInject(R.id.radioBookstore)
    private RadioButton tabBookstore;
    @ViewInject(R.id.radioSearch)
    private RadioButton tabSearch;

    private ArrayList<Fragment> fragments;
    private ViewPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);
        setSlideMenu();
        //设置Adapter
        setAdapter();
        //设置Listener
        setListener();

    }

    private void setListener() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.i("listener","radioGroup, int i="+i);
                switch (i){
                    case R.id.radioBookstore:
                        tabBookstore.setTextColor(Color.rgb(255,153,51));
                        tabBookshelf.setTextColor(Color.rgb(146,146,146));
                        tabSearch.setTextColor(Color.rgb(146,146,146));
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.radioBookshelf:
                        tabBookshelf.setTextColor(Color.rgb(255,153,51));
                        tabBookstore.setTextColor(Color.rgb(146,146,146));
                        tabSearch.setTextColor(Color.rgb(146,146,146));
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.radioSearch:
                        tabSearch.setTextColor(Color.rgb(255,153,51));
                        tabBookstore.setTextColor(Color.rgb(146,146,146));
                        tabBookshelf.setTextColor(Color.rgb(146,146,146));
                        mViewPager.setCurrentItem(2);
                        break;

                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                if(v!=0){ //当前是第3页
                    //设置第三个fragment header的透明度
                    SearchFragment fragment = (SearchFragment) fragments.get(2);
                    //fragment.slide(v);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("listener","ViewPager, int position="+position);
                switch (position){
                    case 0:
                        tabBookstore.setChecked(true);
                        break;
                    case 1:
                        tabBookshelf.setChecked(true);
                        break;
                    case 2:
                        tabSearch.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    private void setAdapter() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new BookstoreFragment());
        fragments.add(new BookshelfFragment());
        fragments.add(new SearchFragment());
        //构建Adapter
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }

    private void setSlideMenu() {
        //通过findViewById()获取Toolbar实例,调用setSupportActionBar()方法传入实例
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.btn_menu);
        }

        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    //加载了toolbar.xml这个菜单文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    //处理各个按钮的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
