package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class D_EnterMobile extends AppCompatActivity {
    Button btn_search,btn_logout,btn_searchByName;
    EditText et_phoneNo;
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d__enter_mobile);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createIds();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Enqiry");
        et_phoneNo.setText("+91");
        buttonFunctions();


    }


    private void buttonFunctions() {
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PhoneNo=et_phoneNo.getText().toString();
                if(PhoneNo.matches(""))
                    et_phoneNo.setError(Html.fromHtml("<font color='#29B6F6'>Mobile Number cannot be blank</font>"));
                else if(!(PhoneNo.matches("\\+91[0-9]{10}")||PhoneNo.matches("\\+91[0-9]{13}")))
                    et_phoneNo.setError(Html.fromHtml("<font color='#29B6F6'>Mobile Number not in proper format</font>"));
                else {
                    Intent i = new Intent(D_EnterMobile.this, PatientsLists.class);
                    startActivity(i);
                }
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent i=new Intent(D_EnterMobile.this,Seperation.class);
                startActivity(i);
            }
        });
        btn_searchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(D_EnterMobile.this,SearchPatient.class);
                startActivity(i);
            }
        });
    }

    private void createIds() {
        btn_search=(Button)findViewById(R.id.btn_search);
        et_phoneNo=(EditText)findViewById(R.id.et_phoneno);
        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar1);
        btn_logout=(Button)findViewById(R.id.btn_logout);
        btn_searchByName=(Button)findViewById(R.id.btn_searchByName);
    }
}
