package com.netease.audostatistics.base;

import android.util.SparseArray;

/**
 * @author: dingqinying
 * @date: 2018年05月16日.
 */

public class EventList {

    private SparseArray<BaseEvent> mEvents = new SparseArray<>();


    public void addEvent(BaseEvent event) {
        if (event != null) {
            mEvents.append(event.hashCode(), event);
        }
    }

    public void removeEvent(BaseEvent event) {
        if (event != null) {
            mEvents.remove(event.hashCode());
        }
    }

}
