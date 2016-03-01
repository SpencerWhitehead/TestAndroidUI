package com.temp.temp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
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

    int fID = 0;

    public int generateViewId(View v) {
        while( v.findViewById(++fID) != null );
        return fID;
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

    private int calculateIdealSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        // in dp
        double idealSize = 182.5;
        float density = mContext.getResources().getDisplayMetrics().density;
        int screenWidth = (int) Math.round(metrics.widthPixels/density);
        int numSquares = (int) Math.round(screenWidth/idealSize);
        return (int) (screenWidth*density)/numSquares;
    }

    protected int generateRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gv;
        if (convertView == null) {
            gv = inflater.inflate(R.layout.grid_item_container, null);

            int ideal_size = calculateIdealSize();
            gv.setLayoutParams(new GridView.LayoutParams(ideal_size, ideal_size));
            FragmentManager fm = ((Activity) mContext).getFragmentManager();

            Fragment front = new GridItemFrontFragment();
            Bundle args = new Bundle();
            args.putString("name", vals[position]);
            front.setArguments(args);
//            int id = generateViewId(gv);
            int id = position+1;
            gv.setId(id);
            Log.d("ID", Integer.toString(gv.getId()));
            fm.beginTransaction().add(id, front).commit();
        } else {
            gv = convertView;
        }

        return gv;
    }

    /**
     * A fragment representing the front of the card.
     */
    public static class GridItemFrontFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.grid_item_front, container, false);
            v.setBackgroundColor(generateRandomColor());
            TextView textView = (TextView) v.findViewById(R.id.grid_item_front_text);
            textView.setText(this.getArguments().getString("name"));
            return v;
        }

        private int generateRandomColor() {
            Random rnd = new Random();
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class GridItemBackFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.grid_item_back, container, false);
        }
    }
}
