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
    private Bitmap downloadedBitmap;
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

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL thumbUrl = new URL(listviewitem.getThumbnailUrl());
                    HttpsURLConnection conn = (HttpsURLConnection) thumbUrl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                    downloadedBitmap = bitmap;
                    Message changeMsg = changeHandler.obtainMessage();
                    changeHandler.sendMessage(changeMsg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        title.setText(listviewitem.getTitle());

        final int percentage = (int)((100.0*listviewitem.getLike())/(listviewitem.getLike() + listviewitem.getUnlike()));
        percent.setText(percentage+"%");
        final ImageView imgGap = (ImageView) convertView.findViewById(R.id.imgGap);
        ViewTreeObserver vt = progressBar.getViewTreeObserver();
        if(vt.isAlive()){
            vt.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    progressBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int default_gap = imgGap.getLayoutParams().width;
                    int progress_width = progressBar.getWidth();

                    int changed_gap = default_gap + (int)(progress_width*(percentage/100.0));

                    Log.v("width",default_gap+" "+progress_width+" "+changed_gap+" "+percentage);

                    imgGap.getLayoutParams().width = changed_gap;
                    imgGap.setLayoutParams(imgGap.getLayoutParams());

                    progressBar.setProgress(percentage);
                }
            });
        }else{
            Toast.makeText(convertView.getContext(),"Something wrong",Toast.LENGTH_SHORT).show();
        }

        return convertView;
    }

    private Handler changeHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            thumbnail.setImageBitmap(downloadedBitmap);
        }
    };
}
