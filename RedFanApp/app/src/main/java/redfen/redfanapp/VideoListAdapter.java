package redfen.redfanapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * 비디오의 리스트를 관리하는 어뎁터 클래스
 * Created by JoMingyu on 2018-06-29.
 * 참조한 코드:
 * https://github.com/songmho/Listview_with_image
 */

public class VideoListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<VideoItem> itemList;
    private int layout;
    private ImageView thumbnail;
    public VideoListAdapter(Context context, int layout, ArrayList<VideoItem> itemList){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemList = itemList;
        this.layout = layout;
    }

    public void setItemList(ArrayList<VideoItem> itemList){
        this.itemList = itemList;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        final VideoItem listviewitem = itemList.get(position);

        thumbnail = (ImageView) convertView.findViewById(R.id.imgThumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.txtVideoTitle);
        TextView percent = (TextView) convertView.findViewById(R.id.txtPercent);
        final ProgressBar progressBar = ((ProgressBar) convertView.findViewById(R.id.barPercent));

        if (!listviewitem.isStartDownload()){
            listviewitem.setStartDownload(true);
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        VideoItem downloadingItem = listviewitem;
                        URL thumbUrl = new URL(downloadingItem.getThumbnailUrl());
                        HttpsURLConnection conn = (HttpsURLConnection) thumbUrl.openConnection();
                        conn.setDoInput(true);
                        conn.connect();

                        InputStream is = conn.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        is.close();

                        downloadingItem.setDownloadBitmap(bitmap);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        title.setText(listviewitem.getTitle());

        final int percentage = (int)((100.0*listviewitem.getLike())/(listviewitem.getLike() + listviewitem.getUnlike()));
        percent.setText(percentage+"%");
        final ImageView imgGap = (ImageView) convertView.findViewById(R.id.imgGap);
        progressBar.setProgress(percentage);

//        ViewTreeObserver vt = progressBar.getViewTreeObserver();
//        if(vt.isAlive()){
//            vt.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                @Override
//                public void onGlobalLayout() {
//                    int default_gap = imgGap.getLayoutParams().width;
//                    int progress_width = progressBar.getWidth();
//
//                    int changed_gap = default_gap + (int)(progress_width*(percentage/100.0));
//
//                    Log.v("width",default_gap+" "+progress_width+" "+changed_gap+" "+percentage);
//
//                    imgGap.getLayoutParams().width = changed_gap;
//                    imgGap.setLayoutParams(imgGap.getLayoutParams());
//                    progressBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//
//                }
//            });
//        }else{
//            Toast.makeText(convertView.getContext(),"Something wrong",Toast.LENGTH_SHORT).show();
//        }

        // 썸네일 그리기
        if (listviewitem.isStartDownload() && listviewitem.getDownloadBitmap() != null){ // 다운로드를 시작했으며, 다운로드 받은 비트맵이  널이  아닐경우.
            thumbnail.setImageBitmap(listviewitem.getDownloadBitmap());
        }

        return convertView;
    }
}
