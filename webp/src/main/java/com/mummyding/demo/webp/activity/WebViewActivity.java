package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.mummyding.demo.webp.R;

public class WebViewActivity extends AppCompatActivity {

    private static String mHTMLSourceName;

    private TextView mTimeTip;
    private WebView mWebView;
    private long mStartTime;

    public static void launch(Context context, boolean enableWebP) {
        Intent intent = new Intent(context, WebViewActivity.class);
        context.startActivity(intent);
        mHTMLSourceName = enableWebP ? "webpimages" : "jpgimages";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("WebView加载图片");
        setContentView(R.layout.activity_web_view);
        mTimeTip = findViewById(R.id.time);
        mWebView = findViewById(R.id.webview);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mTimeTip.setText((System.currentTimeMillis() - mStartTime) + "ms");
                }
            }
        });
        mStartTime = System.currentTimeMillis();
        mWebView.loadUrl("file:///android_asset/"+ mHTMLSourceName + ".html");
    }
}
