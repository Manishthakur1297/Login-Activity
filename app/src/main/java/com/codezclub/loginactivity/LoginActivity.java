package com.codezclub.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText et_username,et_password;
    Button btn_login;
    String susername,spassword;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref = new SharedPref(getApplicationContext());

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                susername = et_username.getText().toString();
                spassword = et_password.getText().toString();

                if(susername.equals("mj") && spassword.equals("12345"))
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);

                    //-----------Don't want to go back to login form------------
                    finish();

                    sharedPref.createLogin();
                }
            }
        });

    }
}
