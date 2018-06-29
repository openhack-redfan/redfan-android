package redfen.redfanapp.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tsengvn.typekit.TypekitContextWrapper;

import redfen.redfanapp.model.Channel;

/**
 * 메인 뷰에 있는 페이지 슬라이더를 위한 어뎁터입니다.
 * Created by JoMingyu on 2018-06-29.
 * 참고: https://github.com/songmho/ViewPager
 */

public class PageAdapter extends FragmentPagerAdapter {

    private Channel mChannel;
    private final int size = 4; // page 의 개수를 수동으로 조정
    private Fragment curFragment = new Fragment();

    //슬라이드1. 채널의 기본정보를 보여줍니다.
    //채널이름, 채널썸네일주소, 구독자수, 비디오수, 채널개설일
    private Fragment channelinfoFragment1 = new ChannelInfoFragment();
    //슬라이드2. 채널의 총 뷰 수를 보여줍니다.
    //채널 총 뷰
    private Fragment totalViewFragment2 = new TotalViewFragment().setData("100K views");
    //슬라이드3. 채널 구독자의 성비를 보여줍니다.
    //구독자의 성비, 구독자의 연령대
    private Fragment genderViewFragment3 = new GenderViewFragment();
    //슬라이드4. 채널의 애독자 수를 보여줍니다.
    //채널 애독자 수
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

    public void sendChannelInfo(Channel channel){
        mChannel = channel;
    }

}
