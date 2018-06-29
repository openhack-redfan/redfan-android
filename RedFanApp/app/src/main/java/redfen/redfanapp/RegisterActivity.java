package redfen.redfanapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 회원가입을 위한 액티비티 입니다.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputPasswordCheck;
    private EditText inputName;
    private EditText inputURL;
    private TextView btnLogin;

    private ServerConnector mServerConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mServerConnector = ServerConnector.getInstatnce();
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        inputPasswordCheck = (EditText) findViewById(R.id.inputPasswordCheck);
        inputName = (EditText)findViewById(R.id.inputName);
        inputURL = (EditText)findViewById(R.id.inputURL);

        btnLogin = (TextView) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick(v);
            }
        });
    }

    public void onRegisterClick(View view){

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String passwordcheck = inputPasswordCheck.getText().toString();
        String name = inputName.getText().toString();
        String channelurl = inputURL.getText().toString();

        if (email == null ||email.length() < 4){
            Toast.makeText(this,"Your email is too short. (more than 4)",Toast.LENGTH_SHORT).show();
            return;
        }

        if (password == null ||password.length() < 4){
            Toast.makeText(this,"Your password is too short. (more than 4)",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(passwordcheck)){
            Toast.makeText(this,"Your password is not correct",Toast.LENGTH_SHORT).show();
            return;
        }

        if (name == null || name .length()< 2){
            Toast.makeText(this,"Your name is too short. (more than 2)",Toast.LENGTH_SHORT).show();
            return;
        }

        if (channelurl == null || channelurl .length()< 4){
            Toast.makeText(this,"Your url is too short. (more than 4)",Toast.LENGTH_SHORT).show();
            return;
        }

        ServerConnector connector = ServerConnector.getInstatnce();
        JSONObject loginData = new JSONObject();
        try {
            loginData.put("userId", email);
            loginData.put("userPw", password);
            loginData.put("userName", name);
            loginData.put("channelUrl", channelurl);
            System.out.println(loginData.toString());
            final AppCompatActivity mother = this;
            connector.requestPost("http://13.209.8.64:24680/sign_up", loginData.toString(), new RequestCallback() {
                @Override
                public void requestCallback(String result) {
                    System.out.println(result);
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        if (jsonObject.get("result").equals("true")){
                            Toast.makeText(mother,"register success!",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(mother,"register fail!",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onLoginClick(View view){
        this.finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
