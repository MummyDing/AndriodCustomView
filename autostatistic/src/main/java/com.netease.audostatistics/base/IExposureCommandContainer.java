package com.netease.audostatistics.base;

public interface IExposureCommandContainer extends ICommandContainer {
    /**
     * 获取box显示时要执行的命令
     * @return
     */
    ICommand getExposureAction();

    /**
     * 获取box消失时要执行的命令
     * @return
     */
    ICommand getUnExposureAction();
}
