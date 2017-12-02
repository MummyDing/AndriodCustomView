package com.mummyding.demo.target;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mummyding.demo.RouterMap;

/**
 * Created by dingqinying on 2017/11/22.
 */
@Route(path = RouterMap.TAG)
public class NormalActivity extends BaseEmptyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent("NormalActivity");
    }
}
