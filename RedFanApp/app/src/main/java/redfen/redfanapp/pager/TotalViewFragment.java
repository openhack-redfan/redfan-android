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

    private TextView txtTotalView;

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

        txtTotalView = (TextView) v.findViewById(R.id.total_view);

        return v;
    }


    @Override
    public void refreshChannelData(Channel channel) {
        int numOfView = channel.numOfView;
        int M = numOfView / 1000000;
        int K = numOfView / 1000;
        if (M > 0) txtTotalView.setText(M+"M");
        else if (K > 0) txtTotalView.setText(K+"K");
        else txtTotalView.setText(numOfView);
    }
}
