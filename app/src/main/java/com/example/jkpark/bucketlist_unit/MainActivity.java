package com.example.jkpark.bucketlist_unit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jkpark.bucketlist_unit.global.GlobalVar;

public class MainActivity extends AppCompatActivity {

    private GlobalVar global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        global = (GlobalVar)getApplicationContext();

        Log.d("email1234", global.email);
    }
}
