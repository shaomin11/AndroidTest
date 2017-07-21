package shaomin.androidtest.utils;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by wangshaomin on 6/9/17.
 */

public class StringUtils {
    public static boolean isEnglishInChineseEnv(Context context, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.replaceAll(" ", ""))) {
            return false;
        }

        if (context.getResources().getConfiguration().locale.getCountry().equals("CN")
                && str.replaceAll(" ", "").matches("^[a-zA-Z]*")) {
            return true;
        }

        return false;
    }
}
