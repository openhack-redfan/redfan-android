package redfen.redfanapp.detail_comment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Comment;

/**
 * 동영상의 평가가 보여지는 액티비티입니다.
 * 긍정적 또는 부정적인 평가 몇개가 예시로 주어집니다.
 * Created By JoMingyu
 */
public class DetailActivity extends AppCompatActivity {

    private ListView goodCommentListview;
    private ListView badCommentListview;
    private CommentListAdapter commentListAdapter;
    private ArrayList<Comment> commentsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    public void init(){
        goodCommentListview = (ListView)findViewById(R.id.goodcommentlist);
        badCommentListview = (ListView)findViewById(R.id.badcommentlist);


    }

    public void onBackClick(View view) {
        this.finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
