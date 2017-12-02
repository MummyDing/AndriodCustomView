package com.mummyding.demo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by dingqinying on 2017/11/22.
 */

public class RouterApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
