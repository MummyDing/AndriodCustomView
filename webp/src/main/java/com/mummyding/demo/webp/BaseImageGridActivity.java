package com.mummyding.demo.webp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseImageGridActivity extends AppCompatActivity {

    private GridView mImageGrid;
    protected BaseAdapter mAdapter;
    private TextView mMemoryInfo;
    private Timer mTimer;

    protected abstract void setupAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_image_grid);
        setupAdapter();
        initView();
    }

    private void initView() {
        mMemoryInfo = findViewById(R.id.memory_info);
        mImageGrid = findViewById(R.id.grid_view);
        mImageGrid.setAdapter(mAdapter);
        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mMemoryInfo.setText(" 已用内存:" + String.format("%.2f", MemoryUtil.getAllocatedMemory()) +
                                "MB");
                    }
                });
            }
        }, 500, 200);
    }
}
