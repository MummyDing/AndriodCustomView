package com.netease.audostatistics.statistics;

import com.netease.audostatistics.base.BaseEvent;
import com.netease.audostatistics.base.EventList;
import com.netease.audostatistics.base.IBox;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dingqinying
 * @date: 2018年05月16日.
 */

public class StatisticManager {

    private static StatisticManager sInstance;
    private Map<String, EventList> mEventListMap = new HashMap<>();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        if (sInstance == null) {
            sInstance = new StatisticManager();
        }
        return sInstance;
    }

    public void addEvent(String tag, BaseEvent event, IBox box) {
        EventList eventList = mEventListMap.get(tag);
        if (eventList == null) {
            eventList = new EventList();
            mEventListMap.put(tag, eventList);
        }
        event.addStatisticData(box.getStatisticData());
        eventList.addEvent(event);
    }

    public void removeEvent(String tag) {
        mEventListMap.remove(tag);
    }

}
