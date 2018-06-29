package redfen.redfanapp.intro;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import redfen.redfanapp.R;

/**
 * Intro Activity
 * 처음 실행할 때, 유저들에게 회원가입을 하도록 유도하는 설명서를 표시한다.
 * 아닐 경우 로딩화면만 보여주고 넘어가도록 한다.
 * Created By JoMingyu
 */
public class IntroActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);

        mViewPager.setAdapter(new IntoAdapter(getSupportFragmentManager()));

        mViewPager.setPageTransformer(false, new IntroTransformer());
    }
}
