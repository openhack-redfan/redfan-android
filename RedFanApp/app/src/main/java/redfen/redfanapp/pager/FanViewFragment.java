package redfen.redfanapp.pager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Channel;
import redfen.redfanapp.model_controller.ChannelController;

/**
 * Created by skrud on 2018-06-30.
 */

public class FanViewFragment extends Fragment implements IUseChannelData{

    private TextView txtFanNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_total_view3,null);

        txtFanNum = (TextView) v.findViewById(R.id.fannum_view);
        refreshChannelData(ChannelController.getInstance().getChannel());

        return v;
    }

    @Override
    public void refreshChannelData(Channel channel) {
        int lover = channel.numOfLover;
        if (txtFanNum != null) txtFanNum.setText(Integer.toString(lover));
    }
}
