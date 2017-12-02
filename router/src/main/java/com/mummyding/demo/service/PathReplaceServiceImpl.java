package com.mummyding.demo.service;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.mummyding.demo.RouterMap;

/**
 * Created by dingqinying on 2017/11/22.
 */
@Route(path = RouterMap.RAW)
public class PathReplaceServiceImpl implements PathReplaceService {
    @Override
    public String forString(String path) {
        if (path.equals(RouterMap.RAW)) {
            Log.d("Path", path);
            return RouterMap.TAG;
        }
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        return uri;
    }

    @Override
    public void init(Context context) {

    }
}
