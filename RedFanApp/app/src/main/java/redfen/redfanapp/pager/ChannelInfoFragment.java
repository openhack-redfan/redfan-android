package redfen.redfanapp.pager;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import redfen.redfanapp.R;
import redfen.redfanapp.VideoItem;
import redfen.redfanapp.model.Channel;

/**
 * Created by skrud on 2018-06-30.
 */

public class ChannelInfoFragment extends Fragment implements IUseChannelData{

    private TextView txtCralwedDate;
    private ImageView imgThumbnail;
    private TextView txtChannelName;
    private TextView txtChannelDesc;
    private TextView txtOpenedDate;
    private TextView txtNumSubscriber;
    private TextView txtNumVideo;

    private Bitmap downloadedBitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_total_view4,null);

        txtCralwedDate = (TextView) v.findViewById(R.id.update);
        imgThumbnail = (ImageView) v.findViewById(R.id.channel_thumnail);
        txtChannelName = (TextView) v.findViewById(R.id.channel_name);
        txtChannelDesc = (TextView) v.findViewById(R.id.channel_description);
        txtOpenedDate = (TextView) v.findViewById(R.id.channel_opened);
        txtNumSubscriber = (TextView) v.findViewById(R.id.channel_sub);
        txtNumVideo = (TextView) v.findViewById(R.id.channel_videonum);

        return v;
    }

    @Override
    public void refreshChannelData(final Channel channel) {
        txtCralwedDate.setText(channel.dateCrawled.substring(0, 10));
        txtChannelName.setText(channel.channelName);
        txtChannelDesc.setText(channel.channelDetail);
        txtOpenedDate.setText(channel.datePublished.substring(0, 10));
        txtNumSubscriber.setText(Integer.toString(channel.numOfSubscriber));
        txtNumVideo.setText(Integer.toString(channel.numOfVideo));

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                HttpsURLConnection conn = null;
                try {
                    // 썸네일 다운로드
                    URL thumbUrl = new URL(channel.channelThumbs);
                    conn = (HttpsURLConnection) thumbUrl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    downloadedBitmap = BitmapFactory.decodeStream(is);
                    is.close();

                    // 이미지를 바꾸기 위한 핸들러
                    Message msg = changeImgHandler.obtainMessage();
                    changeImgHandler.sendMessage(msg);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    conn.disconnect();
                }
            }
        });

    }

    private Handler changeImgHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            imgThumbnail.setImageBitmap(downloadedBitmap);
        }
    };


}
