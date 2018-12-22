package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class PatientLogin extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                /*String name = username.getText().toString();
                String password1 = password.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    username.setError("Username should not be empty");
                }
                if (password1.length() < 10 || password1.matches("")) {
                    password.setError("Please enter a valid password");

                }*/
                Intent i=new Intent(PatientLogin.this,Visits.class);
                startActivity(i);

            }
        });

    }
}
