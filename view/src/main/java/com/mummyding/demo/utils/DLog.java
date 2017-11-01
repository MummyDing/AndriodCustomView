package com.mummyding.demo.utils;

import android.util.Log;

/**
 * Created by mummyding on 2017/11/1.
 */

public class DLog {

    public static boolean DEBUG = true;
    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }
}
