package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mummyding.demo.webp.R;

public class FrescoCompareActivity extends AppCompatActivity {

    private SimpleDraweeView mTranWebp;

    public static void launch(Context context) {
        Intent intent = new Intent(context, FrescoCompareActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_compare);
        setTitle("Fresco加载WebP图片 兼容性对比");
        mTranWebp = findViewById(R.id.trans_webp);
        Uri uri = new Uri.Builder().scheme("res")
                .path(String.valueOf(R.drawable.test_trans_image_webp))
                .build();
        mTranWebp.setImageURI(uri);
    }
}
