package redfen.redfanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

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
    public VideoListAdapter(Context context, int layout, ArrayList<VideoItem> itemList){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemList = itemList;
        this.layout = layout;
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
        return null;
    }
}
