package com.mummyding.demo.webp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.mummyding.demo.webp.activity.LocalImageActivity;
import com.mummyding.demo.webp.activity.UriImageActivity;

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
