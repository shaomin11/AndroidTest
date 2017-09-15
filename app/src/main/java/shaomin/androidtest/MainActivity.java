package shaomin.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import shaomin.androidtest.model.LibModel;
import shaomin.androidtest.utils.DisplayUtils;

public class MainActivity extends Activity {
    private static final String TAG = "SM_MainActivity";
    boolean show = false;
    LibModel libModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        DisplayUtils.showSystemUI(getWindow().getDecorView(), false);
        setContentView(R.layout.activity_main);

//        LeakSingle.getInstance(this)
//                .setRetainedTextView((TextView) findViewById(R.id.go_btn));

        libModel = new LibModel();
    }

    public void onGoBtnClick(View view) {
        show = !show;
        DisplayUtils.showSystemUI(getWindow().getDecorView(), show);

        queryDb();
    }

    public void queryDb() {
        String dcimPath = "/storage/emulated/0/DCIM/Camera";
        List<String> pathList = new ArrayList<>();
        pathList.add(dcimPath);
        libModel.loadImageMediaInDir(this.getContentResolver(), pathList);
    }

}
