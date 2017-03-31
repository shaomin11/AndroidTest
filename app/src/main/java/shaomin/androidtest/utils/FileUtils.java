package shaomin.androidtest.utils;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

import shaomin.androidtest.BuildConfig;

/**
 * Created by wangshaomin on 3/30/17.
 */

public class FileUtils {

    /**
     * 从filePath格式的file://转为FileProvider格式的uri
     * Ex:
     * File file = new File("/storage/emulated/0/DCIM/Camera/VID_20170502_033348.3gp");
     * Uri uri = FileUtils.getFileProviderUri(this, file);
     * <p>
     * 有时候对应intent要加以下权限, 否则会有security check error
     * intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
     **/
    public static final Uri getFileProviderUri(Context context, File file) {
        if (file != null) {
            return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
        } else {
            return null;
        }
    }
}
