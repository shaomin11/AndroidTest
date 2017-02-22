package shaomin.androidtest.utils;

import android.view.View;

/**
 * Created by wangshaomin on 2/22/17.
 */

public class DisplayUtils {

    /**
     * 显示或隐藏系统状态栏, 一般用于NoActionBar主题.
     * 对已经设置android:windowFullscreen为true的主题不起作用, 需要clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
     *
     * @param view
     * @param show
     */
    public static void showSystemUI(View view, boolean show) {
        int flag = 0;
        if (show) {
            flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        } else {
            flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        view.setSystemUiVisibility(flag);
    }
}
