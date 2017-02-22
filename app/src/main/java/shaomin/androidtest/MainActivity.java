package shaomin.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import shaomin.androidtest.utils.DisplayUtils;

public class MainActivity extends Activity {
    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        DisplayUtils.showSystemUI(getWindow().getDecorView(), false);
        setContentView(R.layout.activity_main);
    }

    public void onGoBtnClick(View view) {
        show = !show;
        DisplayUtils.showSystemUI(getWindow().getDecorView(), show);
    }
}
