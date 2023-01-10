package com.example.carbonegy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn1 = (Button) findViewById(R.id.btnLogin);
        Button btn2 = (Button) findViewById(R.id.btnRegister);

        btn1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } });

        btn2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }});

    }

}