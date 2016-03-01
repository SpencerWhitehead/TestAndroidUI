package com.temp.temp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(new SquareAdapter(this));

//        int ideal_size = calculateIdealSize();
//        ViewGroup.LayoutParams params = gridview.getLayoutParams();
//        params.width = ideal_size;
//        params.height = ideal_size;
//        gridview.setLayoutParams(params);
//        Log.d("Size", Integer.toString(ideal_size));
    }

    private int calculateIdealSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int boxes = Math.round(width / 185);
        return width/boxes;
    }
}


