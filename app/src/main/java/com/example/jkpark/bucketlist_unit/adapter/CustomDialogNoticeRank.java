package com.example.jkpark.bucketlist_unit.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jkpark.bucketlist_unit.R;

import java.util.List;

public class CustomDialogNoticeRank extends Dialog {
    private FrameLayout btnShowRes;
    private TextView btnClose;

    private String categoryStr;
    public CustomDialogNoticeRank(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_notify_rank);

        btnShowRes = (FrameLayout) findViewById(R.id.dialog_btn_show_res);
        btnClose = (TextView) findViewById(R.id.dialog_btn_close);

        btnShowRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Show res clicked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Show close clicked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

}
