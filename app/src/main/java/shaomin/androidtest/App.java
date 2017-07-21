package shaomin.androidtest;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wangshaomin on 7/5/17.
 */

public class App extends Application {
    public static final String TAG = "SM_App";

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
//        LeakCanary.install(this);
        Log.i(TAG, "LeakCanary.install");
    }
}
