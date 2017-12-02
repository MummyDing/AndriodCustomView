package com.mummyding.demo.target;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mummyding.demo.R;

public abstract class BaseEmptyActivity extends AppCompatActivity {

    private TextView mPageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_empty);
        initView();
    }

    protected void setContent(String content) {
        if (mPageInfo != null) {
            mPageInfo.setText(content);
        }
    }

    private void initView() {
        mPageInfo = findViewById(R.id.page_info);
    }

}
