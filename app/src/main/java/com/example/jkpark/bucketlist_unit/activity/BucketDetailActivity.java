package com.example.jkpark.bucketlist_unit.activity;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.adapter.CustomDialogNoticeRank;
import com.github.irshulx.Editor;
import com.github.irshulx.models.EditorContent;

import java.util.HashMap;
import java.util.Map;

public class BucketDetailActivity extends AppCompatActivity {

    TextView html;
    Button btnLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String serialized = getIntent().getStringExtra("content");

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

        Editor renderer= (Editor)findViewById(R.id.renderer);
        Map<Integer, String> headingTypeface = getHeadingTypeface();
        Map<Integer, String> contentTypeface = getContentface();
        renderer.setHeadingTypeface(headingTypeface);
        renderer.setContentTypeface(contentTypeface);
        renderer.setDividerLayout(R.layout.tmpl_divider_layout);
        renderer.setEditorImageLayout(R.layout.tmpl_image_view);
        renderer.setListItemLayout(R.layout.tmpl_list_item);
        String content = serialized;
        EditorContent Deserialized = renderer.getContentDeserialized(content);
        if (Deserialized != null) renderer.render(Deserialized);

    }

    public Map<Integer,String> getHeadingTypeface() {
        Map<Integer, String> typefaceMap = new HashMap<>();
        typefaceMap.put(Typeface.NORMAL,"fonts/Audiowide-Regular.ttf");
        typefaceMap.put(Typeface.BOLD,"fonts/Audiowide-Regular.ttf");
        typefaceMap.put(Typeface.ITALIC,"fonts/Audiowide-Regular.ttf");
        typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/Audiowide-Regular.ttf");
        return typefaceMap;
    }

    public Map<Integer,String> getContentface() {
        Map<Integer, String> typefaceMap = new HashMap<>();
        typefaceMap.put(Typeface.NORMAL,"fonts/Lato-Medium.ttf");
        typefaceMap.put(Typeface.BOLD,"fonts/Lato-Bold.ttf");
        typefaceMap.put(Typeface.ITALIC,"fonts/Lato-MediumItalic.ttf");
        typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/Lato-BoldItalic.ttf");
        return typefaceMap;
    }

}
