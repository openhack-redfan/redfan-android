package redfen.redfanapp.model_controller;

import java.util.ArrayList;

import redfen.redfanapp.model.Video;

/**
 * 비디오들에 대한 정보를 가지고 있는 컨트롤러 객체입니다.
 * 싱글톤으로 제공됩니다.
 * Created by JoMingyu on 2018-06-30.
 */

public class VideoController {

    private VideoController(){}
    private static VideoController instance;
    public static VideoController getInstance(){
        if (instance == null) instance = new VideoController();
        return instance;
    }

    private ArrayList<Video> videos = new ArrayList<>();
    public ArrayList<Video> getVideos() {return videos;}
    public void setVideos(ArrayList<Video> videos) {this.videos = videos;}
    public void addVideo(Video video){videos.add(video);}
    public Video getVideo(int index){
        if (0 <= index && index < videos.size()) return videos.get(index);
        else return null;
    }
}
