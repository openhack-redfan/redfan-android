package redfen.redfanapp.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by start on 2018-06-29.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private final int size = 1; // page 의 개수를 수동으로 조정
    private Fragment curFragment = new Fragment();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                curFragment = new TotalViewFragment();
                break;
            default:
                return null;
        }
        return curFragment;
    }

    @Override
    public int getCount() {
        return size;
    }
}
