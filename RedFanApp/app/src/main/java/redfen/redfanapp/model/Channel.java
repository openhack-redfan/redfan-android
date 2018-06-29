package redfen.redfanapp.model;

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

    private String channelId;
    private String channelName;
    private int channelThumb;
    private String channelUrl;
    private String channelDetail;
    private int numOfSubscriber;
    private int numOfLover;
    private int numOfView;
    private int numOfVideo;
    private String datePublished;
    private String dateCrawled;

    public String getChannelId() {return channelId;}
    public void setChannelId(String channelId) {this.channelId = channelId;}
    public String getChannelName() {return channelName;}
    public void setChannelName(String channelName) {this.channelName = channelName;}
    public int getChannelThumb() {return channelThumb;}
    public void setChannelThumb(int channelThumb) {this.channelThumb = channelThumb;}
    public String getChannelUrl() {return channelUrl;}
    public void setChannelUrl(String channelUrl) {this.channelUrl = channelUrl;}
    public String getChannelDetail() {return channelDetail;}
    public void setChannelDetail(String channelDetail) {this.channelDetail = channelDetail;}
    public int getNumOfSubscriber() {return numOfSubscriber;}
    public void setNumOfSubscriber(int numOfSubscriber) {this.numOfSubscriber = numOfSubscriber;}
    public int getNumOfLover() {return numOfLover;}
    public void setNumOfLover(int numOfLover) {this.numOfLover = numOfLover;}
    public int getNumOfView() {return numOfView;}
    public void setNumOfView(int numOfView) {this.numOfView = numOfView;}
    public int getNumOfVideo() {return numOfVideo;}
    public void setNumOfVideo(int numOfVideo) {this.numOfVideo = numOfVideo;}
    public String getDatePublished() {return datePublished;}
    public void setDatePublished(String datePublished) {this.datePublished = datePublished;}
    public String getDateCrawled() {return dateCrawled;}
    public void setDateCrawled(String dateCrawled) {this.dateCrawled = dateCrawled;}
}
