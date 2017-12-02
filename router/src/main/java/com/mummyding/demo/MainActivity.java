package com.mummyding.demo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Button mToNormalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToNormalButton = findViewById(R.id.to_normal);
        mToNormalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterMap.RAW)
                .navigation(/*getApplicationContext(), new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d(TAG, "onFound");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
//                        postcard.setUri(Uri.parse(RouterMap.TAG));
//                        ARouter.getInstance().navigation(getApplicationContext(),postcard, 3, null);
                        Log.d(TAG, "onLost");

                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d(TAG, "onArrival");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.d(TAG, "onInterrupt");
                    }
                }*/);
            }
        });
    }
}
