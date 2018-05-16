package com.netease.audostatistics.base;

import android.view.View;

public interface IBox<T> {

    View asView();

    void bindViewModel(T viewModel);

    void update();
}
