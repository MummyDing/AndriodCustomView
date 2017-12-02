package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;

import com.mummyding.demo.webp.BaseImageGridActivity;
import com.mummyding.demo.webp.adapter.LocalAdapter;

/**
 * Created by dingqinying on 2017/12/2.
 */

public class LocalImageActivity extends BaseImageGridActivity {

    private static String mPrefix;

    public static void launch(Context context, boolean enableWebP) {
        Intent intent = new Intent(context, LocalImageActivity.class);
        context.startActivity(intent);
        mPrefix = enableWebP ? "webp" : "jpg";
    }
    @Override
    protected void setupAdapter() {
        setTitle("本地图片:" + mPrefix);
        mAdapter = new LocalAdapter(this, mPrefix);
    }
}
