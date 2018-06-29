package redfen.redfanapp.pager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.concurrent.TimeoutException;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Channel;

/**
 * Created by start on 2018-06-29.
 */

public class TotalViewFragment extends Fragment implements IUseChannelData{

    public TotalViewFragment(){
        super();
    }

    TextView textView;
    String data = "text";
    public TotalViewFragment setData(String data){
        this.data = data;
        return this;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_total_view,null);

        return v;
    }


    @Override
    public void refreshChannelData(Channel channel) {

    }
}
