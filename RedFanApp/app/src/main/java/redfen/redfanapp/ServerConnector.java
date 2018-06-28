package redfen.redfanapp;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 서버와 통신하는 클래스. 싱글톤 패턴으로 객체를 제공한다.
 * Created by JoMingyu on 2018-06-28.
 */

public class ServerConnector {

    // 싱글톤 패턴
    private ServerConnector() {};
    private static ServerConnector instatnce = null;
    public static ServerConnector getInstatnce(){
        if (instatnce == null) instatnce = new ServerConnector();
        return instatnce;
    }

    /**
     * Url 주소와 RequestCallback 인터페이스를 구현하여 전달하면,
     * 해당 주소에서 Response를 받아와 RequestCallback의 requestCallback 메소드의
     * result 로 전달한다.
     * @param url 요청할 페이지의 url 주소
     * @param callback Response 정보로 콜백을 준다.
     */
    public void requestGet(final String url, final RequestCallback callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                URL endpoint = null;
                try {
                    endpoint = new URL(url);
                    HttpsURLConnection conn = (HttpsURLConnection) endpoint.openConnection();
                    if (conn.getResponseCode() == 200){ // 네트워크 연결에 성공했을 경우

                        // 인풋 가져옴
                        InputStream is = conn.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        StringBuilder sbr = new StringBuilder(); // 읽어온 스트링 저장하는 스트링빌더
                        String line = null; // 한줄씩 들어가는 임시 보관소
                        while ((line = br.readLine()) != null){
                            sbr.append(line);
                        }

                        br.close();
                        is.close();

                        // callback 함수 호출
                        callback.requestCallback(sbr.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }


}