package com.whombang.app.common.view.hideime;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.EditText;

/**
 * Created by qibin on 2016/6/2.
 */

public class AutoHideIMEFrameLayout extends FrameLayout {
    public AutoHideIMEFrameLayout(Context context) {
        super(context);
    }

    public AutoHideIMEFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoHideIMEFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
          //  Log.i("wwww","1111111111111111111111111");
            Context context = getContext();
            if (context == null || !(context instanceof Activity)) {
                return super.dispatchTouchEvent(ev);
            }
          //  Log.i("wwww","3333333333333333333333");
            Activity activity = (Activity) context;
            View focusView = activity.getCurrentFocus();

            if (shouldHideInputMethod(focusView, ev)) {
                //Log.i("wwww","444444444444444444444444444");
                hideInputMethod(focusView);
            }
        }else{
           // Log.i("wwww","2222222222222222");
        }

        return super.dispatchTouchEvent(ev);
    }

    private boolean shouldHideInputMethod(View focusView, MotionEvent event) {
        if (focusView == null) {
            return false;
        }
        
        if (focusView instanceof EditText) {
            return false;
        }
        
        Rect rect = new Rect();
        focusView.getHitRect(rect);
        if(rect.contains((int)event.getX(), (int)event.getY())) {
            return false;
        }
        return true;
    }

    private void hideInputMethod(View currentFocus) {
        if (currentFocus == null) { return;}
        InputMethodManager imm = (InputMethodManager) currentFocus.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
