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

/**
 * 회원가입을 위한 액티비티 입니다.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputPasswordCheck;
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
        String channelurl = inputURL.getText().toString();

        if(!password.equals(passwordcheck)){
            Toast.makeText(this,"Your password is not correct",Toast.LENGTH_SHORT).show();
            return;
        }



        this.finish();
    }

    public void onLoginClick(View view){
        this.finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
