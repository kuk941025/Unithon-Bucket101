package com.example.jkpark.bucketlist_unit.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.adapter.CustomDialogNoticeRank;

public class BucketDetailActivity extends AppCompatActivity {
    Button btnLike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_detail);

        btnLike = (Button)findViewById(R.id.detail_btn_like);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CustomDialogNoticeRank dialog= new CustomDialogNoticeRank(BucketDetailActivity.this);
                dialog.show();

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });
            }
        });
    }
}
