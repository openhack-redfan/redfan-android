package redfen.redfanapp;

import android.graphics.Bitmap;

/**
 * 비디오 리스트의 아이템의 정보를 저장하고 있는 객체입니다.
 * Created by JoMingyu on 2018-06-29.
 */

public class VideoItem {

    private String title;
    private String thumbnailUrl;

    private int like;
    private int unlike;

    // 썸네일 다운로드를 위한
    private Bitmap downloadBitmap = null; // 다운로드 된 비트맵
    private boolean isStartDownload = false; // 다운로드 시작되었는지 플래그

    public VideoItem(String title, String thumbnailUrl, int like, int unlike){
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.like = like;
        this.unlike = unlike;
    }

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}
    public String getThumbnailUrl(){return this.thumbnailUrl;}
    public void setThumbnailUrl(String thumbnailUrl){this.thumbnailUrl = thumbnailUrl;}
    public int getLike(){return this.like;}
    public void setLike(int like){this.like = like;}
    public int getUnlike(){return this.unlike;}
    public void setUnlike(int unlike){this.unlike = unlike;}


    public Bitmap getDownloadBitmap() {
        return downloadBitmap;
    }

    public void setDownloadBitmap(Bitmap downloadBitmap) {
        this.downloadBitmap = downloadBitmap;
    }

    public boolean isStartDownload() {
        return isStartDownload;
    }

    public void setStartDownload(boolean startDownload) {
        isStartDownload = startDownload;
    }
}
