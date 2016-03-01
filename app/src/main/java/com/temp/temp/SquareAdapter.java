package com.temp.temp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by whites5 on 2/24/16.
 */
public class SquareAdapter extends  BaseAdapter{
    private Context mContext;
    private final String[] vals = new String[] {"Spencer", "Julius", "Peter", "Ray", "Spetelius"};

    public SquareAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return vals.length;
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
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gv;
        if (convertView == null) {
            // get layout from mobile.xml
            gv = inflater.inflate(R.layout.grid_item, null);

            // set value into textview
            TextView textView = (TextView) gv.findViewById(R.id.grid_item_text);
            textView.setText(vals[position]);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            gv.setBackgroundColor(color);
        } else {
            gv = convertView;
        }

        return gv;
    }

}
