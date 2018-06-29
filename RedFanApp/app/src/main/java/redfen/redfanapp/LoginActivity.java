package redfen.redfanapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

/**
 * 로그인/ 회원가입하는 엑티비티입니다.
 * Created By JoMingyu
 */
public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

    }

    public void  onLoginClick(View view){
        Intent goToMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(goToMain);
    }

}
