package xh.lifenews.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import net.cachapa.expandablelayout.ExpandableLayout;

/**
 * Created by bamboo on 16-11-30.
 */

public class ExpandableView extends ExpandableLayout {

    public static final int EXPAND_VIEW_MSG = 0;
    private static float startX = 0;
    private static float startY = 0;
    private static boolean isCollapse = false;
    private Handler mHandler;

    public ExpandableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //expand layout 滑动事件拦截，由于默认是不拦截，直接分发给子view。
    // 因此这里先处理事件，但是不消耗事件，事件处理完成后，再分发给子view。
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = ev.getX();
                float moveY = ev.getY();
                if (startY - moveY > 10.0) {
                    isCollapse = true;
                } else {
                    isCollapse = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isCollapse) {
                    mHandler.sendEmptyMessage(EXPAND_VIEW_MSG);
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }

}
