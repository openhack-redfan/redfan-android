package redfen.redfanapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.tsengvn.typekit.Typekit;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redfen.redfanapp.model.Account;
import redfen.redfanapp.model.Channel;
import redfen.redfanapp.model.Video;
import redfen.redfanapp.model_controller.ChannelController;
import redfen.redfanapp.model_controller.VideoController;
import redfen.redfanapp.pager.PageAdapter;
import redfen.redfanapp.pager.TotalViewFragment;
import redfen.redfanapp.server_connector.RequestCallback;
import redfen.redfanapp.server_connector.ServerConnector;

/**
 * 유투브 크리에이터의 전반적인 채널 상황이 나타나는 액티비티입니다.
 * 첫번째 칸은 채널의 전반적인 상황,
 * 그 이후의 칸은 동영상의 평가가 보여집니다.
 * Created By JoMingyu
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ListView listView;
    private VideoListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Account.getInstance().isAuthorized()){
            Toast.makeText(this, "보안 상에 문제가 생겼습니다. 다시 로그인 해주세요.", Toast.LENGTH_SHORT).show();
            this.finish();
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        listView = (ListView) findViewById(R.id.videoListView);
        ArrayList<VideoItem> list = new ArrayList<>();
        list.add(new VideoItem("null", "hi", 10, 10));
        adapter = new VideoListAdapter(this, R.layout.listitem_video, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent goToDetailComment = new Intent(getApplicationContext(),DetailActivity.class);
                //해당 위치의 객체정보를 넘긴다.
                startActivity(goToDetailComment);
            }
        });


        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("userId", Account.getInstance().getEmail());
            System.out.println(mainObj.toString());
            ServerConnector.getInstatnce().requestPost("http://13.209.8.64:24680/channels_info", mainObj.toString(), new RequestCallback() {
                @Override
                public void requestCallback(String result) {
                    System.out.println("channel info::");
                    System.out.println(result);

                    try {
                        JSONObject resultObj = new JSONObject(result);

                        // 채널 파싱
                        Channel newChannel = new Gson().fromJson(resultObj.get("channel").toString(), Channel.class);
                        ChannelController.getInstance().setChannel(newChannel);
                        ChannelController.getInstance().setLoaded(true);

                        // 비디오 파싱
                        JSONArray objArray = resultObj.getJSONArray("videos");
                        ArrayList<Video> videos = new ArrayList<>(); // 컨트롤러를 위한
                        ArrayList<VideoItem> videoItems = new ArrayList<>(); // 리스트뷰를 위한
                        for (int i = 0; i < resultObj.length(); i++){
                            // 비디오 추가
                            Video video = new  Gson().fromJson(objArray.get(i).toString(), Video.class);
                            VideoController.getInstance().addVideo(video);
                            videos.add(video);
                            // 비디오 아이템 추가
                            VideoItem videoItem = new VideoItem(video.videoTitle, video.videoThumbs, video.videoLikeCount, video.videoDislikeCount);
                            videoItems.add(videoItem);
                        }

                        // 컨트롤러에 비디오들 추가
                        VideoController.getInstance().setVideos(videos);
                        // 리스트뷰에 비디오 추가
                        adapter.setItemList(videoItems);
                        listView.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Some Error Occurs. sign in again plz", Toast.LENGTH_SHORT).show();
            this.finish();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Some Error Occurs. sign in again plz", Toast.LENGTH_SHORT).show();
            this.finish();
        }


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

}
