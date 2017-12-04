package com.mummyding.demo.webp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.mummyding.demo.webp.activity.FrescoCompareActivity;
import com.mummyding.demo.webp.activity.GlideCompareActivity;
import com.mummyding.demo.webp.activity.GifActivity;
import com.mummyding.demo.webp.activity.LocalImageActivity;
import com.mummyding.demo.webp.activity.UriImageActivity;
import com.mummyding.demo.webp.activity.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBoxEnableWebP;
    private boolean mEnableWebP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupClickEvent(R.id.network_img);
        setupClickEvent(R.id.local_img);
        setupClickEvent(R.id.webview_img);
        setupClickEvent(R.id.clear_cache);
        setupClickEvent(R.id.glide_compare_img);
        setupClickEvent(R.id.gif_img);
        setupClickEvent(R.id.fresco_compare_img);

        mCheckBoxEnableWebP = findViewById(R.id.enable_webp);
        mCheckBoxEnableWebP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mEnableWebP = b;
            }
        });
    }

    private void setupClickEvent(int id) {
        findViewById(id).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.network_img:
                UriImageActivity.launch(this, mEnableWebP);
                break;
            case R.id.local_img:
                LocalImageActivity.launch(this, mEnableWebP);
                break;
            case R.id.webview_img:
                WebViewActivity.launch(this, mEnableWebP);
                break;
            case R.id.glide_compare_img:
                GlideCompareActivity.launch(this);
                break;
            case R.id.fresco_compare_img:
                FrescoCompareActivity.launch(this);
                break;
            case R.id.gif_img:
                GifActivity.launch(this);
                break;
            case R.id.clear_cache:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(getApplicationContext()).clearDiskCache();
                    }
                }).start();
                Glide.get(this).clearMemory();
                break;
            default:
                break;
        }
    }
}
