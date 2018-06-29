package redfen.redfanapp;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

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


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        listView = (ListView) findViewById(R.id.videoListView);
        ArrayList<VideoItem> list = new ArrayList<>();
        list.add(new VideoItem());
        VideoListAdapter adapter = new VideoListAdapter(this, R.layout.listitem_video, list);
        listView.setAdapter(adapter);

    }
}
