package com.mummyding.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.mummyding.demo.utils.DLog;

/**
 * Created by mummyding on 2017/10/31.
 */

public class DragView extends View {

    private static final String TAG = "DragView";
    private float mLastX = 0;
    private float mLastY = 0;
    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    void initView() {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mLastX = motionEvent.getX();
                        mLastY = motionEvent.getY();
                        DLog.d(TAG, "ACTION_DOWN " + motionEvent.getX() + " " + motionEvent.getY());
                        DLog.d(TAG, "ACTION_DOWN par xy" + getX() + " " + getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        DLog.d(TAG, "ACTION_MOVE " + motionEvent.getX() + " " + motionEvent.getY());
                        DLog.d(TAG, "ACTION_MOVE raw " + motionEvent.getRawX() + " " + motionEvent.getRawY());
                        DLog.d(TAG, "ACTION_MOVE left " + getLeft() + " " + getTop());
                        DLog.d(TAG, "ACTION_MOVE trans " + getTranslationX() + " " + getTranslationY());
                        float mx = getX() + (motionEvent.getX() - mLastX);
                        float my = getY() + (motionEvent.getY() - mLastY);
                        DLog.d(TAG, "ACTION_MOVE xy " + mx + " " + my);
                        setTranslationX(mx);
                        setTranslationY(my);
                        break;
                    case MotionEvent.ACTION_UP:
                        DLog.d(TAG, "ACTION_UP " + motionEvent.getX() + " " + motionEvent.getY());
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
