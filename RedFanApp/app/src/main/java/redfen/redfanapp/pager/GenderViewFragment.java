package redfen.redfanapp.pager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Channel;

/**
 * Created by skrud on 2018-06-30.
 */

public class GenderViewFragment extends Fragment implements IUseChannelData{

    public GenderViewFragment(){super();}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_total_view2,null);

        return v;
    }

    @Override
    public void refreshChannelData(Channel channel) {

    }
}
