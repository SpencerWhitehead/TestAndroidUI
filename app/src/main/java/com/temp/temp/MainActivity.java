package com.temp.temp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.GridView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(new SquareAdapter(this));
//        getFragmentManager().beginTransaction().commit();
    }
}


