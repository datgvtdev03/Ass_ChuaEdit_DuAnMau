package com.example.datgvtph20617fptpolyphuongnamlib;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(getApplicationContext(), com.example.datgvtph20617fptpolyphuongnamlib.LoginActivity.class));
//                finish();
//            }
//        }, 1500);

        findViewById(R.id.img_action).setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });
    }
}