package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.desawisaratempellmahbang.R;
import com.example.desawisaratempellmahbang.loginUser;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //splashscreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashScreen.this, loginUser.class);
                startActivity(login);
                finish();
            }
        },2500L);
    }
}