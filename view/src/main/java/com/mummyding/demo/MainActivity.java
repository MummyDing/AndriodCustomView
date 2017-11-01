package com.mummyding.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.mummyding.demo.utils.DLog;
import com.mummyding.demo.view.R;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.child_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DLog.d(TAG, "onClick");
            }
        });
    }

}
