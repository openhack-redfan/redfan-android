package redfen.redfanapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * 채널에 대한 데이터를 가지고 있는 객체입니다.
 * @member
 * private String channelId; 데이터베이스 상에서 존재하는 키
 * private String channelName; 채널 이름
 * private int channelThumb; 채널의 섬네일 주소
 * private String channelUrl; 채널의 주소
 * private String channelDetail; 채널의 상세 설명
 * private int numOfSubscriber; 채널의 구독자 수
 * private int numOfLover; 채널의 애독자 수
 * private int numOfView; 채널의 총 동영상의 조회수 합
 * private int numOfVideo; 채널의 총 동영상 수
 * private String datePublished; 채널이 언제 만들어 졌는지
 * private String dateCrawled; 채널에 대한 데이터가 언제 수집되었는지
 * Created by JoMingyu on 2018-06-30.
 */

public class Channel {


    public String channelId;
    public String channelName;
    public int channelThumbs;
    public String channelUrl;
    public String channelDetail;
    @SerializedName("channelSubscriberCount")
    public int numOfSubscriber;
    public int numOfLover;
    @SerializedName("channelViewCount")
    public int numOfView;
    @SerializedName("channelVideoCount")
    public int numOfVideo;
    @SerializedName("channelPublishedAt")
    public String datePublished;
    @SerializedName("channelCrawledAt")
    public String dateCrawled;

}
