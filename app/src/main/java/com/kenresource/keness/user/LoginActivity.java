package com.kenresource.keness.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
TextView forgotpassword, signup;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signin = (Button)findViewById(R.id.email_sign_in_button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
        forgotpassword = (TextView)findViewById(R.id.forgot_password);
        SpannableString content = new SpannableString("Forgot Password !!");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        forgotpassword.setText(content);
        signup = (TextView)findViewById(R.id.signup);
        SpannableString content2 = new SpannableString("Not registered yet?? Sign Up now");
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        signup.setText(content2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }
}
