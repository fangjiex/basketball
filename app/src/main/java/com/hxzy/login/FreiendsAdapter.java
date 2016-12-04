package com.hxzy.login;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Administrator on 2016/9/27.
 */
public class FreiendsAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = View.inflate(parent.getContext(),R.layout.item_friends_lv,null);
        return itemView;
    }
}
