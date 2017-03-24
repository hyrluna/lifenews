package xh.lifenews.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by bamboo on 16-11-30.
 * 处理触摸事件分发
 */

public class NewsViewPager extends ViewPager {

    private boolean isDispatchTouchEvent = true;

    public NewsViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return isDispatchTouchEvent && super.dispatchTouchEvent(ev);
    }

    public boolean isDispatchTouchEvent() {
        return isDispatchTouchEvent;
    }

    public void setDispatchTouchEvent(boolean dispatchTouchEvent) {
        isDispatchTouchEvent = dispatchTouchEvent;
    }
}
