package com.example.sergiocuadrado.mrfox;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class MySplash extends AppCompatActivity {
    private CircularImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/AmaticSC-Regular.ttf");
        ((TextView)findViewById(R.id.txtviewSplash)).setTypeface(font);
        getSupportActionBar().hide();
        Thread empezar = new Thread(){
            @Override
            public void run() {
                try {
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(3000);
                    rotate.setInterpolator(new LinearInterpolator());
                    imagen = (CircularImageView)findViewById(R.id.circ);
                    imagen.startAnimation(rotate);

                    sleep(3000);
                }catch (Exception e){

                }
                finally {
                    Intent intent = new Intent(MySplash.this, MyLogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };
        empezar.start();
    }
}
