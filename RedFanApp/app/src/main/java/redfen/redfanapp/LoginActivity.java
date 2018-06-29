package redfen.redfanapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsengvn.typekit.Typekit;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import redfen.redfanapp.intro.IntroFragment;

/**
 * 로그인/ 회원가입하는 엑티비티입니다.
 * Created By JoMingyu
 */
public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private TextView registerClickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        registerClickBtn = (TextView) findViewById(R.id.onLoginRegisterClick);
        registerClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegi = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegi);
            }
        });

    }

    public void  onLoginClick(View view){

        final String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        ServerConnector connector = ServerConnector.getInstatnce();
        JSONObject loginData = new JSONObject();
        try {
            loginData.put("userId", email);
            loginData.put("userPw", password);
            System.out.println(loginData.toString());
            connector.requestPost("http://13.209.8.64:24680/sign_in", loginData.toString(), new RequestCallback() {
                @Override
                public void requestCallback(String result) {
                    System.out.println(result);
                    try {
                        JSONObject res = new JSONObject(result);
                        if (res.get("result").equals("true")){
                            Account.getInstance().setEmail(email);
                            Account.getInstance().setAuthorized(true);
                            Intent goToMain = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(goToMain);
                            Message successMessage = successHandler.obtainMessage();
                            successHandler.sendMessage(successMessage);
                        }
                        else {
                            Message fail = failHandler.obtainMessage();
                            failHandler.sendMessage(fail);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // 스레드에서는 토스트와 같은 UI를 띄우는 것이 불가능하기 때문에
    // 핸들러를 만들어 해결 토스트를 띄운다.
    // 참조 : https://www.androidpub.com/861367
    final AppCompatActivity mother = this;
    private Handler successHandler = new Handler() {
        public void handleMessage(Message msg){
            Toast.makeText(mother, "login success!", Toast.LENGTH_SHORT).show();
        }
    };

    private Handler failHandler = new Handler() {
        public void handleMessage(Message msg){
            Toast.makeText(mother, "login fail!", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
