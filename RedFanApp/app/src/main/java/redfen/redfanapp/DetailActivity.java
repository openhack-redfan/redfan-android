package redfen.redfanapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * 동영상의 평가가 보여지는 액티비티입니다.
 * 긍정적 또는 부정적인 평가 몇개가 예시로 주어집니다.
 * Created By JoMingyu
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    public void onBackClick(View view) {
        this.finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
