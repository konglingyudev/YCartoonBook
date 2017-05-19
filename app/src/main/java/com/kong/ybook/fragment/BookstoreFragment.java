package com.kong.ybook.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kong.ybook.R;
import com.kong.ybook.fragment.StoreFragment.StoreDanmeiFragment;
import com.kong.ybook.fragment.StoreFragment.StoreQingnianFragment;
import com.kong.ybook.fragment.StoreFragment.StoreShaonianFragment;
import com.kong.ybook.fragment.StoreFragment.StoreShaonvFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by konglingyu on 2017/2/10.
 */

public class BookstoreFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    @ViewInject(R.id.fenlei_gr)
    private RadioGroup rg_fenlei;
    @ViewInject(R.id.rbtn_shaonian)
    private RadioButton rbtn_shaonian;
    @ViewInject(R.id.rbtn_qingnian)
    private RadioButton rbtn_qingnian;
    @ViewInject(R.id.rbtn_shaonv)
    private RadioButton rbtn_shaonv;
    @ViewInject(R.id.rbtn_danmei)
    private RadioButton rbtn_danmei;
    @ViewInject(R.id.bookstore_viewPager)

    private ViewPager bookstoreViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_store,null);
        x.view().inject(this, view);
        setAdapter();
        setListener();
        return view;
    }

    private void setAdapter() {
        //构建Adapter
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        bookstoreViewPager.setAdapter(pagerAdapter);
    }
    private void setListener() {
        rg_fenlei.setOnCheckedChangeListener(this);
        bookstoreViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case 0:
            case R.id.rbtn_shaonian:
                rbtn_shaonian.setTextColor(Color.rgb(255,255,255));
                rbtn_qingnian.setTextColor(Color.rgb(255,210,160));
                rbtn_shaonv.setTextColor(Color.rgb(255,210,160));
                rbtn_danmei.setTextColor(Color.rgb(255,210,160));
                bookstoreViewPager.setCurrentItem(0);
                break;
            case R.id.rbtn_qingnian:
                rbtn_shaonian.setTextColor(Color.rgb(255,210,160));
                rbtn_qingnian.setTextColor(Color.rgb(255,255,255));
                rbtn_shaonv.setTextColor(Color.rgb(255,210,160));
                rbtn_danmei.setTextColor(Color.rgb(255,210,160));
                bookstoreViewPager.setCurrentItem(1);
                break;
            case R.id.rbtn_shaonv:
                rbtn_shaonian.setTextColor(Color.rgb(255,210,160));
                rbtn_qingnian.setTextColor(Color.rgb(255,210,160));
                rbtn_shaonv.setTextColor(Color.rgb(255,255,255));
                rbtn_danmei.setTextColor(Color.rgb(255,210,160));
                bookstoreViewPager.setCurrentItem(2);
                break;
            case R.id.rbtn_danmei:
                rbtn_shaonian.setTextColor(Color.rgb(255,210,160));
                rbtn_qingnian.setTextColor(Color.rgb(255,210,160));
                rbtn_shaonv.setTextColor(Color.rgb(255,210,160));
                rbtn_danmei.setTextColor(Color.rgb(255,255,255));
                bookstoreViewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                rbtn_shaonian.setChecked(true);
                break;
            case 1:
                rbtn_qingnian.setChecked(true);
                break;
            case 2:
                rbtn_shaonv.setChecked(true);
                break;
            case 3:
                rbtn_danmei.setChecked(true);
                break;

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragments=new ArrayList<Fragment>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new StoreShaonianFragment());
            fragments.add(new StoreQingnianFragment());
            fragments.add(new StoreShaonvFragment());
            fragments.add(new StoreDanmeiFragment());

        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
