package redfen.redfanapp.detail_comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Comment;
import redfen.redfanapp.pager.PageAdapter;

/**
 * Created by skrud on 2018-06-30.
 */

public class CommentListAdapter extends ArrayAdapter<Comment> {

    private static Context mContext;
    private ArrayList<Comment> mData;

    public CommentListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Comment> objects) {
        super(context, resource, objects);
        mContext = context;
        mData = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.comment_row,null);
        }
        Comment comment = mData.get(position);
        TextView comment_text = (TextView)v.findViewById(R.id.comment_text);
        if(comment_text!=null){
            comment_text.setText(comment.commentText);
        }
        return v;
    }
}
