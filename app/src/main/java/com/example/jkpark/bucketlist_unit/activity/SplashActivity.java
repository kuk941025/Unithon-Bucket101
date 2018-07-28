package com.example.jkpark.bucketlist_unit.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jkpark.bucketlist_unit.MainActivity;
import com.example.jkpark.bucketlist_unit.R;

public class SplashActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
         Handler handler = new Handler();
         handler.postDelayed(new splashHandler(), 1500);
    }

    private class splashHandler implements Runnable{
        @Override
        public void run() {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            SplashActivity.this.finish();
        }
    }
}
