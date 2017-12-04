package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mummyding.demo.webp.R;

public class CompareActivity extends AppCompatActivity {



    public static void launch(Context context) {
        Intent intent = new Intent(context, CompareActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        Glide.with(this)
                .load(R.drawable.test_trans_image_webp)
                .into((ImageView) findViewById(R.id.replace));
    }
}
