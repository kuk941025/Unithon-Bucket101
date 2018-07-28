package com.example.jkpark.bucketlist_unit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.model.Bucket;

import java.util.ArrayList;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ViewHolder> {
    ArrayList<Bucket> bucketList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.template_bucket_content);
        }
    }

    public BucketListAdapter(ArrayList<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_bucket, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(bucketList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bucketList.size();
    }
}
