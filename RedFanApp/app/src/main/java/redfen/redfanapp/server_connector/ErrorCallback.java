package redfen.redfanapp.server_connector;

/**
 * 에러가 발생했을 경우 콜백되는 함수입니다.
 * Created by JoMingyu on 2018-06-30.
 */

public interface ErrorCallback {

    public void errCallback(int resultCode);

}
