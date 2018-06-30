package redfen.redfanapp.detail_comment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import redfen.redfanapp.R;
import redfen.redfanapp.model.Comment;
import redfen.redfanapp.server_connector.ErrorCallback;
import redfen.redfanapp.server_connector.RequestCallback;
import redfen.redfanapp.server_connector.ServerConnector;

/**
 * 동영상의 평가가 보여지는 액티비티입니다.
 * 긍정적 또는 부정적인 평가 몇개가 예시로 주어집니다.
 * Created By JoMingyu
 */
public class DetailActivity extends AppCompatActivity {

    private ListView goodCommentListview;
    private ListView badCommentListview;
    private CommentListAdapter commentListAdapter;
    public static final int MAX_COMMENTS = 20;
    private ArrayList<Comment> goodCommentsArray;
    private ArrayList<Comment> badCommentsArray;

    private String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoId = this.getIntent().getStringExtra("videoId");
        setContentView(R.layout.activity_detail);
        init();

        try {
            JSONObject reqObj = new JSONObject();
            //reqObj.put("videoId", videoId);
            reqObj.put("userId", "asdf@asdf.com");
            reqObj.put("userPw", "asdf");
            ServerConnector.getInstatnce().requestPost("http://13.209.8.64:24680/sign_up", reqObj.toString(), new RequestCallback() {
                @Override
                public void requestCallback(String result) {
                    System.out.println(result);

                    // ▽다운로드▽
                    try {
                        JSONObject resObj = new JSONObject(result);
                        JSONArray  commentArr = resObj.getJSONArray("commentResults");
                        for (int index = 0; index < commentArr.length(); index++){
                            JSONObject commentObj = commentArr.getJSONObject(index);
                            Comment comment = new Gson().fromJson(commentObj.toString(), Comment.class);
                            if (comment.equals("positive")){ // positive 인 경우
                                if (goodCommentsArray.size() < MAX_COMMENTS){
                                    goodCommentsArray.add(comment);
                                }
                            }
                            else if (comment.equals("negative")){ // negative 인 경우
                                if (badCommentsArray.size() < MAX_COMMENTS){
                                    badCommentsArray.add(comment);
                                }
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // ▽다운로드 완료 후 디자인▽

                }
            }, new ErrorCallback() {
                @Override
                public void errCallback(int resultCode) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void init(){
        goodCommentListview = (ListView)findViewById(R.id.goodcommentlist);
        badCommentListview = (ListView)findViewById(R.id.badcommentlist);

        goodCommentsArray = new ArrayList<>();
        badCommentsArray = new ArrayList<>();

    }

    public void onBackClick(View view) {
        this.finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
