package redfen.redfanapp.model;

/**
 * 앱 내에서의 계정정보를 가지고 있는 객체
 * 쉽게 사용 가능하게 싱글톤으로 제공된다.
 * Created by JoMingyu on 2018-06-29.
 */

public class Account {

    private Account(){}
    private static Account instance = null;
    public static Account getInstance(){
        if (instance == null) instance = new Account();
        return instance;
    }

    private String email = null;
    private boolean isAuthorized = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}
