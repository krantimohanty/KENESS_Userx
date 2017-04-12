package com.kenresource.keness.user;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashHandlar(4000);
    }

    public void splashHandlar(int timeOut){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent in = new Intent(SplashActivity_old.this, SliderActivity.class);
                Intent in = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(in);
                finish();
//                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);

            }
        }, timeOut);
    }
}
