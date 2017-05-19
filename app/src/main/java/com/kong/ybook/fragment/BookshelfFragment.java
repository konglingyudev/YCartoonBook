package com.kong.ybook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kong.ybook.R;

import org.xutils.x;

/**
 * Created by konglingyu on 2017/2/10.
 */

public class BookshelfFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shelf,null);
        x.view().inject(this, view);
        return view;
    }
}
