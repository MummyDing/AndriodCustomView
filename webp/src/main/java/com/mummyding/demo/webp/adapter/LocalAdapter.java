package com.mummyding.demo.webp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.mummyding.demo.webp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingqinying on 2017/12/2.
 */

public class LocalAdapter extends BaseAdapter {

    private static final int SIZE = 80;

    private Context mContext;
    private Resources mResources;
    private LayoutInflater mInflater;
    private final String mPrefix;

    private List<Integer> mImageIds = new ArrayList<>();

    public LocalAdapter(Context context, String prefix) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        mPrefix = prefix;
        createIds();
    }

    private void createIds() {
        mResources= mContext.getResources();
        for (int i = 0; i < SIZE; i++) {
            int id = mResources.getIdentifier(mPrefix + i,"drawable","com.mummyding.demo.webp");
            mImageIds.add(id);
        }
    }

    @Override
    public int getCount() {
        return SIZE;
    }

    @Override
    public Object getItem(int i) {
        return mImageIds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) view;
        if (imageView == null) {
            imageView = (ImageView) mInflater.inflate(R.layout.item_image, viewGroup, false);
        }
        Glide.with(mContext)
                .load((Integer) getItem(i))
                .into(imageView);
        return imageView;
    }

}
