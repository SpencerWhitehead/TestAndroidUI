package com.temp.temp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by whites5 on 2/24/16.
 */
public class SquareAdapter extends  BaseAdapter{
    private Context mContext;

    public SquareAdapter(Context c) {
        mContext = c;
    }

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
    public ImageView getView(int position, View convertView, ViewGroup parent) {
        ImageView view;
        view = new ImageView(mContext);
        view.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        view.setImageResource(position);
        return view;
    }

}
