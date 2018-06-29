package redfen.redfanapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsengvn.typekit.Typekit;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.w3c.dom.Text;

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
        Intent goToMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(goToMain);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
