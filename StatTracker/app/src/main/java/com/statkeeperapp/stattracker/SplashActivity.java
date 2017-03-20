package com.statkeeperapp.stattracker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView logo = (ImageView)findViewById(R.id.splash_image);
        Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation zoom_out = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        logo.setAnimation(fade_in);
        logo.setAnimation(zoom_out);
        final int secondsDelayed = 1;
        final int waitForAnimation = 1;
        logo.startAnimation(fade_in);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                logo.startAnimation(zoom_out);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, StartActivity.class));
                        finish();
                    }
                }, waitForAnimation * 220);


            }
        }, secondsDelayed * 500);
    }
}
