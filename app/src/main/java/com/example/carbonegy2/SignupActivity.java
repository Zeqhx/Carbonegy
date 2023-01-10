package com.example.carbonegy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btn1 = (Button) findViewById(R.id.btnLogin);
        Button btn2 = (Button) findViewById(R.id.btnRegister);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });


    }
}