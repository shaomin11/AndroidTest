package shaomin.androidtest.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshaomin on 15/09/2017.
 */

public class LibModel {
    private static final String TAG = "SM_LibModel";
    private static String[] IMAGE_PROJECTION = new String[]{
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media.MIME_TYPE,
            MediaStore.Images.Media.LATITUDE,
            MediaStore.Images.Media.LONGITUDE,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT,
            MediaStore.Images.Media.ORIENTATION
    };
    public static final byte FORMAT_JPG = 0x02;

    public List<LocalMedia> loadImageMediaInDir(ContentResolver cr, List<String> targetPaths) {
        List<LocalMedia> items = new ArrayList<>();
        Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] selectionArgs = {targetPaths.get(0) + "%"};

        Cursor cur = cr.query(images, IMAGE_PROJECTION,
                MediaStore.Images.Media.DATA + " like ?",
                selectionArgs,
                MediaStore.Images.Media.DATE_ADDED + " DESC");
        Log.d(TAG, "cursor.size= " + cur.getCount());

        if (cur != null) {
            try {
                while (cur.moveToNext()) {
                    LocalMedia localMedia = toImageItem(cur);
                    items.add(localMedia);
                }
            } finally {
                IOUtils.close(cur);
            }
        }
        return items;
    }

    @NonNull
    public LocalMedia toImageItem(@NonNull Cursor cursor) {
        long localId = cursor.getLong(0);
        String localPath = cursor.getString(1);
        long createdAt = cursor.getLong(2) * 1000;
        long takenAt = cursor.getLong(3);
        String mime = cursor.getString(4);
        double latitude = cursor.getDouble(5);
        double longitude = cursor.getDouble(6);
        long fileSize = cursor.getLong(7);

        if (localPath != null) {
            File file = new File(localPath);
            long size = file.length();
            if (size > 0) {
                fileSize = size;
            }
        }

        int width = cursor.getInt(8);
        int height = cursor.getInt(9);
        int orientation = convertOrientation(cursor.getInt(10));
        LocalMedia localMedia = new LocalMedia(localId, localPath, takenAt > 0 ? takenAt : createdAt, createdAt,
                FORMAT_JPG, fileSize, takenAt,
                latitude, longitude, 0,
                width, height, orientation);
        return localMedia;
    }

    /**
     * Convert orientation definition in {@link MediaStore} to definition in {@link ExifInterface}
     *
     * @param orientationInMediaStore orientation definition in {@link MediaStore}
     * @return orientation definition in {@link ExifInterface}
     */
    public static int convertOrientation(int orientationInMediaStore) {
        switch (orientationInMediaStore) {
            case 0:
                return ExifInterface.ORIENTATION_NORMAL;
            case 90:
                return ExifInterface.ORIENTATION_ROTATE_90;
            case 180:
                return ExifInterface.ORIENTATION_ROTATE_180;
            case 270:
                return ExifInterface.ORIENTATION_ROTATE_270;
            default:
                return ExifInterface.ORIENTATION_UNDEFINED;
        }
    }
}
