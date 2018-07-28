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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.activity.ResultActivity;
import com.example.jkpark.bucketlist_unit.model.VoteResult;
import com.example.jkpark.bucketlist_unit.model.VoteResultPic;
import com.squareup.picasso.Picasso;

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
        public ArrayList<ImageView> images = new ArrayList<>();
        public ArrayList<TextView> textViews = new ArrayList<>();
        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.template_result_title);
            images.add((ImageView) itemView.findViewById(R.id.template_pic_result1));
            images.add((ImageView) itemView.findViewById(R.id.template_pic_result2));
            images.add((ImageView) itemView.findViewById(R.id.template_pic_result3));
            images.add((ImageView) itemView.findViewById(R.id.template_pic_result4));
            images.add((ImageView) itemView.findViewById(R.id.template_pic_result5));

            textViews.add((TextView) itemView.findViewById(R.id.template_pic_result_desc1));
            textViews.add((TextView) itemView.findViewById(R.id.template_pic_result_desc2));
            textViews.add((TextView) itemView.findViewById(R.id.template_pic_result_desc3));
            textViews.add((TextView) itemView.findViewById(R.id.template_pic_result_desc4));
            textViews.add((TextView) itemView.findViewById(R.id.template_pic_result_desc5));
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
//        Random rand = new Random();
        holder.title.setText(voteResults.get(position).getName());
        Random rand = new Random();
        int idx = 0;
        for (ImageView view : holder.images) {
            if (idx == 0){
                int r = rand.nextInt(3);
                if (r == 0)Picasso.with(context).load(R.drawable.res1_1).into(view);
                else if (r == 1)Picasso.with(context).load(R.drawable.res1_2).into(view);
                else if (r == 2)Picasso.with(context).load(R.drawable.res1_3).into(view);

                holder.textViews.get(0).setVisibility(View.INVISIBLE);
            }
            else if (idx == 1) {
                int rnd = rand.nextInt(13);
                if (rnd > 5) {
                    Picasso.with(context).load(R.drawable.res2_1).into(view);
                    holder.textViews.get(1).setVisibility(View.INVISIBLE);
                }

            }
            idx++;
        }
    }

    public void setVoteResults(ArrayList<VoteResultPic> voteResults, int idx) {
        this.voteResults.get(idx).setVoteResultPics(voteResults);
//
    }

    @Override
    public int getItemCount() {
        return voteResults.size();
    }
}
