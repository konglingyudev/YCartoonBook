package com.kong.ybook.fragment.StoreFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kong.ybook.R;
import com.kong.ybook.adapter.StoreBookListAdapter;
import com.kong.ybook.entity.Book;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by konglingyu on 2017/2/12.
 */

public class StoreShaonianFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shaonian,null);
        x.view().inject(this,view);
        return view;
    }

    private void setListeners() {

    }


}
