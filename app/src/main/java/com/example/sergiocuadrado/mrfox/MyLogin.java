package com.example.sergiocuadrado.mrfox;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MyLogin extends AppCompatActivity {
    private EditText usr,pwd;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        this.setFinishOnTouchOutside(true);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/AmaticSC-Regular.ttf");
        ((TextView)findViewById(R.id.txtlogin)).setTypeface(font);
        final Dialog dialog = new Dialog(MyLogin.this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.show();
        usr = (EditText) dialog.findViewById(R.id.user);
        pwd = (EditText) dialog.findViewById(R.id.pass);
        login = (Button) dialog.findViewById(R.id.login);
        ((TextView)dialog.findViewById(R.id.txlog)).setTypeface(font);
        login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = MotionEventCompat.getActionMasked(motionEvent);

                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        login.setBackgroundColor(getResources().getColor(R.color.naranja));
                        login.setTextColor(getResources().getColor(R.color.darkgrey));
                        return false;

                    case (MotionEvent.ACTION_UP):
                        login.setBackgroundColor(getResources().getColor(R.color.moradocolor));
                        login.setTextColor(getResources().getColor(R.color.white));
                        return false;


                }
                return false;

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLogin.this,MyMain.class);
                startActivity(intent);

            }
        });
    }
}
