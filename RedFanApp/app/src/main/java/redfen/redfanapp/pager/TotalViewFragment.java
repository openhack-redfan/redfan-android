package redfen.redfanapp.pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import redfen.redfanapp.R;

/**
 * Created by start on 2018-06-29.
 */

public class TotalViewFragment extends Fragment {

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
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_total_view, container, false);
        textView = (TextView) relativeLayout.findViewById(R.id.txtTotal);
        textView.setText(data);
        return relativeLayout;
    }
}
