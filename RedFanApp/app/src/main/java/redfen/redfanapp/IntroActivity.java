package redfen.redfanapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Intro Activity
 * 처음 실행할 때, 유저들에게 회원가입을 하도록 유도하는 설명서를 표시한다.
 * 아닐 경우 로딩화면만 보여주고 넘어가도록 한다.
 * Created By JoMingyu
 */
public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        },2000);

    }
}
