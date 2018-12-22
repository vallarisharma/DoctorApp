package com.example.charvee.doctorapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class PatientsLists extends AppCompatActivity {


    Button btn_addPatients,btn_cancel;
    ListView ll_Names;
    ArrayList<String> al_patientsName;
    ArrayAdapter<String> aa_names;
    PopupWindow popUpWindow;
    LinearLayout ll_addPatient;
    EditText et_PatientsName,et_PatientsAge;
    RadioButton rb_male,rb_female;
    View CustomView;
    LayoutInflater layoutInflator;

    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_lists);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        createIds();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Patients");

        aa_names=new ArrayAdapter<String>(PatientsLists.this,android.R.layout.select_dialog_item,al_patientsName);



        ll_Names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String currName=ll_Names.getItemAtPosition(position).toString();
                String currName=al_patientsName.get(position).toString();
                Log.e("my name : ", currName);
                Intent i = new Intent(PatientsLists.this, Patient_History_Main.class);
               i.putExtra("name",currName);
                startActivity(i);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.menu_add:
                createpopUp();
                break;
            // action with ID action_settings was selected
            case R.id.menu_home:
                Intent i1=new Intent(PatientsLists.this,D_EnterMobile.class);
                startActivity(i1);
                break;
            default:
                break;
        }

        return true;
    }

    private void createpopUp() {



        popUpWindow=new PopupWindow(CustomView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popUpWindow.showAtLocation(ll_addPatient, Gravity.CENTER, 0, 0);
        popUpWindow.setFocusable(true);
        popUpWindow.update();

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpWindow.dismiss();
            }
        });
        btn_addPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail=takeDetails();
                al_patientsName.add(detail);
//                aa_names.notifyDataSetChanged();

                ll_Names.setAdapter(aa_names);
                popUpWindow.dismiss();


            }
        });
    }

    private String takeDetails() {

        String name=et_PatientsName.getText().toString();
        String age=et_PatientsAge.getText().toString();
        String gender="";
        if(rb_male.isChecked())
        {
            gender="male";
            rb_male.setChecked(false);
        }
        else if(rb_female.isChecked())
        {
            gender="female";
            rb_female.setChecked(false);
        }
        String detail=""+name+"    "+age+"    "+gender;

        et_PatientsAge.setText("");
        et_PatientsName.setText("");
        return detail;
    }


    private void createIds() {

        toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        ll_Names=(ListView)findViewById(R.id.ll_names);
        ll_addPatient=(LinearLayout)findViewById(R.id.ll_patientList);
        al_patientsName=new ArrayList<String>();
        layoutInflator=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CustomView=layoutInflator.inflate(R.layout.add_patient,null);
        et_PatientsName=(EditText)CustomView.findViewById(R.id.et_PatientName);
        et_PatientsAge=(EditText)CustomView.findViewById(R.id.et_PatientAge);
        rb_male=(RadioButton)CustomView.findViewById(R.id.rb_male);
        btn_addPatients=(Button) CustomView.findViewById(R.id.bt_addPatient);
        btn_cancel=(Button) CustomView.findViewById(R.id.bt_cancel);
        rb_female=(RadioButton)CustomView.findViewById(R.id.rb_female);
    }



}
