package com.netease.audostatistics.base;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dingqinying
 * @date: 2018年05月16日.
 */

public abstract class BaseEvent implements ICommandContainer, OnClickListener {

    private static final String TAG = "BaseEvent";
    private ID mId;
    private Map<String, String> mStatisticData = new HashMap<>();

    public BaseEvent(ID id) {
        mId = id;
        mStatisticData.putAll(id.toMap());
    }

    public static class ID {
        String pageName;
        String module;
        String scene;
        String id;

        public Map<String, String> toMap() {
            Map<String, String> map = new HashMap<>();
            map.put("pageName", pageName);
            map.put("scene", scene);
            map.put("module", module);
            map.put("id", id);
            return map;
        }
    }

    public void addStatisticData(Map<String, String> map) {
        mStatisticData.putAll(map);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, mStatisticData.toString());
    }
}
