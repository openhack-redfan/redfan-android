package redfen.redfanapp.model_controller;

import redfen.redfanapp.model.Channel;

/**
 * 채널을 관리하는 컨트롤러 객체. 싱글톤으로 제공된다.
 * Created by JoMingyu on 2018-06-30.
 */

public class ChannelController {

    private ChannelController(){}
    private static ChannelController instance;
    public static ChannelController getInstance(){
        if(instance == null) instance = new ChannelController();
        return instance;
    }

    private Channel channel = new Channel(); // 로드된 채널에 대한 정보
    private boolean isLoaded = false; // 채널이 로드 되었는지 알려주는 플래그

    public Channel getChannel() {return channel;}
    public void setChannel(Channel channel) {this.channel = channel;}
    public boolean isLoaded() {return isLoaded;}
    public void setLoaded(boolean loaded) {isLoaded = loaded;}
}
