package com.example.jkpark.bucketlist_unit.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.model.VoteResult;

import java.util.ArrayList;
import java.util.Random;

public class VoteListAdapter extends RecyclerView.Adapter<VoteListAdapter.ViewHolder> {
    Context context;
    ArrayList<VoteResult> voteResults;

    public VoteListAdapter(ArrayList<VoteResult> voteResults, Context context) {
        this.context = context;
        this.voteResults = voteResults;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.template_result_pic_layout);
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
        int numPics = voteResults.get(position).getNum_pics();
        Random rand = new Random();
        holder.title.setText(voteResults.get(position).getName());
        holder.layout.setOrientation(LinearLayout.HORIZONTAL);
        if (numPics == 0) numPics = rand.nextInt(5) + 3;

        for (int i = 0; i < 10; i++){
            ImageView image = new ImageView(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, 400);
            lp.setMarginStart(25);
            image.setLayoutParams(lp);
            image.setBackgroundColor(Color.GRAY);
            holder.layout.addView(image);
        }

    }

    @Override
    public int getItemCount() {
        return voteResults.size();
    }
}
