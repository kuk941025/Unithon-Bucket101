package com.example.jkpark.bucketlist_unit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jkpark.bucketlist_unit.adapter.BucketListAdapter;
import com.example.jkpark.bucketlist_unit.model.Bucket;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecylerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private BucketListAdapter bucketListAdapter;
    private Spinner spinnerSort;
    ArrayList<Bucket> buckets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = (RecyclerView)findViewById(R.id.home_bucket_recyclerview);
        spinnerSort = (Spinner)findViewById(R.id.main_spinner_sort);
        mRecylerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(mLayoutManager);

        //temp date
        String[] arraySpinner = new String[]{
                "좋아요순", "싫어요순", "날짜순"
        };
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adpater);


        for (int i = 0; i < 100; i++)
            buckets.add(new Bucket(String.valueOf(i)));
        bucketListAdapter = new BucketListAdapter(buckets);
        mRecylerView.setAdapter(bucketListAdapter);
    }
}
