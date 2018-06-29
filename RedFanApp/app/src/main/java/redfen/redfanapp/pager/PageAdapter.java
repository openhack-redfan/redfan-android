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

    private final int size = 2; // page 의 개수를 수동으로 조정
    private Fragment curFragment = new Fragment();

    private Fragment totalViewFragment1 = new TotalViewFragment().setData("100K views");
    private Fragment totalViewFragment2 = new TotalViewFragment().setData("1000k views");

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                curFragment = totalViewFragment1;
                break;
            case 1:
                curFragment = totalViewFragment2;
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
