package redfen.redfanapp.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * 메인 뷰에 있는 페이지 슬라이더를 위한 어뎁터입니다.
 * Created by JoMingyu on 2018-06-29.
 * 참고: https://github.com/songmho/ViewPager
 */

public class PageAdapter extends FragmentPagerAdapter {

    private final int size = 4; // page 의 개수를 수동으로 조정
    private Fragment curFragment = new Fragment();

    private Fragment channelinfoFragment1 = new ChannelInfoFragment();
    private Fragment totalViewFragment2 = new TotalViewFragment().setData("100K views");
    private Fragment genderViewFragment3 = new GenderViewFragment();
    private Fragment fanViewFragment4 = new FanViewFragment();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                curFragment = channelinfoFragment1;
                break;
            case 1:
                curFragment = totalViewFragment2;
                break;
            case 2:
                curFragment = genderViewFragment3;
                break;
            case 3:
                curFragment = fanViewFragment4;
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
