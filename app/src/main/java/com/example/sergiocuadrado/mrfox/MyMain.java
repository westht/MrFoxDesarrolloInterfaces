package com.example.sergiocuadrado.mrfox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MyMain extends AppCompatActivity {
    private TextView txt;
    SwipeRefreshLayout swipe;
    FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt = (TextView)findViewById(R.id.mitexto);
        frame = (FrameLayout)findViewById(R.id.miframe);
        txt.setMovementMethod(new ScrollingMovementMethod());
        swipe = (SwipeRefreshLayout)findViewById(R.id.miswipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });




    }
    private void refresh(){
        Snackbar.make(frame,"Lost your fox?",3000).show();
        swipe.setRefreshing(false);

    }

}
