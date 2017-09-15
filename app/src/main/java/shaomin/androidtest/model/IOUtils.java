package shaomin.androidtest.model;

import android.database.Cursor;

/**
 * Created by wangshaomin on 15/09/2017.
 */

public class IOUtils {

    public static void close(Cursor c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
