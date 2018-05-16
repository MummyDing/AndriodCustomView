package com.netease.audostatistics.base;

import android.util.Pair;

public class BoxModelAndCommands<V extends IViewModel, A extends ICommandContainer> extends Pair<V, A> {


    public final V mViewModel;
    public final A mUserAction;
    /**
     * Constructor for a Pair.
     *
     * @param viewModel  the first object in the Pair
     * @param userAction the second object in the pair
     */
    public BoxModelAndCommands(V viewModel, A userAction) {
        super(viewModel, userAction);
        this.mViewModel = viewModel;
        this.mUserAction = userAction;
    }
}
