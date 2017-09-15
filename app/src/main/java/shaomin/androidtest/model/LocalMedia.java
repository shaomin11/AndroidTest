package shaomin.androidtest.model;

/**
 * Created by wangshaomin on 15/09/2017.
 */

public class LocalMedia {
    public long localId;
    public String localPath;

    public long generatedAt;    //ms. =1.takenAt 2.createdAt, 相册中排序依据
    public long createdAt;      //ms. =DATE_ADDED, 查询本地排序依据
    public final long fileSize;
    // exif信息
    public long takenAt;        //ms. =DATE_TAKEN = TAG_DATETIME
    public final double latitude;
    public final double longitude;
    public final long duration;

    protected final byte format;
    public int width;
    public int height;
    public int orientation;


    public LocalMedia(final long localId, final String localPath, final long generatedAt,
                      final long createdAt, final byte format, final long fileSize,
                      final long takenAt, final double latitude, final double longitude,
                      final long duration, final int width, final int height, final int orientation) {
        this.localId = localId;
        this.localPath = localPath;
        this.generatedAt = generatedAt;

        this.format = format;
        this.fileSize = fileSize;
        this.createdAt = createdAt;

        this.takenAt = takenAt;
        this.latitude = latitude;
        this.longitude = longitude;
        this.duration = duration;
        this.width = width;
        this.height = height;
        this.orientation = orientation;
    }

}
