package com.example.jkpark.bucketlist_unit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.adapter.BucketListAdapter;
import com.example.jkpark.bucketlist_unit.adapter.VoteListAdapter;
import com.example.jkpark.bucketlist_unit.model.VoteResult;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<VoteResult> voteResults;
    private VoteListAdapter voteListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mRecyclerView = (RecyclerView)findViewById(R.id.result_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        voteResults = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            voteResults.add(new VoteResult("유럽여행 꼭 가고싶어요" + i));
        }
        voteListAdapter = new VoteListAdapter(voteResults);
        mRecyclerView.setAdapter(voteListAdapter);
    }
}
