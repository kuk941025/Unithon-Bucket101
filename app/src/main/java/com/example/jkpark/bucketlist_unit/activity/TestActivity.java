package com.example.jkpark.bucketlist_unit.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jkpark.bucketlist_unit.MainActivity;
import com.example.jkpark.bucketlist_unit.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ArrayList<Class> listItems = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listItems.add(MainActivity.class);
        listItems.add(LoginActivity.class);
        listItems.add(SplashActivity.class);
        listItems.add(MakeBucketActivity.class);
        listItems.add(BucketDetailActivity.class);

        listItems.add(PopupActivity.class);
        listItems.add(RankingActivity.class);
        listItems.add(RecommendActivity.class);


        ListView lv = findViewById(R.id.test_listview);
        ArrayAdapter<Class> Adapter = new ArrayAdapter<Class>(this, android.R.layout.simple_list_item_1, listItems);

        lv.setAdapter(Adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), listItems.get(position));
                startActivity(i);
            }
        });


    }
}
