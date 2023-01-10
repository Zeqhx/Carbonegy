package com.example.carbonegy2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        Button btn1 = (Button) findViewById(R.id.btnSave);
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(EditProfileActivity.this, ForthFragment.class));
//
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.forthFragment, new ForthFragment()).commit();
//                //here R.id.frame_layout is id of the framelayout of fragment

            }
        });

    }
}