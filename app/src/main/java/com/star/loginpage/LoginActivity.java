package com.star.loginpage;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etPassword;
    EditText etUserName;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        setListeners();
    }
    void findViews() {
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etUserName = (EditText)findViewById(R.id.etUserName);
        tvRegister = (TextView)findViewById(R.id.tvRegister);
    }
    void  setListeners() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String str =  etUserName.getText().toString();
            String str1 = etPassword.getText().toString();
            if (( !str.equals("") && (!str1.equals("")))) {
                    SharedPreferences settings = getSharedPreferences("create" , 0);
                    String account = settings.getString("account", "");
                    String password = settings.getString("password", "");
                    if ((str.equals(account)) && (str1.equals(password))) {
                        Toast.makeText(LoginActivity.this , "帳號驗證成功" , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this , UserHomePage.class);
                        intent.putExtra("USER_NAME" , etUserName.getText().toString());
                        startActivity(intent);
                        return;
                    }
                    Toast.makeText(LoginActivity.this , "帳號驗證失敗" , Toast.LENGTH_LONG).show();
                    return;
                    }
                    Toast.makeText(LoginActivity.this , "輸入不可空白" , Toast.LENGTH_LONG).show();
            }
         });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(intent);

            }
            });
    }

}