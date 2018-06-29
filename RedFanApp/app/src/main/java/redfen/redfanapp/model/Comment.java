package redfen.redfanapp.model;

/**
 * 댓글 정보를 가지고 있는 객체입니다.
 * 리스트가 선택된 비디오에 따라 계속 바뀌므로 컨트롤러는 싱글톤으로 설계하지 않았습니다.
 * Created by JoMingyu on 2018-06-30.
 */

public class Comment {

    public String commentAuthorName;
    public String commentAuthorThumbs;
    public String commentCrawledAt;
    public String commentId;
    public int commentLikeCount;
    public String commentPublishedAt;
    public String commentText;
    public String videoId;

}
