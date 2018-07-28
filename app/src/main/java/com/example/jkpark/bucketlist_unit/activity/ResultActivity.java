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
import com.example.jkpark.bucketlist_unit.model.VoteResultPic;

import java.util.ArrayList;
import java.util.Random;

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
        voteListAdapter = new VoteListAdapter(voteResults, getApplicationContext());
        Random rand = new Random();
        for (int i = 0; i < 100; i++){
            ArrayList<VoteResultPic> voteResultPics = new ArrayList<>();
            voteResults.add(new VoteResult("유럽여행 꼭 가고싶어요" + i));
            int num = rand.nextInt(5);
            int j = 0;
            for (; j < num ; j++){
                voteResultPics.add(new VoteResultPic(j, "Y"));
            }
            for (; j < 5; j++){
                voteResultPics.add(new VoteResultPic(j, ""));
            }
            voteListAdapter.setVoteResults(voteResultPics, i);
        }

        voteListAdapter.notifyDataSetChanged();

        mRecyclerView.setAdapter(voteListAdapter);

    }
}
