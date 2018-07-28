package com.example.jkpark.bucketlist_unit.adapter;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.model.VoteResult;

import java.util.ArrayList;

public class VoteListAdapter extends RecyclerView.Adapter<VoteListAdapter.ViewHolder> {
    ArrayList<VoteResult> voteResults;

    public VoteListAdapter(ArrayList<VoteResult> voteResults) {
        this.voteResults = voteResults;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public int numPics;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.template_result_title);

        }
    }
    @Override
    public VoteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_result, parent, false);
        return new ViewHolder(itemVIew);
    }

    @Override
    public void onBindViewHolder(VoteListAdapter.ViewHolder holder, int position) {
        holder.title.setText(voteResults.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return voteResults.size();
    }
}
