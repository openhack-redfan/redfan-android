package redfen.redfanapp.model_controller;

import redfen.redfanapp.model.Channel;

/**
 * Created by JoMingyu on 2018-06-30.
 */

public class ChannelController {

    private ChannelController(){}
    private static ChannelController instance;
    public static ChannelController getInstance(){
        if(instance == null) instance = new ChannelController();
        return instance;
    }

    private Channel channel;
    public Channel getChannel() {return channel;}
    public void setChannel(Channel channel) {this.channel = channel;}
}
