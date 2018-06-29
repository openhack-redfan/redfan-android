package redfen.redfanapp.intro;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by skrud on 2018-06-29.
 */

public class IntoAdapter extends FragmentPagerAdapter {

    public IntoAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return IntroFragment.newInstance(Color.parseColor("#111111"),position);
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#03A9F4"),position);
            default:
                return IntroFragment.newInstance(Color.parseColor("#4CAF50"),position);
        }
    }
    @Override
    public int getCount() {
        return 4;
    }
}
