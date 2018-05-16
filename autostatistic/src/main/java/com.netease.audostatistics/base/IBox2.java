package com.netease.audostatistics.base;

public interface IBox2<V extends IViewModel, C extends ICommandContainer> extends IBox<V> {

    /**
     * 绑定用户的行为容器
     * @param commandContainer
     */
    void bindCommandContainer(C commandContainer);
}
