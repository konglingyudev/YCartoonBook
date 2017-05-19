package com.kong.ybook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kong.ybook.R;
import com.kong.ybook.entity.Book;

import org.xutils.x;

import java.util.List;

/**
 * Created by konglingyu on 2017/2/22.
 */

public class StoreBookListAdapter extends BaseAdapter{
    private Context context;
    private List<Book> booklists;
    private LayoutInflater inflater;

    public StoreBookListAdapter(Context context, List<Book> booklists) {
        this.context = context;
        this.booklists = booklists;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return booklists.size();
    }

    @Override
    public Book getItem(int i) {
        return booklists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder=null;
        if(view == null){
            view = inflater.inflate(R.layout.item_store, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.textView = (TextView) view.findViewById(R.id.bookname);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        Book booklist = getItem(i);
        holder.textView.setText(booklist.getName());
        x.image().bind(holder.imageView, booklist.getCoverImg());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
