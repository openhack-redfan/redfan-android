package redfen.redfanapp;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.tsengvn.typekit.Typekit;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import redfen.redfanapp.pager.PageAdapter;
import redfen.redfanapp.pager.TotalViewFragment;

/**
 * 유투브 크리에이터의 전반적인 채널 상황이 나타나는 액티비티입니다.
 * 첫번째 칸은 채널의 전반적인 상황,
 * 그 이후의 칸은 동영상의 평가가 보여집니다.
 * Created By JoMingyu
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ListView listView;


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
        /*ArrayList<VideoItem> list = new ArrayList<>();
        list.add(new VideoItem("null", "hi", 10, 10));
        VideoListAdapter adapter = new VideoListAdapter(this, R.layout.listitem_video, list);
        listView.setAdapter(adapter);*/
        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("userId", Account.getInstance().getEmail());
            ServerConnector.getInstatnce().requestPost("http://13.209.8.64:24681/channel_info", mainObj.toString(), new RequestCallback() {
                @Override
                public void requestCallback(String result) {
                    System.out.println("channel info::");
                    System.out.println(result);
                }
            });
        } catch (JSONException e) {
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
