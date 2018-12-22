package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.os.Handler;



public class Seperation extends AppCompatActivity {

    Button btn_doctor,btn_patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seperation);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_doctor=(Button)findViewById(R.id.btn_doctor);
        btn_patient=(Button)findViewById(R.id.btn_patient);

        btn_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Seperation.this, DoctorLogin.class);
                startActivity(i);
            }
        });
        btn_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Seperation.this, PatientLogin.class);
                startActivity(i);
            }
        });
    }
}
