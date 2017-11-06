package com.star.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserHomePage extends AppCompatActivity {


    TextView tvWelcome ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        findViews();
        welcome();
    }
    private void findViews() {
        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
    }

    private void welcome() {
        String str = getIntent().getStringExtra("USER_NAME");
        UserHomePage.this.tvWelcome.setText("Welcome," + str);
    }
}
