package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;

import com.mummyding.demo.webp.BaseImageGridActivity;
import com.mummyding.demo.webp.adapter.UrlAdapter;

/**
 * Created by dingqinying on 2017/12/2.
 */

public class UriImageActivity extends BaseImageGridActivity {

    private static String mUrlParam;

    public static void launch(Context context, boolean enableWebP) {
        Intent intent = new Intent(context, UriImageActivity.class);
        context.startActivity(intent);
        mUrlParam = enableWebP ? "&type=webp" : "";
    }

    @Override
    protected void setupAdapter() {
        setTitle("网络图片:" + mUrlParam);
        mAdapter = new UrlAdapter(this, mUrlParam);
    }
}
