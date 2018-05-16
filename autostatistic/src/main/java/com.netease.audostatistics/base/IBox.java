package com.netease.audostatistics.base;

import android.view.View;
import java.util.Map;

public interface IBox<T> {

    View asView();

    void update();

    void bindViewModel(T viewModel);

    void bindStatisticData(Map<String, String> statisticsData);

    Map<String, String> getStatisticData();
}
