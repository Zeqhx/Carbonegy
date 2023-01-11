package com.example.carbonegy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupActivity extends AppCompatActivity {
    private MyDBHelper dbHelper;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //original
        Spinner inputCity=findViewById(R.id.inputCity);
//        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.city, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        inputCity.setAdapter(adapter);

//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.city, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        inputCity.setAdapter(adapter);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.city, R.layout.spinner_item;


        dbHelper = new MyDBHelper(this);

        Button btnSignup = (Button) findViewById(R.id.btnLogin);
        btnSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                EditText inputEmail = (EditText) findViewById(R.id.inputFullName);
                EditText inputPassword = (EditText) findViewById(R.id.inputPassword);
                EditText inputConfirmPassword = (EditText) findViewById(R.id.inputConPassword);


                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String confirmPassword = inputConfirmPassword.getText().toString();

                // Perform input validation here to ensure that the entered data is valid

                Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
                if (!emailMatcher.matches()) {
                    inputEmail.setError("Invalid email address");
                    return;
                }


                if (email.isEmpty()) {
                    inputEmail.setError("Email is required");
                    return;
                }
                if (password.isEmpty()) {
                    inputPassword.setError("Password is required");
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    inputConfirmPassword.setError("Confirm password is required");
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    inputConfirmPassword.setError("Passwords do not match");
                    return;
                }

                // Insert the new user into the database
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("email", email);
                values.put("password", password);
                long newRowId = db.insert("users", null, values);
                Log.d("SignupActivity", "Inserting new user:" + " " + email + " " + password);
                db.close();

                if(newRowId > 0){
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                }else{
                    //Unable to insert new user
                    Toast.makeText(SignupActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }

        });
        Button btnLogin = (Button) findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                // Start the LoginActivity
                startActivity(intent);
            }
        });

    }

}