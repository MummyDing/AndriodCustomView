package com.mummyding.demo.webp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashSet;
import java.util.Set;

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
                break;
            case R.id.local_img:
                break;
            case R.id.webview_img:
                break;
            default:
                break;
        }
    }
}
