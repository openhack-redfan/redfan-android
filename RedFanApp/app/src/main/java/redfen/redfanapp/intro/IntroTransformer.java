package redfen.redfanapp.intro;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by skrud on 2018-06-29.
 */

public class IntroTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag();
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {

        } else if (position == 0.0f) {

        } else {

        }
    }
}
