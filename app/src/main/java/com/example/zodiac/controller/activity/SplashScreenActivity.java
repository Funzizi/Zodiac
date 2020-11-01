package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.zodiac.R;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView imvIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imvIcon = findViewById(R.id.imv_splash_screen);
        imvIcon.startAnimation(AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.splash_screen));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MenuActivity.class));
                finish();
            }
        },1500);
    }
}