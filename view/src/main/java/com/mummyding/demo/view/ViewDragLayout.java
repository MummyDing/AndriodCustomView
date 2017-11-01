package com.mummyding.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mummyding.demo.utils.DLog;

/**
 * Created by mummyding on 2017/11/1.
 */

public class ViewDragLayout extends FrameLayout {

    private static final String TAG = "ViewDragLayout";

    private float mLastX;
    private float mLastY;

    /**
     * 子View拖拽到边缘的padding
     */
    private int mChildViewDragPadding = 30;
    /**
     * 是否处于拖拽状态
     */
    private boolean mIsDraging;
    /**
     * 是否支持在子View区域之外进行拖拽
     */
    private boolean mAllowDragOutsideView = false;

    public ViewDragLayout(Context context) {
        this(context, null);
    }

    public ViewDragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 是否允许在View区域之外对View进行拖拽
     * @param allowDragOutsideView
     */
    public void setAllowDragOutsideView(boolean allowDragOutsideView) {
        this.mAllowDragOutsideView = allowDragOutsideView;
    }

    /**
     * 子View可拖拽到边缘的最大padding
     * @param dragPadding
     */
    public void setChildViewDragPadding(int dragPadding) {
        this.mChildViewDragPadding = dragPadding;
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalArgumentException("仅允许一个直接子View");
        }
        super.addView(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        if (getChildCount() > 0) {
            throw new IllegalArgumentException("仅允许一个直接子View");
        }
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    private void initView() {
        if (getChildCount() > 1) {
            throw new IllegalArgumentException("仅允许一个直接子View");
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean isViewNeedDrag = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mAllowDragOutsideView && !isPointInside(getChildView(), event.getX(), event.getY())) {
                    break;
                }
                mIsDraging = true;
                isViewNeedDrag = true;
                mLastX = event.getX();
                mLastY = event.getY();
                DLog.d(TAG, "ACTION_DOWN event xy " + mLastX + " " + mLastY);
                DLog.d(TAG, "ACTION_DOWN xy " + getX() + " " + getY());
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mIsDraging) {
                    return false;
                }
                move((event.getX() - mLastX), (event.getY() - mLastY));
                mLastX = event.getX();
                mLastY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mIsDraging = false;
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event) || isViewNeedDrag;
    }

    /**
     * 移动子View
     * @param offsetX
     * @param offsetY
     */
    private void move(float offsetX, float offsetY) {
        DLog.d(TAG, "move " + offsetX + " " + offsetY);
        View view = getChildView();
        if (view == null) {
            return;
        }
        DLog.d(TAG, "move xy " + view.getX() + " " + view.getY());
        float translationX = offsetX + view.getX();
        float translationY = offsetY + view.getY();

        if (check(view, translationX, translationY)) {
            view.setTranslationX(translationX);
            view.setTranslationY(translationY);
        }
    }

    /**
     * 检查View所有部分是否都被拖拽到ViewGroup之外
     * @param view
     * @param translationX
     * @param translationY
     * @return
     */
    private boolean check(View view, float translationX, float translationY) {
        if (view == null) {
            return false;
        }
        
        float right = translationX + view.getWidth() - mChildViewDragPadding;
        float left = translationX + mChildViewDragPadding;
        float top = translationY + mChildViewDragPadding;
        float bottom = translationY + view.getHeight() - mChildViewDragPadding;
        return (right > getX() && left < getX() + getWidth()) &&
                (top < getY() + getHeight() && bottom > getY());
    }

    /**
     * 点(x,y) 是否在view范围内
     * @param view
     * @param x
     * @param y
     * @return
     */
    private boolean isPointInside(View view, float x, float y) {
        if (view == null) {
            return false;
        }
        return (x > view.getX() && x < view.getX() + view.getWidth())
                && (y > view.getY() && y < view.getY() + view.getHeight());
    }

    /**
     * 获取直接子类
     * @return
     */
    private View getChildView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }
}
