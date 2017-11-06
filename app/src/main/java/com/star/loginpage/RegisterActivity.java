package com.star.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText etAge;
    EditText etEmail;
    EditText etPassword;
    EditText etUserName;
    String TAG = "RA OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        setOnListener();
    }
    private void findViews() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etAge = (EditText) findViewById(R.id.etAge);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
    private void setOnListener() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String account = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                String age = etAge.getText().toString();
                if ( (!email.equals("")) && (!account.equals("")) && (!password.equals("")) && (!age.equals(""))) {
                    SharedPreferences settings = getSharedPreferences("create" , 0);
                    settings.edit().putString("email" , etEmail.getText().toString()).commit();
                    settings.edit().putString("account" , etUserName.getText().toString()).commit();
                    settings.edit().putString("password" , etPassword.getText().toString()).commit();
                    settings.edit().putString("age" , etAge.getText().toString()).commit();

                    Toast.makeText(RegisterActivity.this , "註冊成功" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this , UserHomePage.class);
                    intent.putExtra("USER_NAME" , etUserName.getText().toString());
                    startActivity(intent);
                    return;
                }
                Toast.makeText(RegisterActivity.this , "欄位不可空白" , Toast.LENGTH_LONG).show();

            }

        });
        Log.d(TAG , "setOnListener = OK");
    }
}
