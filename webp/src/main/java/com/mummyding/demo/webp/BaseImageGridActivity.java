package com.mummyding.demo.webp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;

public abstract class BaseImageGridActivity extends AppCompatActivity {

    private GridView mImageGrid;
    protected BaseAdapter mAdapter;

    protected abstract void setupAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_image_grid);
        setupAdapter();
        initView();
    }

    private void initView() {
        mImageGrid = findViewById(R.id.grid_view);
        mImageGrid.setAdapter(mAdapter);
    }
}
