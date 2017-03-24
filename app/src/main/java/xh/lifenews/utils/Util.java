package xh.lifenews.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by bamboo on 16-11-27.
 */

public class Util {

    public static void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static String getString(Context context, int resID) {
        return context.getResources().getString(resID);
    }

    public static int getColor(Context context, int resID) {
        return context.getResources().getColor(resID);
    }

    public static float getDimension(Context context, int resID) {
        return context.getResources().getDimension(resID);
    }

    public static boolean isNetworkUsable(AppCompatActivity activity) {
        ConnectivityManager conmgr = (ConnectivityManager)
                activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conmgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        Boolean isWifiConn = networkInfo.isConnected();
        networkInfo = conmgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        Boolean isMobileConn = networkInfo.isConnected();
        return isWifiConn | isMobileConn;
    }

    public static void setBackgroundColorAndRetainShape(final int color, final Drawable background) {

        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background.mutate()).getPaint().setColor(color);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background.mutate()).setColor(color);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(color);
        }else{
            Log.w("util","Not a valid background type");
        }

    }

//    protected void hideSoftKeyboard() {
//        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
//            if (getCurrentFocus() != null)
//                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
//                        InputMethodManager.HIDE_NOT_ALWAYS);
//        }
//    }

    public static void hideSoftKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public static void showSoftKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

}
