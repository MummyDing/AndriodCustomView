package com.mummyding.demo.webp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mummyding.demo.webp.R;
import com.mummyding.demo.webp.adapter.ImageUrls;

/**
 * Created by dingqinying on 2017/12/2.
 */

public class UrlAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private String mUrlParam;

    public UrlAdapter(Context context, String urlParam) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mUrlParam = urlParam;
    }

    @Override
    public int getCount() {
        return ImageUrls.URLS.length;
    }

    @Override
    public Object getItem(int i) {
        return ImageUrls.URLS[i] + mUrlParam;
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
        String url = (String) getItem(i);

        Glide.with(mContext).load(url).into(imageView);
        return imageView;
    }
}
