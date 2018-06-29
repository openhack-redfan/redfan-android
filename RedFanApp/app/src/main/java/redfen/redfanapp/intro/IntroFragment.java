package redfen.redfanapp.intro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import redfen.redfanapp.LoginActivity;
import redfen.redfanapp.MainActivity;
import redfen.redfanapp.R;

/**
 * Created by skrud on 2018-06-29.
 */

public class IntroFragment extends Fragment {
    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String PAGE = "page";

    private int mBackgroundColor, mPage;

    public IntroFragment(){super();}

    public static IntroFragment newInstance(int backgroundColor, int page) {
        IntroFragment frag = new IntroFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, backgroundColor);
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(BACKGROUND_COLOR))
            throw new RuntimeException("Fragment must contain a \"" + BACKGROUND_COLOR + "\" argument!");
        mBackgroundColor = getArguments().getInt(BACKGROUND_COLOR);

        if (!getArguments().containsKey(PAGE))
            throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        mPage = getArguments().getInt(PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Select a layout based on the current page
        int layoutResId;
        layoutResId = R.layout.activity_intro_fragment1;
        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        ImageView mImageView = (ImageView)view.findViewById(R.id.intro_image);
        Button mStartBtn = (Button)view.findViewById(R.id.startBtn);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 2번
                SharedPreferences pref = getActivity().getSharedPreferences("load", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isFirstLaunch", false);
                editor.commit();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        if(mImageView!=null) {
            //여기다 이미지 받아서 set
            switch (mPage) {
                //1p
                case 0:
                    mImageView.setImageDrawable(getResources().getDrawable(R.drawable.intro1));
                    break;
                //2p
                case 1:
                    mImageView.setImageDrawable(getResources().getDrawable(R.drawable.intro2));
                    break;
                //3p
                default:
                    mImageView.setImageDrawable(getResources().getDrawable(R.drawable.intro3));
                    mStartBtn.setVisibility(View.VISIBLE);
                    break;
            }
        }
        // Set the current page index as the View's tag (useful in the PageTransformer)
        view.setTag(mPage);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set the background color of the root view to the color specified in newInstance()
        View background = view.findViewById(R.id.intro_background);
        background.setBackgroundColor(mBackgroundColor);
    }
}
