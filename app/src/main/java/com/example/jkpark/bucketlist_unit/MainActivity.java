package com.example.jkpark.bucketlist_unit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jkpark.bucketlist_unit.adapter.BucketListAdapter;
import com.example.jkpark.bucketlist_unit.model.Bucket;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecylerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private BucketListAdapter bucketListAdapter;
    ArrayList<Bucket> buckets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = findViewById(R.id.home_bucket_recyclerview);
        mRecylerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(mLayoutManager);

        //temp date

        for (int i = 0; i < 100; i++)
            buckets.add(new Bucket(String.valueOf(i)));
        bucketListAdapter = new BucketListAdapter(buckets);
        mRecylerView.setAdapter(bucketListAdapter);
    }
}
